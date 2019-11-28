package com.example.demo1.service;

import java.util.List;

import com.example.demo1.entity.Country;

public interface CountryService {

	Country getByCode(String code);

	List<Country> saveFromCsv(String file);

}
