package main;
import forms.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;


public class PSDSingleton {
	private final static String pathFormC = "DataBase/Personal/FormC.csv";
	private final static String pathFormD = "DataBase/Personal/FormD.csv";
	private final static String pathFormP = "DataBase/Personal/FormP.csv";
	private final static String pathFormR = "DataBase/Personal/FormR.csv";
	private final static String pathGameRules = "DataBase/Personal/GameRules.csv";

	private ArrayList<String[]> formCData;
	private ArrayList<String[]> formDData;
	private ArrayList<String[]> formPData;
	private ArrayList<String[]> formRData;
	private ArrayList<String[]> formSData;
	private ArrayList<String[]> gameRulesData;
	private ArrayList<AYNEmployee> formTData;
	private ArrayList<String[]> formBData;
	private ArrayList<Round> formVData;
	private Map<String, String[]> formPDataHashMap;
	private Map<String, Integer> formRDataHashMap;
	private Map<String, Integer> formDDataHashMap;
	private Map<String, String> gameRulesDataHashMap;
	private ArrayList<String> formOData = new ArrayList<String>(Collections.nCopies(20, ""));
	private EmployeeList emp;
	
	private static PSDSingleton instance = null;
	protected PSDSingleton() {}
	   
	public static PSDSingleton getInstance() {
		if(instance == null) {
			instance = new PSDSingleton();
	    }
		return instance;
	}
	public static void clear(){
		instance = null;
	}
	
