package hp.project;

import java.util.*;
import java.io.Serializable;


public class Student_Data implements Serializable{
	String email_id;
	String password;
	String first_name;
	String last_name;
	String father_name;
	String adress;
	String college;
	String city;
	String branch;
	String year;
	
	
	Student_Data(String email_id,String password,String first_name,String last_name,String father_name,String adress,String college,String city,String branch,String year){
		this.email_id = email_id;
		this.password = password;
		this.first_name = first_name;
		this.last_name  = last_name;
		this.father_name= father_name;
		this.adress = adress;
		this.college = college;
		this.city = city;
		this.branch = branch;
		this.year=year;
	
}
	void getDetail(){
		System.out.println("email_id	 "+":		"+email_id);
		System.out.println("FirstName	 "+":		"+first_name);
		System.out.println("LastName	 "+":		"+last_name);
		System.out.println("father's Name	 "+":"+"       	 "+father_name);
		System.out.println("adress		 "+":		"+adress);
		System.out.println("college		 "+":		"+college);
		System.out.println("city		 "+":		"+city);
		System.out.println("branch		 "+":		"+branch);
		System.out.println("year		 "+":		"+year);
	}

}



