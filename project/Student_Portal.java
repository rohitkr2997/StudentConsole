package hp.project;

import java.util.*;
import java.io.*;



public class Student_Portal{
	
	static String email_id;
	static String password;
	static String first_name;
	static String last_name;
	static String father_name;
	static String adress;
	static String college;
	static String city;
	static String branch;
	static String year;
	static Iterator it;
		
	
		static ArrayList<Student_Data>  al = new ArrayList();
		static Student_Portal sp = new Student_Portal();
		static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		static HashMap lp = new HashMap();
		static Data_Write dw = new Data_Write();
		static Data_Read dr = new Data_Read();
		String email_id() throws Exception{
			System.out.println("Enter Email-ID");
		return br.readLine();
		
		}
		
		String password() throws Exception{
		char[] ch2 = System.console().readPassword("Enter password/(is hidden so will not seen)");
		String password = new String(ch2);
		return password;
		}
	
	
		String first_name() throws Exception{
		System.out.println("Enter First Name");
		return br.readLine();
		}
		
		String last_name() throws Exception{
		System.out.println("Enter Last Name");
		return br.readLine();
		}
		
		String father_name() throws Exception{
		System.out.println("Enter Father's Name");
		return br.readLine();
		}
		
		String adress() throws Exception{
		System.out.println("Enter adress");
		return br.readLine();
		}
		
		
		String college() throws Exception{
		System.out.println("Enter college");
		return br.readLine();
		}
		
		String city() throws Exception{
		System.out.println("Enter city");
		return br.readLine();
		}
		
		String branch() throws Exception{
		System.out.println("Enter branch");
		return br.readLine();
		}
		
		String year() throws Exception{
		System.out.println("Enter year");
		return br.readLine();
		}
		

		

	
		
		void register() throws Exception{
			
		email_id = sp.email_id();
		
		FileInputStream f =new FileInputStream("Studentinfo.txt");
					if(f.available()>0){
					al =dr.readList();}
					else
					al=new ArrayList();
		if(al.isEmpty()==false){
			
			int ce=0;
			for(;ce==0;){
			it = al.iterator();
			while(it.hasNext()){
			Student_Data sd=(Student_Data)it.next();
			if(sd.email_id.equals(email_id)){
				System.out.println("Email already exists");
			email_id = sp.email_id();}
			else
		ce++;}}
	}
		password=sp.password();
		first_name = sp.first_name();
		last_name = sp.last_name();
		father_name = sp.father_name();
		adress = sp.adress();
		college = sp.college();
		city = sp.city();
		branch = sp.branch();
		year = sp.year();
		
	
		int size = al.size();
		
		Student_Data sd =new Student_Data(email_id,password,first_name,last_name,father_name,adress,college,city,branch,year);
		al.add(sd);
		lp.put(email_id,password);
		dw.writeList(al);
		dw.writeMap(lp);
		
		if(al.size()>size){
		System.out.println("Student registered\n"+"user_id= "+email_id+" password="+password);
		System.out.println("please note it down");
		}
		}
		