	private ArrayList<String[]> getFileData(String file){
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<String[]> arr = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    while ((line = br.readLine()) != null) {
		        String[] data = line.split(cvsSplitBy);
	        	arr.add(data);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return arr;
	}
	
	
	private void loadFormCData(){
		this.formCData = new ArrayList<>();
		this.formCData = this.getFileData(pathFormC);
	}
	
	public void setFormCData(ArrayList<String[]> formCData){
		this.formCData = new ArrayList<>();
		this.formCData = formCData;
	}
	
	public ArrayList<String[]> getFormCData(){
		if (this.formCData == null){
			this.loadFormCData();
		}
		return this.formCData;
	}
	
	public void saveFormCData(){
		PrintWriter pw;
		ArrayList<String[]> arr = this.getFormCData();
		try {
			pw = new PrintWriter(new File(pathFormC));
			for (int i = 0; i < arr.size(); i++) {
				pw.write("" + arr.get(i)[0] + "," + 
				  arr.get(i)[1] + "," + 
				  arr.get(i)[2] + "," + 
				  arr.get(i)[3] + "," + 
				  arr.get(i)[4] + "\n");
			}
	        pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void loadFormDData(){
		this.formDData = new ArrayList<>();
		this.formDData = this.getFileData(pathFormD);
	}
	
	public void setFormDData(ArrayList<String[]> formDData){
		this.formDData = new ArrayList<>();
		this.formDData = formDData;
	}
	
	public ArrayList<String[]> getFormDData(){
		if (this.formDData == null){
			this.loadFormDData();
		}
		return this.formDData;
	}
	
	public void saveFormDData(){
		PrintWriter pw;
		ArrayList<String[]> arr = this.getFormDData();
		try {
			pw = new PrintWriter(new File(pathFormD));
			for (int i = 0; i < arr.size(); i++) {
				pw.write("" + arr.get(i)[0] + "," + 
				  arr.get(i)[1] + "," + 
				  arr.get(i)[2] + "," + 
				  arr.get(i)[3] + "," + 
				  arr.get(i)[4] + "," + 
				  arr.get(i)[5] + "," + 
				  arr.get(i)[6] + "," + 
				  arr.get(i)[7] + "," + 
				  arr.get(i)[8] + "," + 
				  arr.get(i)[9] + "," + 
				  arr.get(i)[10] + "\n");
			}
	        pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void createHashFormD(){
		 this.formDDataHashMap = new HashMap<String, Integer>();
		 ArrayList<String[]> arr = this.getFormDData();

		 for (int i = 0; i < arr.size(); i++) {
			 for (int j = 1; j < arr.get(i).length; j++) {
				 this.formDDataHashMap.put(arr.get(i)[0] + " " + j, Integer.parseInt(arr.get(i)[j]));
			 }
		}
	}
	
	// what if the time is not an int between 1 and 10
	public int getContractPrice(String carName , String time){
		if(this.formDDataHashMap == null){
			this.createHashFormD();
		}
		return formDDataHashMap.get(carName + " " + time);
	}
	
	private void loadFormPData(){
		this.formPData = new ArrayList<>();
		this.formPData = this.getFileData(pathFormP);
	}
	
	public void setFormPData(ArrayList<String[]> formPData){
		this.formPData = new ArrayList<>();
		this.formPData = formPData;
	}
	
	public ArrayList<String[]> getFormPData(){
		if (this.formPData == null){
			this.loadFormPData();
		}
		return this.formPData;
	}
	
	public void saveFormPData(){
		PrintWriter pw;
		ArrayList<String[]> arr = this.getFormPData();
		try {
			pw = new PrintWriter(new File(pathFormP));
			for (int i = 0; i < arr.size(); i++) {
				pw.write("" + arr.get(i)[0] + "," + 
				  arr.get(i)[1] + "," + 
				  arr.get(i)[2] + "," + 
				  arr.get(i)[3] + "," + 
				  arr.get(i)[4] + "\n");
			}
	        pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void createHashFormP(){
		 this.formPDataHashMap = new HashMap<String, String[]>();
		 ArrayList<String[]> arr = this.getFormPData();

		 for (int i = 0; i < arr.size(); i++) {
			this.formPDataHashMap.put(arr.get(i)[0], arr.get(i));
		}
	}

	public String getLightsPrice(String carName){
		if(this.formPDataHashMap == null){
			this.createHashFormP();
		}
		
		if (this.formPDataHashMap.containsKey(carName)){

			if (formPDataHashMap.get(carName).length >= 2){
				return formPDataHashMap.get(carName)[1];
			}
			return "0";
		}
		return "0";
	}
	
	public String getGPSYellowPrice(String carName){
		if(this.formPDataHashMap == null){
			this.createHashFormP();
		}
		
		if (this.formPDataHashMap.containsKey(carName)){
			if (formPDataHashMap.get(carName).length >= 2){
				return formPDataHashMap.get(carName)[3];
			}
			return "0";
		}
		return "0";
	}
	
	public String getGPSXenonPrice(String carName){
		if(this.formPDataHashMap == null){
			this.createHashFormP();
		}
		
		if (this.formPDataHashMap.containsKey(carName)){
			if (formPDataHashMap.get(carName).length >= 3){
				return formPDataHashMap.get(carName)[4];
			}
			return "0";
		}
		return "0";
	}
	
	
	public String getNoGPSYellowPrice(String carName){
		if(this.formPDataHashMap == null){
			this.createHashFormP();
		}
		
		if (this.formPDataHashMap.containsKey(carName)){
			if (formPDataHashMap.get(carName).length >= 4){
				return formPDataHashMap.get(carName)[1];
			}
			return "0";
		}
		return "0";
	}
	
	public String getNoGPSXenonPrice(String carName){
		if(this.formPDataHashMap == null){
			this.createHashFormP();
		}
		
		if (this.formPDataHashMap.containsKey(carName)){
			if (formPDataHashMap.get(carName).length >= 5){
				return formPDataHashMap.get(carName)[2];
			}
			return "0";
		}
		return "0";
	}
	
	public void exportData(){
		
		PrintWriter pw;
		
		File theDir = new File("Export");
		if (!theDir.exists()) {
		    try{
		        theDir.mkdir();
		    } 
		    catch(SecurityException se){
		    }  
		}

		ArrayList<String[]> formBData = this.getFormBData();
		try {
			pw = new PrintWriter(new File("Export/FormBData.csv"));
			for (int i = 0; i < formBData.size(); i++) {
				pw.write("" + formBData.get(i)[0] + "," + formBData.get(i)[1]+ "," + formBData.get(i)[2]+ "," + formBData.get(i)[3]+ "," + formBData.get(i)[4]+ "," + formBData.get(i)[5]
						+ "," + formBData.get(i)[6]+ "," + formBData.get(i)[7]+ "," + formBData.get(i)[8] + "," + formBData.get(i)[9] + "\n");
			}
	        pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<String[]> formSData = this.getFormSData();
		try {
			pw = new PrintWriter(new File("Export/FormSData.csv"));
			for (int i = 0; i < formSData.size(); i++) {
				pw.write("" + formSData.get(i)[0] + "," + formSData.get(i)[1]+ "," + formSData.get(i)[2] + "\n");
			}
	        pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<AYNEmployee> formTData = this.getFormTData();
		try {
			pw = new PrintWriter(new File("Export/FormTData.csv"));
			for (int i = 0; i < formTData.size(); i++) {
				pw.write("" + formTData.get(i).getName() + "," + formTData.get(i).getDepartmentWithoutBreak() + "," + formTData.get(i).getMultiSkilled() + "," + formTData.get(i).getTime1()
						 + "," + formTData.get(i).getTime2() + "," + formTData.get(i).getTotTime() + "," + formTData.get(i).getWage()+ "," + formTData.get(i).getRoundCount() + "\n");
			}
	        pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Round> formVData = this.getFormVData();
		try {
			pw = new PrintWriter(new File("Export/FormVData.csv"));
			for (int i = 0; i < formVData.size(); i++) {
				pw.write("" + formVData.get(i).getRoundNum() + "," + formVData.get(i).getTotalRevenue() + "," + formVData.get(i).getEmployeeWage()
						+ "," + formVData.get(i).getAynPay()
						 + "," + formVData.get(i).getMaterialsSum() + "," + formVData.get(i).getTotalExpenditure() + "," + formVData.get(i).getProfitLoss()+ "\n");
			}
	        pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void importData(){
		//ArrayList<String[]> formOData = this.getFileData("Export/FormBData.csv");
		//this.setFormOData(formOData.get(0));
		
		ArrayList<String[]> formBData = this.getFileData("Export/FormBData.csv");
		this.setFormBData(formBData);
		
		ArrayList<String[]> formSData = this.getFileData("Export/FormSData.csv");
		this.setFormSData(formSData);
		
		
		ArrayList<String[]> formTData = this.getFileData("Export/FormTData.csv");
		ArrayList<AYNEmployee> employees = new ArrayList<AYNEmployee>();
		for (int i = 0; i < formTData.size(); i++) {
			try{
				AYNEmployee employee = new AYNEmployee();
				employee.setName(formTData.get(i)[0]);
				employee.setDepartment(formTData.get(i)[1]);
				
				if (formTData.get(i)[2].toLowerCase() == "true"){
					employee.setMultiSkilled(true);
				} else {
					employee.setMultiSkilled(false);
				}
				
				employee.setTime1(Integer.parseInt(formTData.get(i)[3]));
				employee.setTime2(Integer.parseInt(formTData.get(i)[4]));
				employee.setTotTime(Integer.parseInt(formTData.get(i)[5]));
				employee.setWage(Double.parseDouble(formTData.get(i)[6]));
				employee.setRoundCount(Integer.parseInt(formTData.get(i)[7]));

				employees.add(employee);
			} catch(Exception e){}
		}
		this.setFormTData(employees);
		
		ArrayList<String[]> formVData = this.getFileData("Export/FormVData.csv");
		ArrayList<Round> rounds = new ArrayList<Round>();
		for (int i = 0; i < formVData.size(); i++) {
			try{
				rounds.add(new Round(formVData.get(i)[0] , formVData.get(i)[1] , formVData.get(i)[2] , formVData.get(i)[3] , formVData.get(i)[4] , formVData.get(i)[5] , formVData.get(i)[6]));
			} catch(Exception e){}
		}
		this.setFormVData(rounds);
		
		
	}
	
	private void loadFormRData(){
		this.formRData = new ArrayList<>();
		this.formRData = this.getFileData(pathFormR);
	}
	
	public void setFormRData(ArrayList<String[]> formRData){
		this.formRData = new ArrayList<>();
		this.formRData = formRData;
	}
	
	public ArrayList<String[]> getFormRData(){
		if (this.formRData == null){
			this.loadFormRData();
		}
		return this.formRData;
	}
	
	public void saveFormRData(){
		PrintWriter pw;
		ArrayList<String[]> arr = this.getFormRData();
		try {
			pw = new PrintWriter(new File(pathFormR));
			for (int i = 0; i < arr.size(); i++) {
				pw.write("" + arr.get(i)[0] + "," + 
				  arr.get(i)[1] + "\n");
			}
	        pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void createHashFormR(){
		 this.formRDataHashMap = new HashMap<String, Integer>();
		 ArrayList<String[]> arr = this.getFormRData();

		 for (int i = 0; i < arr.size(); i++) {
			this.formRDataHashMap.put(arr.get(i)[0], Integer.parseInt(arr.get(i)[1]));
		}
	}

	public int getEmployeeWage(String position){
		if(this.formRDataHashMap == null){
			this.createHashFormR();
		}
		
		if (this.formRDataHashMap.containsKey(position)){
			return formRDataHashMap.get(position);
		}
		
		return 20;
	}
	
	
	
	
	private void loadGameRulesData(){
		this.gameRulesData = new ArrayList<>();
		this.gameRulesData = this.getFileData(pathGameRules);
	}
	
	public void setGameRulesData(ArrayList<String[]> gameRulesData){
		this.gameRulesData = new ArrayList<>();
		this.gameRulesData = gameRulesData;
	}
	
	public ArrayList<String[]> getGameRulesData(){
		if (this.gameRulesData == null){
			this.loadGameRulesData();
		}
		return this.gameRulesData;
	}
	
	public void saveGameRulesData(){
		PrintWriter pw;
		ArrayList<String[]> arr = this.getGameRulesData();
		try {
			pw = new PrintWriter(new File(pathGameRules));
			for (int i = 0; i < arr.size(); i++) {
				pw.write("" + arr.get(i)[0] + "," + 
				  arr.get(i)[1] + "\n");
			}
	        pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void createHashGameRules(){
		 this.gameRulesDataHashMap = new HashMap<String, String>();
		 ArrayList<String[]> arr = this.getGameRulesData();

		 for (int i = 0; i < arr.size(); i++) {
			 try{
				this.gameRulesDataHashMap.put(arr.get(i)[0], arr.get(i)[1]);
			 } catch (Exception e){
				 e.printStackTrace();
			 }
		}
	}

	public int getRoundTime(){
		if(this.gameRulesDataHashMap == null){
			this.createHashGameRules();
		}
		
		if (this.gameRulesDataHashMap.containsKey("Round time")){
			try {
				return Integer.parseInt(gameRulesDataHashMap.get("Round time"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			return 15;
		}
		return 15;
	}
	
	public int getNumberOfRounds(){
		if(this.gameRulesDataHashMap == null){
			this.createHashGameRules();
		}
		
		if (this.gameRulesDataHashMap.containsKey("Number of rounds")){
			try {
				return Integer.parseInt(gameRulesDataHashMap.get("Number of rounds"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			return 3;
		}
		return 3;
	}
	
	public int getOrderNum(){
		if(this.gameRulesDataHashMap == null){
			this.createHashGameRules();
		}
		
		if (this.gameRulesDataHashMap.containsKey("Number of orders")){
			try {
				return Integer.parseInt(gameRulesDataHashMap.get("Number of orders"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			return 22;
		}
		return 22;
	}
	
	public int getPenalty(){
		if(this.gameRulesDataHashMap == null){
			this.createHashGameRules();
		}
		
		if (this.gameRulesDataHashMap.containsKey("Penalty")){
			try {
				return Integer.parseInt(gameRulesDataHashMap.get("Penalty"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			return 15;
		}
		return 15;
	}
	
	public int getHiringCost(){
		if(this.formRDataHashMap == null){
			this.createHashFormR();
		}
		if (this.formRDataHashMap.containsKey("Hiring")){
	
			return formRDataHashMap.get("Hiring");
		}
		
		return 75;
	}
	
	public int getFiringCost(){
		if(this.formRDataHashMap == null){
			this.createHashFormR();
		}
		
		if (this.formRDataHashMap.containsKey("Firing")){
			return formRDataHashMap.get("Firing");
		}
		
		return 100;
	}
	
	
	
	// Form S data
	public void setFormSData(ArrayList<String[]> formSData){
		this.formSData = new ArrayList<>();
		this.formSData = formSData;
	}
	
	public ArrayList<String[]> getFormSData(){
		if (this.formSData == null){
			this.formSData = new ArrayList<>();
		}
		return this.formSData;
	}
	
	// Form T data
	public void setFormTData(ArrayList<AYNEmployee> formTData){
		this.formTData = new ArrayList<>();
		this.formTData = formTData;
	}
	
	public ArrayList<AYNEmployee> getFormTData(){
		if (this.formTData == null){
			this.formTData = new ArrayList<>();
		}
		return this.formTData;
	}
	
	
	// Form B data
	public void setFormBData(ArrayList<String[]> formBData){
		this.formBData = new ArrayList<>();
		this.formBData = formBData;
	}
		
	public ArrayList<String[]> getFormBData(){
		if (this.formBData == null){
			this.formBData = new ArrayList<>();
		}
		return this.formBData;
	}

	// Form O data
	public void setFormOData(ArrayList<String> formOData){
		this.formOData = formOData;
	}
		
	public ArrayList<String> getFormOData(){
		if (this.formOData == null){
			this.formOData = new ArrayList<String>();
		}
		return this.formOData;
	}

	//Form V Data
	public void setFormVData(ArrayList<Round> formVData){
		this.formVData = new ArrayList<>();
		this.formVData = formVData;
	}
		
	public ArrayList<Round> getFormVData(){
		if (this.formVData == null){
			this.formVData = new ArrayList<>();
		}
		return this.formVData;
	}
	
	//EmployeeList Singleton
	public EmployeeList getEmployeeList(){
		if(this.emp == null){
			this.emp = new EmployeeList(new Employee());
		}
		return this.emp;
	}
}
