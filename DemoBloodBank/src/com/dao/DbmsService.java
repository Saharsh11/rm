package com.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;

import javax.servlet.http.HttpSession;

import com.model.Emp;
import com.model.Employee;
import com.model.Requestee;
//import com.sun.org.apache.bcel.internal.generic.Type;
//import com.sun.xml.internal.ws.wsdl.writer.document.Types;

import jdk.nashorn.internal.codegen.types.Type;
import oracle.jdbc.OracleTypes;

public class DbmsService{
	static Connection conn=DButil.getMyConnection();
	
	//private static org.apache.log4j.Logger logs = Logger.getLogger(DbmsService.class);
	
	public static int chkCredentials(String unm,String pwd){
		
		//PropertyConfigurator.configure("./Rsources/log4j.properties");
		int ans=0;
		try {
			CallableStatement cs=conn.prepareCall("{call Chkcredentials_16049(?)}");
			System.out.println("DbmsService.chkCredentials : stmt called");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			System.out.println("register out parametered ");

			int n=cs.executeUpdate();
			
			ResultSet rs=(ResultSet) cs.getObject(1);
			
			if(n>0){
				System.out.println("DbmsService.chkCredentials : Statement Executed ... ");
			}else{System.out.println("DbmsService.chkCredentials : Stmt not executed");}
			
			String uname,pass;
			
			while(rs.next()){
				
				System.out.println("\n DbmsService.chkCredentials : in while ... \n ");
				
				uname=rs.getString(1);
				System.out.println("DbmsService.chkCredentials : first column value added with cred id... ");
				pass=rs.getString(3);
				
				System.out.println("DbmsService.chkCredentials : Second column value added with pwd... ");
			
			if((uname.equals(unm))&&(!pass.equals(pwd))||((!uname.equals(unm))&&(pass.equals(pwd)))){
				System.out.println("DbmsService.chkCredentials : User Exists,incorrect userid or password.");
				ans=2;
			}else if((uname.equals(unm))&&(pass.equals(pwd))){
				System.out.println("DbmsService.chkCredentials : User Exists !!");
				ans=1;
			}
		}
		} catch (SQLException e) {
			System.out.println("DbmsService.chkCredentials : User does not exists ... ");
			return 0;
		}
		return ans;
	}
	
	
	
	public static boolean userPwdChk(String uid, String empid, Date doj){
		boolean ans=false;
		try {
			CallableStatement cs = conn.prepareCall("{call DisplayEmpCred_160491(?,?,?)}");
			cs.setString(1, uid);
			cs.registerOutParameter(2, OracleTypes.VARCHAR);
			cs.registerOutParameter(3, OracleTypes.DATE);
			
			int n= cs.executeUpdate();
			
			if(n>0){
				System.out.println("DbmsService.userPwdChk : Statement called !! ");
			}
			String eid = cs.getString(2);
			System.out.println("DbmsService.userPwdChk : EMPLOYEE ID called AS "+eid+"!! ");
			Date doj1=(Date) cs.getDate(3);
			System.out.println("DbmsService.userPwdChk : date called as "+doj1+" !! ");
			
				if((empid.equalsIgnoreCase(eid))&&(doj1.equals(doj))){
					System.out.println("DbmsService.userPwdChk : User Found ! ");
					ans=true;
			}
			
		} catch (SQLException e) {
			System.out.println("DbmsService.userPwdChk : User not Found due db error!");
			return false;
		}
		return ans;
	}
	
	
	
	public static ResultSet retriveType(){
		ResultSet rs = null;
		
		try {
			CallableStatement cs = conn.prepareCall("{call RetriveBloodType_16049(?)}");
			
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			
			cs.executeQuery();
			
			rs = (ResultSet) cs.getObject(1);
			
		} catch (SQLException e) {
			System.out.println("DbmsService.retriveType : Stmt is not executed ! ");
		}
		return rs;
	}
	
	
	
