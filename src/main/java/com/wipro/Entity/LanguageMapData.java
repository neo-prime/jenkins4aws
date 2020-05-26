package com.wipro.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
		
		public LanguageMapData() {
			// TODO Auto-generated constructor stub
		}
		public LanguageMapData(String country, int langOrder, String language) {
			super();
			Country = country;
			this.langOrder = langOrder;
			this.language = language;
		}
		public String getCountry() {
			return Country;
		}
		public void setCountry(String country) {
			Country = country;
		}
		public int getLangOrder() {
			return langOrder;
		}
		public void setLangOrder(int langOrder) {
			this.langOrder = langOrder;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
}
