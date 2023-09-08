package com.kadirgurturk.LibraryService.controller;

import com.kadirgurturk.LibraryService.data.entity.City;
import com.kadirgurturk.LibraryService.data.entity.Zipcode;
import com.kadirgurturk.LibraryService.dto.requestDto.ZipCodeRequest;
import com.kadirgurturk.LibraryService.dto.responseDto.ApıResponse;
import com.kadirgurturk.LibraryService.service.ZipcodeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zipcode")
@AllArgsConstructor
public class ZipcodeController {

    private final ZipcodeService zipcodeService;


    @PostMapping()
    public ResponseEntity<?> addZipcode(@RequestBody @Valid final ZipCodeRequest zipcodeRequestDto) {
        Zipcode zipcode = zipcodeService.addZipcode(zipcodeRequestDto);

        ApıResponse<Zipcode> apıResponse = new ApıResponse<>();

        apıResponse.setResults(zipcode);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getZipcode(@PathVariable final Long id) {
        Zipcode zipcode = zipcodeService.getZipcode(id);
        ApıResponse<Zipcode> apıResponse = new ApıResponse<>();

        apıResponse.setResults(zipcode);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getZipcodes() {
        List<Zipcode> zipcodes = zipcodeService.getZipcodes();
        ApıResponse< List<Zipcode>> apıResponse = new ApıResponse<>();

        apıResponse.setResults(zipcodes);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteZipcode(@PathVariable final Long id) {
        Zipcode zipcode = zipcodeService.deleteZipcode(id);
        ApıResponse<Zipcode> apıResponse = new ApıResponse<>();

        apıResponse.setResults(zipcode);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> editZipcode(@RequestBody @Valid final ZipCodeRequest zipcodeRequestDto,
                                               @PathVariable final Long id) {
        Zipcode zipcode = zipcodeService.editZipcode(id, zipcodeRequestDto);
        ApıResponse<Zipcode> apıResponse = new ApıResponse<>();

        apıResponse.setResults(zipcode);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> addCity(@RequestParam("city") final Long cityId,
                                           @RequestParam("zipcode") final Long zipcodeId) {
        Zipcode zipcode = zipcodeService.addCityToZipcode(zipcodeId, cityId);
        ApıResponse<Zipcode> apıResponse = new ApıResponse<>();

        apıResponse.setResults(zipcode);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> deleteCity(@RequestParam("zipcode") final Long zipcode) {
        Zipcode zipcodeNew = zipcodeService.removeCityFromZipcode(zipcode);
        ApıResponse<Zipcode> apıResponse = new ApıResponse<>();

        apıResponse.setResults(zipcodeNew);
        apıResponse.setStatus("Success");

        return new ResponseEntity<>(apıResponse, HttpStatus.OK);
    }
}
