package LogInPage; 

import java.util.Random;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class JavaDev {

	public static void main(String[] args) {
		
		
	String myname = "ahmad" ; //string double quotation
	char myfirstletter = 'a'; // char single quotation
	int myage = 2; // without decimal point
	double myaccountbank = 10.7 ; // both with decimal point or without
	boolean IamJordanian = true ; // take only true or false 
	
	Random rand = new Random();

	
	String [] myStudents = {"Mais" , "Noor" , "Yaqout" , "Tuqa" ,"Wafaa" ,"Haifa"};
	//System.out.println(myStudents[0]);
	
	//int myrandnumber = rand.nextInt(6);= the underline 
	int myrandnumber = rand.nextInt(myStudents.length);
	//System.out.print(myrandnumber);
	
	System.out.println(myStudents[myrandnumber]);
	
	
	
	
	}

}
