package com.pundir;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.pundir.business.CsvReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try{
	    	CsvReader csvReader = new CsvReader();
	    	csvReader.setCsvFile("F:\\study\\workspace\\GLJavaExercise\\FileExercise\\src\\main\\java\\com\\pundir\\business\\company-data.csv");
	    	csvReader.readCsv();
    	} catch(FileNotFoundException e){
    		System.out.println(e);
    	}catch (IOException e) {
			e.printStackTrace();
		}
    }
}
