package com.kadirgurturk.LibraryService.service;

import com.kadirgurturk.LibraryService.data.entity.City;
import com.kadirgurturk.LibraryService.data.repository.CityRepository;
import com.kadirgurturk.LibraryService.dto.requestDto.CityRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CityService {

    private CityRepository cityRepository;


    @Transactional
    public City addCity(CityRequest cityRequest) {
        City city = new City();
        city.setName(cityRequest.getName());
        return cityRepository.save(city);
    }


    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        cityRepository.findAll().forEach(cities::add);
        return cities;
    }


    public City getCity(Long cityId) {
        return cityRepository.findById(cityId).orElseThrow(() ->
                new IllegalArgumentException("city with cityId: " + cityId + " could not be found"));
    }


    public City deleteCity(Long cityId) {
        City city = getCity(cityId);
        cityRepository.delete(city);
        return city;
    }

    @Transactional
    public City editCity(Long cityId, CityRequest cityRequestDto) {
        City cityToEdit = getCity(cityId);
        cityToEdit.setName(cityRequestDto.getName());
        return cityToEdit;
    }

}
