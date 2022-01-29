package com.simplilearn.devops.testdevops.monitoring.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.simplilearn.devops.testdevops.monitoring.models.Country;
import com.simplilearn.devops.testdevops.monitoring.repositories.CountryRepository;


@Service
public class CountryService {
	
	private static final Logger logger = LoggerFactory.getLogger(CountryService.class);
	
	private CountryRepository countryRepository;

	public CountryService(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	public List<Country> findAllCountries() throws Exception {
		List<Country> allCoutryList = null;
		try {
			allCoutryList = countryRepository.findAll();
			logger.info("Country List Generated");
		} catch (DataAccessException e) {
			logger.error("Coudn't fetch all countries. " + e);
			throw new Exception("Coudn't fetch all countries. See details in log.");
		}
		return allCoutryList;
	}
	
	public Optional<Country> findCountryById(int id) throws Exception {
		Optional<Country> foundCountry = null;
		try {
			foundCountry = countryRepository.findById(id);
			logger.info("Country Found by id");
		} catch (DataAccessException e) {
			logger.error("Coudn't find Country with id: " + id + ". " + e);
			throw new Exception("Coudn't find Country. See details in log.");
		}
		return foundCountry;
	}
	
	public Optional<Country> findCountryByName(String name) throws Exception {
		Optional<Country> foundCountry = null;
		try {
			foundCountry = countryRepository.findByName(name);
			logger.info("Country Found by name");
		} catch (DataAccessException e) {
			logger.error("Coudn't find Country with name: " + name + ". " + e);
			throw new Exception("Coudn't find Country. See details in log.");
		}
		return foundCountry;
	}
	
	public Country saveCountry(Country country) throws Exception {
		Country createdCountry = null;
		try {
			createdCountry = countryRepository.save(country);
			logger.info("Country Created");
		} catch (DataAccessException e) {
			logger.error("Coudn't create Country. " + e);
			throw new Exception("Coudn't create Country. See details in log.");
		}
		return createdCountry;
	}
	
	public Country updateCountry(Country country) throws Exception {
		Country updatedCountry = null;
		try {
			Optional<Country> countryOptional = countryRepository.findById(country.getId());
			if(countryOptional != null) {
				updatedCountry = countryRepository.save(country);
				logger.info("Country Updated");
			} else {
				logger.error("No country found for update with country id: "+country.getId());
			}
		} catch (DataAccessException e) {
			logger.error("Coudn't update Country. " + e);
			throw new Exception("Coudn't update Country. See details in log.");
		}		
		return updatedCountry;
	}
	
	public void deleteCountryById(int id) throws Exception {
		Optional<Country> foundCountry = null;
		try {
			foundCountry = countryRepository.findById(id);
			if(foundCountry != null) {
				countryRepository.deleteById(id);
				logger.info("Country deleted");
				
			}
		} catch (DataAccessException e) {
			logger.error("Coudn't find Country with id: " + id + ". " + e);
			throw new Exception("Coudn't find Country. See details in log.");
		}
	}

}