	public static int regInDB(Requestee r ){
		int n=0;
		try {
			CallableStatement cs = conn.prepareCall("{call InsertRequesterInDb_xbbnlju(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			//int flag = 0;
			cs.setString(1, r.getR_id());
			cs.setString(2,r.getR_fname());
			cs.setString(3, r.getR_lname());
			cs.setString(4, r.getR_gender());
			cs.setString(5, r.getR_weight());
			cs.setDate(6, (Date) r.getR_dob());
			cs.setString(7, r.getR_btype());
			cs.setString(8, r.getR_contact());
			cs.setString(9, r.getR_eaddr());
			cs.setString(10, r.getR_addr());
			cs.setString(11, r.getR_doctor_name());
			cs.setString(12, r.getR_hospital_name());
			cs.setInt(13, r.getQ1());
			cs.setInt(14, r.getQ2());
			cs.setInt(15, r.getQ3());
			cs.setInt(16, r.getAutologous());
			cs.registerOutParameter(17, Types.INTEGER);
			n=cs.executeUpdate();
			if(cs.getInt(17)==1){
				System.out.println("DbmsService.regInDB : Data added");
				n=1;
			}else{
				System.out.println("DbmsService.regInDB : Can't Data added");
			}
		} catch (SQLException e) {
			System.out.println("DbmsService.regInDB : Can't add data ! ");
			e.printStackTrace();
		}
		return n;
	}
	
	
	
	public static int EmpInDb(Employee e,String cid){
		int n=0;
		try {
			CallableStatement cs = conn.prepareCall("{call InsertEmployeeInDb_16049(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			cs.setString(1,e.getE_id());
			cs.setString(2,e.getE_fname());
			cs.setString(3,e.getE_lname());
			cs.setString(4,e.getE_gender());
			cs.setDate(5, (Date) e.getE_dob());
			cs.setDate(6, (Date) e.getE_doj());
			cs.setString(7, e.getE_btype());
			cs.setString(8,e.getE_contact());
			cs.setString(9,e.getE_eaddr());
			cs.setString(10, e.getE_pass());
			cs.setString(11,e.getE_addr());
			cs.setString(12,e.getE_recovery_id());
			cs.setInt(13, e.getDisease());
			cs.setString(14,e.getE_workedEarlier());
			cs.setString(15,e.getE_workedDesignation());
			cs.setString(16,e.getE_workedLocation());
			cs.setInt(17, e.getE_workedExp());
			cs.registerOutParameter(18, OracleTypes.VARCHAR);
			n = cs.executeUpdate();
			cid =(String) cs.getObject(18);
			System.out.println("DbmsService.EmpInDb : Data added");
			System.out.println("DbmsService.EmpInDb : cred id is " + cid);
		} catch (SQLException e1) {
			System.out.println("DbmsService.EmpInDb : Can't add data ! ");	
			e1.printStackTrace();
		}
		return n;
	}
	
	
	public ResultSet GetEmplyeeValue(){
		ResultSet rs = null;
		try {
			CallableStatement cs = conn.prepareCall("{call Get_employee_table(?)}",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY,ResultSet.FETCH_REVERSE);
			
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			
			cs.executeQuery();
			
			rs= (ResultSet) cs.getObject(1);
		} catch (SQLException e) {
			System.out.println("DbmsService.GetEmplyeeValue : Connection not established ! ");
			rs=null;
			e.printStackTrace();
		}
		return rs;
	}
	
	
	
	
	public ResultSet GetReguesterValue(){
		ResultSet rs = null;
		try {
			CallableStatement cs = conn.prepareCall("{call Get_requester_table(?)}",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY,ResultSet.FETCH_REVERSE);
			
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			
			cs.executeQuery();
			
			rs= (ResultSet) cs.getObject(1);
			
			
		} catch (SQLException e) {
			System.out.println("DbmsService.GetReguesterValue : Connection not established ! ");
			rs=null;
			e.printStackTrace();
		}
		return rs;
	}
	
	public static int getMaxId(String nm){
		int count=200;
		try {
			CallableStatement cs = conn.prepareCall("{ call GET_MAX_REQID(?,?)}");
			cs.setString(1 , nm);
			System.out.println("DbmsService.getMaxId : first column is initialized");
			cs.registerOutParameter(2,OracleTypes.NUMBER);
			System.out.println("DbmsService.getMaxId : second column is iniialized");
			cs.executeQuery();
			System.out.println("DbmsService.getMaxId : count  is initialized.");
			count = cs.getInt(2);
			System.out.println("DbmsService.getMaxId : count  is "+count);
			System.out.println("DbmsService.getMaxId : count  is changed.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DbmsService.getMaxId : getMaxId is not wrking.");
			e.printStackTrace();
		}	
		return count;
	}
	
	private ResultSet GetReguestGeneratorValue() {
		ResultSet rs = null;
		try {
			CallableStatement cs = conn.prepareCall("{call get_generated_table(?)}",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY,ResultSet.FETCH_REVERSE);
			
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			
			cs.executeQuery();
			
			rs = (ResultSet) cs.getObject(1);
			
		} catch (SQLException e) {
			System.out.println("DbmsService.GetReguesterValue : Connection not established ! ");
			rs=null;
			e.printStackTrace();
		}
		return rs;
	}

	
	public static ResultSet retriveDonorType(String typ){
		ResultSet rs = null;
		
		try {
			CallableStatement cs = conn.prepareCall("{call provide_required_blood_type(?,?)}");
			
			cs.setString(1,typ);
			
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			
			cs.executeQuery();
			System.out.println("DbmsService.retriveDonorType : Stmt executed ! ");
			rs = (ResultSet) cs.getObject(2);
			System.out.println("DbmsService.retriveDonorType : rs created ! ");
		} catch (SQLException e) {
			System.out.println("DbmsService.retriveDonorType : Stmt is not executed ! ");
		}
		return rs;
	}

	
	public static void generateReq(String rid,String rno, String DBType, int bottles,String status) {
		int count=0;
		try {
			CallableStatement cs = conn.prepareCall("{call insert_req_accident(?,?,?,?,?,?)}");
			String grb = "GR"+getMaxId("GR");
			System.out.println("the grb is  : "+grb);
			count++;
			cs.setString(1, grb);
			count++;
			cs.setString(2,rid);
			count++;
			cs.setString(3,rno);
			count++;
			cs.setString(4,DBType);
			count++;
			cs.setInt(5, bottles);
			count++;
			cs.setString(6, status);
			count++;
			int n=cs.executeUpdate();
			count++;
			if(n>0){
				count++;
				System.out.println("DbmsService.generateReq : data inserted !!");
				count++;}
		} catch (SQLException e) {
			System.out.println("DbmsService.generateReq : not working on "+ count +" !! ");
			e.printStackTrace();
		}
	}



	public static ResultSet getRequesters() {
		// TODO Auto-generated method stub
		try {
			CallableStatement cs = conn.prepareCall("{call displayReq_16049(?)}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeQuery();
			return (ResultSet) cs.getObject(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
	}
	
	public static ResultSet getHisRequesters() {
		try {
			CallableStatement cs = conn.prepareCall("{call displayHisReq_16049(?)}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeQuery();
			return (ResultSet) cs.getObject(1);
		} catch (SQLException e) {
			
			//e.printStackTrace();
			return null;
		}
	}
	
	public static int moveToHistory(String id,String type){
		int n=0;
		try {
			CallableStatement cs = conn.prepareCall("{call moveToHistory_16049(?,?,?)}");
			cs.setString(1, id);
			cs.setString(2, type);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.executeUpdate();
			if((Integer)cs.getObject(3)==1){
				n=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			n=2;
		}
		return n;
	}
	
	public static ResultSet empById(String crid){
		try {
			CallableStatement cs = conn.prepareCall("{call displayEmpByID_16049(?,?)}");
			cs.setString(1, crid);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			return (ResultSet)cs.getObject(2);
		} catch (SQLException e) {
//			e.printStackTrace();
			return null;
		}
	}
	
	public static int updateEmp(Emp e){
		int n=0;
		try {
			CallableStatement cs = conn.prepareCall("{call UPDATEEMP_16049(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1,e.getE_id());
			cs.setString(2,e.getE_fname());
			cs.setString(3,e.getE_lname());
			cs.setString(4,e.getE_gender());
			cs.setDate(5, (Date) e.getE_dob());
			cs.setDate(6, (Date) e.getE_doj());
			cs.setString(7, e.getE_btype());
			cs.setString(8,e.getE_contact());
			cs.setString(9,e.getE_eaddr());
			cs.setString(10,e.getE_addr());
			cs.setString(11,e.getE_recovery_id());
			cs.setInt(12, e.getDisease());
			cs.setString(13,e.getE_workedEarlier());
			cs.setString(14,e.getE_workedDesignation());
			cs.setString(15,e.getE_workedLocation());
			cs.setInt(16, e.getE_workedExp());
			cs.registerOutParameter(17, Types.INTEGER);
			
			cs.executeUpdate();
			if((Integer)cs.getObject(17)==1){
					n=1;
				}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
//			e1.printStackTrace();
			n=0;
		}
		return n;}
	
	public static ResultSet retriveCause(String cause){
		CallableStatement cs;
		try {
			cs = conn.prepareCall("{call retrive_cause_16049(?,?)}");
			cs.setString(1, cause);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeQuery();
			return (ResultSet)cs.getObject(2);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static int generateRequestStatus(){
		
		return 0;
	}
	
	public static int placeOrder(String req_id, String rid, String rno, String btype, int nUnits, Double total,Requestee r){
		CallableStatement cs;
		int n=DbmsService.regInDB(r);
		if(n==1){
		try {
			cs=conn.prepareCall("{call insert_req_accident(?,?,?,?,?,?,?)}");
			cs.setString(1, req_id);
			cs.setString(2, rid);
			cs.setString(3, rno);
			cs.setString(4, btype);
			cs.setInt(5, nUnits);
			cs.setDouble(6, total);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.execute();
			System.out.println("DbmsService: placeOrder for accidents is done.");
			 return (Integer)cs.getObject(7);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DbmsService: placeOrder for accidents is not done.");
			return 0;
		}
	}
	else{
		return -1;
	}
	}
	
	public static int placeOrder(String req_id, String rid, String rno, String typeCause, String creason, String btype, int nUnits, Double total,Requestee r){
		CallableStatement cs;
		int n=DbmsService.regInDB(r);
		if(n==1){
		try {
			cs = conn.prepareCall("{call insert_req_transfusion(?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, req_id);
			cs.setString(2, rid);
			cs.setString(3, rno);
			cs.setString(4, typeCause);
			cs.setString(5, creason);
			cs.setString(6, btype);
			cs.setInt(7, nUnits);
			cs.setDouble(8, total);
			cs.registerOutParameter(9, Types.INTEGER);
			cs.execute();
			System.out.println("DbmsService: placeOrder for transfusion is done.");
			 return (Integer)cs.getObject(9);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DbmsService: placeOrder for transfusion is not done.");
			return 0;
		}
		}
		else{
			return -1;
		}
	}
	
	public static Double getPrice(String item){
		try {
			CallableStatement cs = conn.prepareCall("{call get_price_16049(?,?)}");
			cs.setString(1, item);
			cs.registerOutParameter(2, Types.DOUBLE);
			cs.execute();
			System.out.println("DbmsService: getPrice() working.");
			return (Double)cs.getObject(2);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DbmsService: getPrice() not working.");
			return 0.0;
		}
		
	}

	public static ResultSet getStatusByRequestId(String rid) {
		try {
			CallableStatement cs = conn.prepareCall("{call get_requested_status_16049(?,?)}");
			cs.setString(1, rid);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.execute();
			return (ResultSet) cs.getObject(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
}