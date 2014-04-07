package com.pundir.business;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {
	
	private String csvFile;
	List<CompanyDetail> companies;
	
	
	public String getCsvFile() {
		return csvFile;
	}

	public void setCsvFile(String csvFile) {
		this.csvFile = csvFile;
	}

	public List<CompanyDetail> getCompanies() {
		return companies;
	}

	public void setCompanies(List<CompanyDetail> companies) {
		this.companies = companies;
	}

	public void readCsv() throws FileNotFoundException, IOException{
		BufferedReader br = null;
		companies = new ArrayList<CompanyDetail>();
	 
		try {
			
			String year = null;
			String month = null;
			int index = 0;
			String line = "";
			String cvsSplitBy = ",";
			CompanyDetail company = null;
			ShareDetail shareDetail = null;
			String[] csvHeader = null;
	 
			br = new BufferedReader(new FileReader(csvFile));
			
			line = br.readLine();
			
			csvHeader = line.split(cvsSplitBy);
			List<String> csvHeaderList = Arrays.asList(csvHeader);
			
			csvHeaderList = csvHeaderList.subList(2, csvHeaderList.size());
			
			for (String companyName : csvHeaderList) {
				company = new CompanyDetail();
				company.setName(companyName);
				companies.add(company);				
			}
			
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				csvHeader = line.split(cvsSplitBy);

				csvHeaderList = Arrays.asList(csvHeader);
				year = csvHeaderList.get(0);
				month = csvHeaderList.get(1);
				csvHeaderList = csvHeaderList.subList(2, csvHeaderList.size());
				
				index = 0;
				for (String sharePrice : csvHeaderList) {
					shareDetail = companies.get(index).getShareDetail();
					if(shareDetail == null){
						shareDetail = new ShareDetail();
						shareDetail.setYear(year);
						shareDetail.setMonth(month);
						shareDetail.setPrice(Double.parseDouble(sharePrice));
						companies.get(index).setShareDetail(shareDetail);
					} else{
						if(shareDetail.getPrice() < Double.parseDouble(sharePrice)){
							shareDetail.setYear(year);
							shareDetail.setMonth(month);
							shareDetail.setPrice(Double.parseDouble(sharePrice));							
						}
					}
					index++;
				}	 
			}
	 
		} catch (IOException e) {
			if(e instanceof FileNotFoundException){
				throw e;
			}
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
		//this.printCompanyData(companies);
	}
	
	public void printCompanyData(List<CompanyDetail> companies){
		for (CompanyDetail companyDetail : companies) {
			System.out.println("[" + companyDetail.getName() + "] year:" + companyDetail.getShareDetail().getYear() + " month:" +
					companyDetail.getShareDetail().getMonth() + " price: " + companyDetail.getShareDetail().getPrice());
		}
	}
}
