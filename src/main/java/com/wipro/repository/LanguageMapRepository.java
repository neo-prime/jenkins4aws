package com.wipro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.Entity.LanguageMapData;

@Repository
public interface LanguageMapRepository extends CrudRepository<LanguageMapData, String> {

	List<LanguageMapData> findAll();

	@Query("SELECT DISTINCT v.language from LanguageMapData v")
	List<String> selectDistinctLanguage();

	@Query("SELECT DISTINCT v.Country from LanguageMapData v where v.language=?1 and v.langOrder=1")
	List<String> selectCountry(String lang);
}
