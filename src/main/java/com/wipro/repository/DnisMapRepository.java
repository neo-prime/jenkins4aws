package com.wipro.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.wipro.Entity.DnisMapData;

@Repository
public interface DnisMapRepository extends CrudRepository<DnisMapData, String> {

	@Transactional
	@Modifying
	@Query("update DnisMapData v set v.OUTAGE_MSG=?1 where v.COUNTRY=?2")
	void updateStatus(char outageStatus,String country);
}
