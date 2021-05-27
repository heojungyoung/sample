package com.sample.sample.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class bowlerModel {

	private int bowlerID;
	private String bowlerLastName;
	private String bowlerFirstName;
	private String bowlerMiddleInit;
	private String bowlerAddress;
	private String bowlerCity;
	private String bowlerState;
	private String bowlerZip;
	private String bowlerPhoneNumber;
	private int teamID;
	
	public int getBowlerID() {
		return bowlerID;
	}
	public void setBowlerID(int bowlerID) {
		this.bowlerID = bowlerID;
	}
	public String getBowlerLastName() {
		return bowlerLastName;
	}
	public void setBowlerLastName(String bowlerLastName) {
		this.bowlerLastName = bowlerLastName;
	}
	public String getBowlerFirstName() {
		return bowlerFirstName;
	}
	public void setBowlerFirstName(String bowlerFirstName) {
		this.bowlerFirstName = bowlerFirstName;
	}
	public String getBowlerMiddleInit() {
		return bowlerMiddleInit;
	}
	public void setBowlerMiddleInit(String bowlerMiddleInit) {
		this.bowlerMiddleInit = bowlerMiddleInit;
	}
	public String getBowlerAddress() {
		return bowlerAddress;
	}
	public void setBowlerAddress(String bowlerAddress) {
		this.bowlerAddress = bowlerAddress;
	}
	public String getBowlerCity() {
		return bowlerCity;
	}
	public void setBowlerCity(String bowlerCity) {
		this.bowlerCity = bowlerCity;
	}
	public String getBowlerState() {
		return bowlerState;
	}
	public void setBowlerState(String bowlerState) {
		this.bowlerState = bowlerState;
	}
	public String getBowlerZip() {
		return bowlerZip;
	}
	public void setBowlerZip(String bowlerZip) {
		this.bowlerZip = bowlerZip;
	}
	public String getBowlerPhoneNumber() {
		return bowlerPhoneNumber;
	}
	public void setBowlerPhoneNumber(String bowlerPhoneNumber) {
		this.bowlerPhoneNumber = bowlerPhoneNumber;
	}
	public int getTeamID() {
		return teamID;
	}
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	
	
	
	
	
}
