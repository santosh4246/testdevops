package com.simplilearn.devops.testdevops.monitoring.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.devops.testdevops.monitoring.models.Country;
import com.simplilearn.devops.testdevops.monitoring.service.CountryService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/countries")
public class CountryController {
	
	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);
	
	private CountryService countryService;
	
	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@GetMapping
	public List<Country> allCountries() throws Exception {
		logger.info("Fetching all countires");
		return countryService.findAllCountries();
	}

	@GetMapping("/{id}")
	public Optional<Country> findCountryById(@PathVariable("id") int id) throws Exception {
		logger.info("Find country requested with id: "+id);
		return countryService.findCountryById(id);
	}
	
	@PostMapping("/create")
	public Country createCountry(@RequestBody Country country) throws Exception {
		logger.info("Create country requested");
		return countryService.saveCountry(country);
	}
	
	@PutMapping("/update")
	public Country updateCountry(@RequestBody Country country) throws Exception {
		logger.info("Update country requested");
		return countryService.saveCountry(country);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteteCountry(@PathVariable("id") int id) throws Exception {
		logger.info("Delete country requested with id: "+id);
		countryService.deleteCountryById(id);
	}
}
