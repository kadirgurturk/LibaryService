package com.kadirgurturk.LibraryService.service;

import com.kadirgurturk.LibraryService.data.entity.City;
import com.kadirgurturk.LibraryService.data.entity.Zipcode;
import com.kadirgurturk.LibraryService.data.repository.ZipcodeRepository;
import com.kadirgurturk.LibraryService.dto.requestDto.ZipCodeRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ZipcodeService {

    private final ZipcodeRepository zipcodeRepository;
    private final CityService cityService;

    @Transactional
    public Zipcode addZipcode(ZipCodeRequest zipCodeRequest){
        Zipcode zipcode = new Zipcode();
        zipcode.setName(zipCodeRequest.getName());
        if(zipCodeRequest.getCityId() == null){
            return zipcodeRepository.save(zipcode);
        }
        City city = cityService.getCity(zipCodeRequest.getCityId());
        zipcode.setCity(city);
        return zipcodeRepository.save(zipcode);
    }

    public List<Zipcode> getZipcodes(){
        return StreamSupport.stream(zipcodeRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public Zipcode getZipcode(Long zipcodeId){

        return zipcodeRepository.findById(zipcodeId).orElseThrow(() ->
                new IllegalArgumentException(
                        "zipcode with id: " + zipcodeId + " could not be found"));
    }


    public Zipcode deleteZipcode(Long zipcodeId) {
        Zipcode zipcode = getZipcode(zipcodeId);
        zipcodeRepository.delete(zipcode);
        return zipcode;
    }

    @Transactional
    public Zipcode editZipcode(Long zipcodeId, ZipCodeRequest zipcodeRequestDto) {
        Zipcode zipcode = getZipcode(zipcodeId);
        zipcode.setName(zipcodeRequestDto.getName());
        if (zipcodeRequestDto.getCityId() != null) {
            return zipcode;
        }
        City city = cityService.getCity(zipcodeRequestDto.getCityId());
        zipcode.setCity(city);
        return zipcode;
    }

    @Transactional
    public Zipcode addCityToZipcode(Long zipcodeId, Long cityId) {
        Zipcode zipcode = getZipcode(zipcodeId);
        City city = cityService.getCity(cityId);
        if (Objects.nonNull(zipcode.getCity())) {
            throw new IllegalArgumentException("zipcode already has a city");
        }
        zipcode.setCity(city);
        return zipcode;
    }

    @Transactional
    public Zipcode removeCityFromZipcode(Long zipcodeId) {
        Zipcode zipcode = getZipcode(zipcodeId);
        if (!Objects.nonNull(zipcode.getCity())) {
            throw new IllegalArgumentException("zipcode does not have a city");
        }
        zipcode.setCity(null);
        return zipcode;
    }
}
