package com.wipro.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DNIS_MAP")
public class DnisMapData {

	@Id
	@GeneratedValue
	@Column(name = "COUNTRY")
	private String COUNTRY;
	
	@Column(name="OUTAGE_MSG")
	private char OUTAGE_MSG;
	
	public DnisMapData(String country, char outageMsg) {
		super();
		this.COUNTRY = country;
		this.OUTAGE_MSG = outageMsg;
	}
	public DnisMapData() {
		// TODO Auto-generated constructor stub
	}
	public String getCOUNTRY() {
		return COUNTRY;
	}
	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}
	public char getOUTAGE_MSG() {
		return OUTAGE_MSG;
	}
	public void setOUTAGE_MSG(char oUTAGE_MSG) {
		OUTAGE_MSG = oUTAGE_MSG;
	}
}
