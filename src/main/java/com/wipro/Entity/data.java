package com.wipro.Entity;

/*@Entity
@Table(name = "DNIS_MAP") @SecondaryTable(name="LANGUAGE_MAP")*/

public class data {
	/*@Id
	@GeneratedValue
	@Column(name = "COUNTRY")
	private String COUNTRY;
	@Column(name="OUTAGE_MSG")
	private char OUTAGE_MSG;
	public String getCountry() {
		return COUNTRY;
	}
	public void setCountry(String country) {
		this.COUNTRY = country;
	}
	public char getOutageMsg() {
		return getOutageMsg();
	}
	public void setOutageMsg(char outageMsg) {
		this.OUTAGE_MSG = outageMsg;
	}
	
	@Column(name = "LANG_ORDER",table="")
	private int langOrder;
	@Column(name ="LANGUAGE")
	private String language;
	
	private int getLANG_ORDER() {
		return langOrder;
	}
	private void setLANG_ORDER(int langOrder) {
		langOrder = langOrder;
	}
	
	private String getLanguage() {
		return language;
	}
	private void setLanguage(String language) {
		this.language = language;
	}
	
}
@Entity
@Table(name = "LANGUAGE_MAP")
public class LanguageMapData {
		@Id
		@GeneratedValue
		@Column(name = "COUNTRY")
		private String Country;
		@Column(name = "LANG_ORDER")
		private int langOrder;
		@Column(name ="LANGUAGE")
		private String language;
		

		private String getCountry() {
			return Country;
		}
		private void setCountry(String country) {
			Country = country;
		}
		private int getLANG_ORDER() {
			return langOrder;
		}
		private void setLANG_ORDER(int langOrder) {
			langOrder = langOrder;
		}
		
		private String getLanguage() {
			return language;
		}
		private void setLanguage(String language) {
			this.language = language;
		}
		*/
		private String name;
		private int number;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public data(String name, int number) {
			super();
			this.name = name;
			this.number = number;
		}
		public data() {
			// TODO Auto-generated constructor stub
		}
		
}
