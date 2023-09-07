package com.kadirgurturk.LibraryService.controller;

import com.kadirgurturk.LibraryService.data.entity.Zipcode;
import com.kadirgurturk.LibraryService.dto.requestDto.ZipCodeRequest;
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
    public ResponseEntity<Zipcode> addZipcode(@RequestBody @Valid final ZipCodeRequest zipcodeRequestDto) {
        Zipcode zipcode = zipcodeService.addZipcode(zipcodeRequestDto);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zipcode> getZipcode(@PathVariable final Long id) {
        Zipcode zipcode = zipcodeService.getZipcode(id);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Zipcode>> getZipcodes() {
        List<Zipcode> zipcodes = zipcodeService.getZipcodes();
        return new ResponseEntity<>(zipcodes, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Zipcode> deleteZipcode(@PathVariable final Long id) {
        Zipcode zipcode = zipcodeService.deleteZipcode(id);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Zipcode> editZipcode(@RequestBody @Valid final ZipCodeRequest zipcodeRequestDto,
                                               @PathVariable final Long id) {
        Zipcode zipcode = zipcodeService.editZipcode(id, zipcodeRequestDto);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Zipcode> addCity(@RequestParam("city") final Long cityId,
                                           @RequestParam("zipcode") final Long zipcodeId) {
        Zipcode zipcode = zipcodeService.addCityToZipcode(zipcodeId, cityId);
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @PostMapping("/{zipcodeId}")
    public ResponseEntity<Zipcode> deleteCity(@RequestParam("zipcode") final Long zipcode) {
        Zipcode zipcodeNew = zipcodeService.removeCityFromZipcode(zipcode);
        return new ResponseEntity<>(zipcodeNew, HttpStatus.OK);
    }
}
