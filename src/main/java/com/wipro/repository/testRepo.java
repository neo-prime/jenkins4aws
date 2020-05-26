package com.wipro.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wipro.Entity.data;

@Repository
public class testRepo {

	static private Map<Integer, data> datas;
	static {
		datas = new HashMap<Integer, data>();
		{
			datas.put(1, new data("Gaurav", 1));
			datas.put(2, new data("kishore", 2));
		}
	}

	public Collection<data> getData() {
		return datas.values();
	}
}
