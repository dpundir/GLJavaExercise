package com.pundir;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.pundir.business.CompanyDetail;
import com.pundir.business.CsvReader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testCsvFileReader()
    {
    	try{
	    	CsvReader csvReader = new CsvReader();
	    	csvReader.setCsvFile("F:\\study\\workspace\\GLJavaExercise\\FileExercise\\src\\main\\java\\com\\pundir\\business\\company-data.csv");
	    	csvReader.readCsv();
	    	assertTrue(true);
    	} catch(FileNotFoundException e){
    		assertTrue(false);
    	}	catch (IOException e) {
    		assertTrue(false);
		}
    }

    /**
     * Rigourous Test :-)
     */
    public void testCsvFileResponse()
    {
    	try{
	    	CsvReader csvReader = new CsvReader();
	    	csvReader.setCsvFile("F:\\study\\workspace\\GLJavaExercise\\FileExercise\\src\\main\\java\\com\\pundir\\business\\company-data.csv");
	    	csvReader.readCsv();
	    	List<CompanyDetail> companies = csvReader.getCompanies();
	    	if(companies != null && companies.size() > 0){
	    		assertTrue(true);
	    	} else{
	    		assertTrue(false);
	    	}
    	} catch(FileNotFoundException e){
    		assertTrue(false);
    	}	catch (IOException e) {
    		assertTrue(false);
		}
    }
    
    public void testCsvFileNotExists(){
    	try{
	    	CsvReader csvReader = new CsvReader();
	    	csvReader.setCsvFile("F:\\study\\company-data.csv");
	    	csvReader.readCsv();
	    	assertTrue(false);
    	} catch(FileNotFoundException e){
    		assertTrue(true);
    	}	catch (IOException e) {
    		assertTrue(false);
		}
    }
}
