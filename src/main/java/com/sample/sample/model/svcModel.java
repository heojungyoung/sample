package com.sample.sample.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class svcModel {

	private int vaSvcId;
	private int vaCntrId;
	private String sprtYear;
	private String vaTypeCd;
	private	String vaSvcNm;
	private	String regPgmId;
	private	String mdfPgmId;
	private	String regrId;
	private	Date regDt;
	private	String mdfrId;
	private	Date mdfDt;
	private	String cntrCd;
	
	public Date getRegDt() {
		return regDt;
	}
	public Date getMdfDt() {
		return mdfDt;
	}
	public int getVaSvcId() {
		return vaSvcId;
	}
	public void setVaSvcId(int vaSvcId) {
		this.vaSvcId = vaSvcId;
	}
	public int getVaCntrId() {
		return vaCntrId;
	}
	public void setVaCntrId(int vaCntrId) {
		this.vaCntrId = vaCntrId;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	public void setMdfDt(Date mdfDt) {
		this.mdfDt = mdfDt;
	}
	public String getSprtYear() {
		return sprtYear;
	}
	public void setSprtYear(String sprtYear) {
		this.sprtYear = sprtYear;
	}
	public String getVaTypeCd() {
		return vaTypeCd;
	}
	public void setVaTypeCd(String vaTypeCd) {
		this.vaTypeCd = vaTypeCd;
	}
	public String getVaSvcNm() {
		return vaSvcNm;
	}
	public void setVaSvcNm(String vaSvcNm) {
		this.vaSvcNm = vaSvcNm;
	}
	public String getRegPgmId() {
		return regPgmId;
	}
	public void setRegPgmId(String regPgmId) {
		this.regPgmId = regPgmId;
	}
	public String getMdfPgmId() {
		return mdfPgmId;
	}
	public void setMdfPgmId(String mdfPgmId) {
		this.mdfPgmId = mdfPgmId;
	}
	public String getRegrId() {
		return regrId;
	}
	public void setRegrId(String regrId) {
		this.regrId = regrId;
	}

	public String getMdfrId() {
		return mdfrId;
	}
	public void setMdfrId(String mdfrId) {
		this.mdfrId = mdfrId;
	}

	public String getCntrCd() {
		return cntrCd;
	}
	public void setCntrCd(String cntrCd) {
		this.cntrCd = cntrCd;
	}
	
	
	
}
