package com.model;

import java.io.Serializable;
import java.util.Date;

import com.dao.DbmsService;

public class Employee implements Serializable{
	
	private static final long serialVersionUID = 2L;
	private String e_id;
	private String e_fname;
	private String e_lname;
	private String e_gender;
	private Date e_dob;
	private Date e_doj;
	private String e_btype;
	private String e_contact;
	private String e_eaddr;
	private String e_pass;
	private String e_addr;
	private String e_recovery_id;
	private int disease;
	private String e_workedEarlier;
	private String e_workedDesignation;
	private String e_workedLocation;
	private int e_workedExp;
	private int admin;
	
	public String getE_pass() {
		return e_pass;
	}

	public void setE_pass(String e_pass) {
		this.e_pass = e_pass;
	}

	public int getAdmin() {
		return admin;
	}

	public Employee() {
	e_id = "BE" + DbmsService.getMaxId("BE");
	}

	public synchronized String getE_id() {
		return e_id;
	}
	
	public synchronized String getE_fname() {
		return e_fname;
	}
	public synchronized void setE_fname(String e_fname) {
		this.e_fname = e_fname;
	}
	public synchronized String getE_lname() {
		return e_lname;
	}
	public synchronized void setE_lname(String e_lname) {
		this.e_lname = e_lname;
	}
	public synchronized String getE_gender() {
		return e_gender;
	}
	public synchronized void setE_gender(String e_gender) {
		this.e_gender = e_gender;
	}
	public synchronized Date getE_dob() {
		return e_dob;
	}
	public synchronized void setE_dob(Date e_dob) {
		this.e_dob = e_dob;
	}
	public synchronized Date getE_doj() {
		return e_doj;
	}
	public synchronized void setE_doj(Date e_doj) {
		this.e_doj = e_doj;
	}
	public synchronized String getE_btype() {
		return e_btype;
	}
	public synchronized void setE_btype(String e_btype) {
		this.e_btype = e_btype;
	}
	public synchronized String getE_contact() {
		return e_contact;
	}
	public synchronized void setE_contact(String e_contact) {
		this.e_contact = e_contact;
	}
	public synchronized String getE_eaddr() {
		return e_eaddr;
	}
	public synchronized void setE_eaddr(String e_eaddr) {
		this.e_eaddr = e_eaddr;
	}
	public synchronized String getE_addr() {
		return e_addr;
	}
	public synchronized void setE_addr(String e_addr) {
		this.e_addr = e_addr;
	}
	public synchronized String getE_recovery_id() {
		return e_recovery_id;
	}
	public synchronized void setE_recovery_id(String e_recovery_id) {
		this.e_recovery_id = e_recovery_id;
	}
	public synchronized int getDisease() {
		return disease;
	}
	public synchronized void setDisease(int disease) {
		this.disease = disease;
	}
	public synchronized String getE_workedEarlier() {
		return e_workedEarlier;
	}
	public synchronized void setE_workedEarlier(String e_workedEarlier) {
		this.e_workedEarlier = e_workedEarlier;
	}
	public synchronized String getE_workedDesignation() {
		return e_workedDesignation;
	}
	public synchronized void setE_workedDesignation(String e_workedDesignation) {
		this.e_workedDesignation = e_workedDesignation;
	}
	public synchronized String getE_workedLocation() {
		return e_workedLocation;
	}
	public synchronized void setE_workedLocation(String e_workedLocation) {
		this.e_workedLocation = e_workedLocation;
	}
	public synchronized int getE_workedExp() {
		return e_workedExp;
	}
	public synchronized void setE_workedExp(int e_workedExp) {
		this.e_workedExp = e_workedExp;
	}
	public static synchronized long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employee [e_id=" + e_id + ", e_fname=" + e_fname + ", e_lname="
				+ e_lname + ", e_gender=" + e_gender + ", e_dob=" + e_dob
				+ ", e_doj=" + e_doj + ", e_btype=" + e_btype + ", e_contact="
				+ e_contact + ", e_eaddr=" + e_eaddr + ", e_addr=" + e_addr
				+ ", e_recovery_id=" + e_recovery_id + ", disease=" + disease
				+ ", e_workedEarlier=" + e_workedEarlier
				+ ", e_workedDesignation=" + e_workedDesignation
				+ ", e_workedLocation=" + e_workedLocation + ", e_workedExp="
				+ e_workedExp + "]";
	}
	
	
}
