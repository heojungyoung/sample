package com.sample.sample.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BowlerModel {

	private int BowlerID;
	private String BowlerLastName;
	private String BowlerFirstName;
	private String BowlerMiddleInit;
	private String BowlerAddress;
	private String BowlerCity;
	private String BowlerState;
	private String BowlerZip;
	private String BowlerPhoneNumber;
	private int TeamID;
	
	public int getBowlerID() {
		return BowlerID;
	}
	public void setBowlerID(int bowlerID) {
		BowlerID = bowlerID;
	}
	public String getBowlerLastName() {
		return BowlerLastName;
	}
	public void setBowlerLastName(String bowlerLastName) {
		BowlerLastName = bowlerLastName;
	}
	public String getBowlerFirstName() {
		return BowlerFirstName;
	}
	public void setBowlerFirstName(String bowlerFirstName) {
		BowlerFirstName = bowlerFirstName;
	}
	public String getBowlerMiddleInit() {
		return BowlerMiddleInit;
	}
	public void setBowlerMiddleInit(String bowlerMiddleInit) {
		BowlerMiddleInit = bowlerMiddleInit;
	}
	public String getBowlerAddress() {
		return BowlerAddress;
	}
	public void setBowlerAddress(String bowlerAddress) {
		BowlerAddress = bowlerAddress;
	}
	public String getBowlerCity() {
		return BowlerCity;
	}
	public void setBowlerCity(String bowlerCity) {
		BowlerCity = bowlerCity;
	}
	public String getBowlerState() {
		return BowlerState;
	}
	public void setBowlerState(String bowlerState) {
		BowlerState = bowlerState;
	}
	public String getBowlerZip() {
		return BowlerZip;
	}
	public void setBowlerZip(String bowlerZip) {
		BowlerZip = bowlerZip;
	}
	public String getBowlerPhoneNumber() {
		return BowlerPhoneNumber;
	}
	public void setBowlerPhoneNumber(String bowlerPhoneNumber) {
		BowlerPhoneNumber = bowlerPhoneNumber;
	}
	public int getTeamID() {
		return TeamID;
	}
	public void setTeamID(int teamID) {
		TeamID = teamID;
	}
	
	
	
}
