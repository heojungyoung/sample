package com.sample.sample.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class sampleModel {
	private Integer id;
    private String name;
    private String cntrCode;
    private String population;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCntrCode() {
		return cntrCode;
	}
	public void setCntrCode(String cntrCode) {
		this.cntrCode = cntrCode;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
    
}
