package Assignment1.src.data;

import java.io.*;
import java.util.*;

public class FileIO {
//Location of the file
private static File file = new File("C:\\Users\\jdneu\\Downloads\\Assignment1\\vaccine.txt");
	
	//arraylist to add data 
	public static ArrayList<String> readData() throws IOException {
		Scanner dIN = new Scanner(file);
		
		//New arraylist for adding the record
		ArrayList<String> CovidVacDetails = new ArrayList<String>();
		while(dIN.hasNextLine()) {
			String record = dIN.nextLine();
			CovidVacDetails.add(record);
		}
		return CovidVacDetails;
	}
	
	//method to save the data and print output using the PrintWriter
	public static void saveData(String date, String city, int pfizer, int moderna, int astra) throws IOException {
		//PrintWriter dOut = new PrintWriter(file); this will overwrite file data
		PrintWriter dOut = new PrintWriter(new FileOutputStream(file,true)); //this will not over ride
		dOut.print(date);
		dOut.print(",");
		dOut.print(city);
		dOut.print(",");
		dOut.print(pfizer);
		dOut.print(",");
		dOut.print(moderna);
		dOut.print(",");
		dOut.println(astra);
		dOut.close();
	}

}
