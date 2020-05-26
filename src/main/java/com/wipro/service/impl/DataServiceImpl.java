package com.wipro.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.Entity.data;
import com.wipro.repository.DnisMapRepository;
import com.wipro.repository.LanguageMapRepository;
import com.wipro.repository.testRepo;
import com.wipro.service.DataService;

/**
 * 
 * @author GA386164
 *
 */
@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private testRepo repo;
	
	@Autowired
	private DnisMapRepository dnisMapRepository;
	
	@Autowired
	private LanguageMapRepository languageMapRepository;

	@Override
	public Collection<data> getDatas() {
		return this.repo.getData();
	}
	
	@Override
	public List<String> selectDistinctLanguage() {
		return languageMapRepository.selectDistinctLanguage();
	}
 
	@Override
	public List<String> selectCountry(String language) {
		return languageMapRepository.selectCountry(language);
	}

	@Override
	public void updateStatus(char outageStatus, String country) {
		dnisMapRepository.updateStatus(outageStatus, country);
	}
}
