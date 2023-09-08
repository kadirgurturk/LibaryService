package com.kadirgurturk.LibraryService.controller;

import com.kadirgurturk.LibraryService.data.entity.City;
import com.kadirgurturk.LibraryService.dto.requestDto.CityRequest;
import com.kadirgurturk.LibraryService.dto.responseDto.ApıResponse;
import com.kadirgurturk.LibraryService.service.CityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping()
    public ResponseEntity<?> addCity(@RequestBody @Valid final CityRequest cityRequestDto) {
        City city = cityService.addCity(cityRequestDto);

        ApıResponse<City> apıResponse = new ApıResponse<>();

        apıResponse.setResults(city);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCityById(@PathVariable final Long id) {

        City city = cityService.getCity(id);

        ApıResponse<City> apıResponse = new ApıResponse<>();

        apıResponse.setResults(city);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<?> getCities() {
        List<City> cities = cityService.getCities();

        ApıResponse<List<City>> apıResponse = new ApıResponse<>();

        apıResponse.setResults(cities);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable final Long id) {
        City city = cityService.deleteCity(id);

        ApıResponse<City> apıResponse = new ApıResponse<>();

        apıResponse.setResults(city);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> editCity(@RequestBody @Valid final CityRequest cityRequestDto,
                                         @PathVariable final Long id) {
        City city = cityService.editCity(id, cityRequestDto);
        ApıResponse<City> apıResponse = new ApıResponse<>();

        apıResponse.setResults(city);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

}
