package com.wipro.service;

import java.util.Collection;
import java.util.List;

import com.wipro.Entity.data;

public interface DataService {

	public Collection<data> getDatas();

	public List<String> selectDistinctLanguage();

	/**
	 * 
	 * @param language 
	 * @return
	 */
	public List<String> selectCountry(String language);

	public void updateStatus(char outageStatus, String country);
}