		Student_Data update(Student_Data sd) throws Exception{
			System.out.println("choose what to update");
			System.out.println("1.First Name\n2.Last Name\n3.Father's Name\n4.Adress\n5.College\n6.City\n7.Branch\n8.Year\n");
			int select = Integer.parseInt(br.readLine());
			switch(select){
				case 1:
				
				sd.first_name=sp.first_name();
				break;
				
				case 2:
				
				sd.last_name = sp.last_name();
				break;
				
				case 3:
				
				sd.father_name = sp.father_name();
				break;
				case 4:
				
				sd.adress = sp.adress();
				break;
				
				case 5:
				
				sd.college = sp.college();
				break;
				
				case 6:
				
				sd.city = sp.city();
				break;
				
				case 7:
				
				sd.branch = sp.branch();
				break;
				
				case 8:
				
				sd.year = sp.year();
				break;
				
				
				default :
					System.out.println("wrong choice made");
				
			}
			return sd;
		}
		
		
public static void main(String...args){
				
	
	lp.put("admin","admin");
				
	try{
					
					 int welcome=0;
				for(;;)
				{   
					if(welcome==0){
					System.out.println("*************WELCOME TO STUDENT-POTAL***************");
					System.out.println("******HOW CAN I HELP YOU?*********");
					welcome++;}
				System.out.println("1.Register\n2.Login\n3.Exit");
				System.out.println("Choose to continue....");
				int choose = Integer.parseInt(br.readLine());
				switch(choose)
				{
					case 1:
					sp.register();
					
					break;
					
					case 2:
					
					System.out.println("Enter user_id:");
					String uid = br.readLine();
					lp=dr.readMap();
					al=dr.readList();
					
					if(lp.containsKey(uid)){
						
						char[] ch = System.console().readPassword("Enter password");
						String secret = new String(ch);
						if(secret.equals(lp.get(uid))){
							if(uid.equals("admin")){
							int ca=0;
							for(;ca==0;){
							System.out.println("1.Show all record\n2.Delete a particular Student\n3.Show a particular record\n4.logout\n");
							System.out.println("Choose to continue....");
							int admin_choice = Integer.parseInt(br.readLine());
							switch(admin_choice){
							case 1:
							it = al.iterator();
							while(it.hasNext())
							{
								Student_Data stda =(Student_Data)it.next();
								stda.getDetail();
								System.out.println("*********************************************************************");
							}
							break;
							case 2:
							System.out.println("Enter student user_id to be deleted");
							String usid = br.readLine();
							 it =al.iterator();
							 while(it.hasNext()){
								Student_Data stdt  = (Student_Data)it.next();
								if(usid.equals(stdt.email_id)){
									it.remove();
									lp.remove(usid);
									dw.writeList(al);
									dw.writeMap(lp);
									System.out.println("Student deleted from record");
								}
							 }
							 break;
							 
							 case 3:
							System.out.println("Enter student user_id to be deleted");
							 usid = br.readLine();
							 it =al.iterator();
							 while(it.hasNext()){
								Student_Data stdt  = (Student_Data)it.next();
								if(usid.equals(stdt.email_id)){
									stdt.getDetail();
								}
							 }
							 break;
							 
							 case 4:
							 ca++;
							 break;
							 default :
							 System.out.println("wrong choice");
							}}}
						else
						{
						it=al.iterator();
					  while(it.hasNext()){
							
							Student_Data stdt =(Student_Data)it.next();
							
							if(uid.equals(stdt.email_id)){
								int count=0,i=0;
						for(;count==0;){
										for(;i==0;i++){
									System.out.println("\n*******WELCOME********\n\n");
										System.out.println("HELLO "+stdt.first_name.toUpperCase()+"  HOW WAS YOUR DAY...");}
									System.out.println("******CHOOSE FROM LIST SO THAT I CAN HELP YOU******");
									System.out.println("1.Show Profile\n2.Update info\n3.Change password\n4.Delete account\n5.logout\n");
									
									int option = Integer.parseInt(br.readLine());
									
									switch(option){
											case 1:
												stdt.getDetail();
												break;
									
											case 2:
												Student_Data sd=sp.update(stdt);
												dw.writeList(al);
												
												break;
												
											case 3:
											char[] ch2 = System.console().readPassword("Enter password");
											String password = new String(ch2);
											lp.put(uid,password);
											dw.writeMap(lp);
											break;
											
											case 4:
											
											try{
											System.out.println("Enter user_id:");
											String dl = br.readLine();
											if(dl.equals(uid)){
											it=al.iterator();
											while(it.hasNext()){
							
											Student_Data std =(Student_Data)it.next();
											
											if(dl.equals(std.email_id)){
											
												char[] ch3 = System.console().readPassword("Enter password");
												String pwdl= new String(ch3);
												
												if(pwdl.equals(lp.get(uid))){
												it.remove();
												lp.remove(uid);
												dw.writeList(al);
												dw.writeMap(lp);
											count++;
											
											System.out.println("your account has been deleted");
											}
											else 
												System.out.println("wrong input");
											}
											else 
												System.out.println("wrong input");
											
											}}}
											catch(Exception e){
												System.out.println(e);
											}
											break;
									
											case 5:
										
											count++;
											break;
									
											default :
											System.out.println("wrong choice made");
									
										}
								
						}}}}}
						else{
							System.out.println("password does not match");
					}}
					else{
						System.out.println("user id not in record");
					}
					break;
					
					case 3:
					System.exit(0);
					break;
					
					default :
					System.out.println("wrong choice made");
							
				
				}
	}}				
		catch(Exception e){
		System.out.println(e);
		}
					
					
					
					
					
					
}
}



