package hp.project;
import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Data_Write{
	
	
	static ArrayList<Student_Data> ar=null;
	static FileOutputStream fos=null;
	static ObjectOutputStream os=null;
	
	void writeMap(HashMap lp){
	
		try{
		fos=new FileOutputStream("Loginfile.txt");
		 os=new ObjectOutputStream(fos);
		os.writeObject(lp);}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			try{
		fos.flush();
			fos.close();}
			catch(Exception e){System.out.println(e);}}
	}
	
	void writeList(ArrayList<Student_Data> ar)
	{
		
		try{
		fos=new FileOutputStream("Studentinfo.txt");
		 os=new ObjectOutputStream(fos);
		os.writeObject(ar);}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			try{
		fos.flush();
			fos.close();}
			catch(Exception e){System.out.println(e);}
	}}
	
}	
