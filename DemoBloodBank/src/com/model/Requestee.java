package com.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;

import com.Service.BasicService;
import com.dao.DbmsService;

public class Requestee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static String r_id;
	private String r_fname;
	private String r_lname;
	private String r_gender;
	private String r_weight;
	private java.util.Date r_dob;
	private String r_btype;
	private String r_contact;
	private String r_eaddr;
	private String r_addr;
	private String r_doctor_name;
	private String r_hospital_name;
	private int autologous;
	private int q1;
	private int q2;
	private int q3;
	private int accident;
	
	//static int count = 600;
	/*public Requestee(String r_fname, String r_lname, java.util.Date r_dob, String r_btype, String r_contact, String r_eaddr, String r_addr,
			String r_hospital_name,String dname,int q01,int q02,int q03) {
		//super();
		this.r_id= r_fname.substring(0,2) + count ;
		this.r_fname = r_fname;
		this.r_lname = r_lname;
		this.r_dob = r_dob;
		this.r_btype = r_btype;
		this.r_contact = r_contact;
		this.r_eaddr = r_eaddr;
		this.r_addr = r_addr;
		this.r_hospital_name = r_hospital_name;
		this.r_doctor_name= r_doctor_name;
		this.q1=q01;
		this.q2=q02;
		this.q3=q03;
	}*/
	
	
	
	public Requestee() {
		r_id = "BR" + DbmsService.getMaxId("BR");
		System.out.println("get max id worked with id "+r_id);
		System.out.println("new id is " + this.getR_id());
	}
	
	/*public static int toInt() {
		 DbmsService db = new DbmsService();
			int count =500;
			ResultSet rs = db.GetReguesterValue();
			
			System.out.println(rs.toString());
			System.out.println("Reuqestee : Retuned rs in written");
			if(rs!=null) {
				System.out.println("Reuqestee : rs not nullproved by if stmt");
				String str = BasicService.getLastId(rs);
				System.out.println("Reuqestee : str added");
				if(str!=null) {
					System.out.println("Reuqestee : str in not null proved by if stmt");
					String cnt = str.substring(2, 5);
					
					System.out.println("Reuqestee : cnt = "+cnt);
					
					count = Integer.parseInt(cnt);
					System.out.println("Reuqestee : count = "+count);
					count++;
					System.out.println("Reuqestee : new count = "+count);
				}else { System.out.println("Reuqestee : Str is null ! ");}
			}
		return count;
	}*/
	
	/*public static String getId() {
		int count = 500;
		
		r_id = "BR" + (++count);
	
		return null;
	}*/

	public synchronized int getAutologous() {
		return autologous;
	}

	public synchronized void setAutologous(int autologous) {
		this.autologous = autologous;
	}



	public synchronized String getR_fname() {
		return r_fname;
	}
	public synchronized void setR_fname(String r_fname) {
		this.r_fname = r_fname;
	}
	public synchronized String getR_lname() {
		return r_lname;
	}
	public synchronized void setR_lname(String r_lname) {
		this.r_lname = r_lname;
	}
	public synchronized String getR_gender() {
		return r_gender;
	}
	public synchronized void setR_gender(String r_gender) {
		this.r_gender = r_gender;
	}
	public synchronized java.util.Date getR_dob() {
		return r_dob;
	}
	public synchronized void setR_dob(java.util.Date r_dob) {
		this.r_dob = r_dob;
	}
	public synchronized String getR_btype() {
		return r_btype;
	}
	public synchronized void setR_btype(String r_btype) {
		this.r_btype = r_btype;
	}
	public synchronized String getR_contact() {
		return r_contact;
	}
	public synchronized void setR_contact(String r_contact) {
		this.r_contact = r_contact;
	}
	public synchronized String getR_eaddr() {
		return r_eaddr;
	}
	public synchronized void setR_eaddr(String r_eaddr) {
		this.r_eaddr = r_eaddr;
	}
	public synchronized String getR_addr() {
		return r_addr;
	}
	public synchronized void setR_addr(String r_addr) {
		this.r_addr = r_addr;
	}
	public synchronized String getR_doctor_name() {
		return r_doctor_name;
	}
	public synchronized void setR_doctor_name(String r_doctor_name) {
		this.r_doctor_name = r_doctor_name;
	}
	public synchronized String getR_hospital_name() {
		return r_hospital_name;
	}
	public synchronized void setR_hospital_name(String r_hospital_name) {
		this.r_hospital_name = r_hospital_name;
	}

	public synchronized int getQ1() {
		return q1;
	}

	public synchronized void setQ1(int q1) {
		this.q1 = q1;
	}

	public synchronized int getQ2() {
		return q2;
	}

	public synchronized void setQ2(int q2) {
		this.q2 = q2;
	}

	public synchronized int getQ3() {
		return q3;
	}

	public synchronized void setQ3(int q3) {
		this.q3 = q3;
	}
	
	public static synchronized long getSerialversionuid() {
		return serialVersionUID;
	}
	public synchronized String getR_id() {
		return r_id;
	}
	
	public synchronized int getAccident() {
		return accident;
	}

	public synchronized void setAccident(int accident) {
		this.accident = accident;
	}

	public String getR_weight() {
		return r_weight;
	}

	public void setR_weight(String r_weight) {
		this.r_weight = r_weight;
	}

	@Override
	public String toString() {
		return "Requestee [r_fname=" + r_fname + ", r_lname=" + r_lname + ", r_gender=" + r_gender + ", r_weight="
				+ r_weight + ", r_dob=" + r_dob + ", r_btype=" + r_btype + ", r_contact=" + r_contact + ", r_eaddr="
				+ r_eaddr + ", r_addr=" + r_addr + ", r_doctor_name=" + r_doctor_name + ", r_hospital_name="
				+ r_hospital_name + ", autologous=" + autologous + ", q1=" + q1 + ", q2=" + q2 + ", q3=" + q3
				+ ", accident=" + accident + "]";
	}
}