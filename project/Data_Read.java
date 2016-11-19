package hp.project;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;

public class Data_Read{
	
		static FileInputStream fis  =null;
		static ObjectInputStream oi=null;
		static ArrayList<Student_Data> al=new ArrayList();
		static HashMap lp=new HashMap();
		static File f;
ArrayList<Student_Data> readList()
	{
		f =new File("Studentinfo.txt");
		
		
		try{
			if(!f.exists()){
			f.createNewFile();}
	    fis=new FileInputStream("Studentinfo.txt");
		oi=new ObjectInputStream(fis);
		al=(ArrayList<Student_Data>)oi.readObject();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			try{
				fis.close();
			}
			catch(Exception e){
			System.out.println(e);
			}
		}
		return al;
	}
	


HashMap readMap()
{
	f  = new File("Loginfile.txt");
	
		try{
			
			if(!f.exists()){
		
			f.createNewFile();
			}
	   
		fis=new FileInputStream("Loginfile.txt");
		oi=new ObjectInputStream(fis);
		lp=(HashMap)oi.readObject();
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			try{
				fis.close();
			}
			catch(Exception e){
			System.out.println(e);
			}
		}
		return lp;
	
}
}