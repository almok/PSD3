package main;
import forms.AYNEmployee;
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
	private ArrayList<Integer> formCountArray = new ArrayList<Integer>(Collections.nCopies(20, 1));
	
	private static PSDSingleton instance = null;
	protected PSDSingleton() {}
	   
	public static PSDSingleton getInstance() {
		if(instance == null) {
			instance = new PSDSingleton();
	    }
		return instance;
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
		 this.formRDataHashMap = new HashMap<String, Integer>();
		 ArrayList<String[]> arr = this.getFormRData();

		 for (int i = 0; i < arr.size(); i++) {
			 for (int j = 1; j < arr.get(i).length; j++) {
				 this.formRDataHashMap.put(arr.get(i)[0] + " " + j, Integer.parseInt(arr.get(i)[j]));
			 }
		}
	}

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
				return formPDataHashMap.get(carName)[1];
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
				return formPDataHashMap.get(carName)[2];
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
				return formPDataHashMap.get(carName)[3];
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
				return formPDataHashMap.get(carName)[4];
			}
			return "0";
		}
		return "0";
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
		ArrayList<String[]> arr = this.getFormCData();
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
			this.gameRulesDataHashMap.put(arr.get(i)[0], arr.get(i)[1]);
		}
	}

	public int getRoundTime(){
		if(this.gameRulesDataHashMap == null){
			this.createHashGameRules();
		}
		
		if (this.gameRulesDataHashMap.containsKey("Game time")){
			try {
				return Integer.parseInt(gameRulesDataHashMap.get("Game time"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			return 15;
		}
		return 15;
	}
	
	public int getRoundNumber(){
		if(this.gameRulesDataHashMap == null){
			this.createHashGameRules();
		}
		
		if (this.gameRulesDataHashMap.containsKey("Round number")){
			try {
				return Integer.parseInt(gameRulesDataHashMap.get("Round number"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			return 15;
		}
		return 15;
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
			this.formOData = null;
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

	public ArrayList<Integer> getFormCounter(){
		if (this.formCountArray == null){
			this.formCountArray = new ArrayList<>();
		}
		return this.formCountArray;
	}

	public void setFormCounter(ArrayList<Integer> formCountArray){
		this.formCountArray = new ArrayList<>();
		this.formCountArray = formCountArray;
	}
}
