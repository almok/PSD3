package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PSDSingleton {
	private final static String pathFormC = "DataBase/Personal/FormC.csv";
	private final static String pathFormD = "DataBase/Personal/FormD.csv";
	private final static String pathFormP = "DataBase/Personal/FormP.csv";
	private final static String pathFormR = "DataBase/Personal/FormR.csv";

	private ArrayList<String[]> formCData;
	private ArrayList<String[]> formDData;
	private ArrayList<String[]> formPData;
	private ArrayList<String[]> formRData;
	private ArrayList<String[]> formSData;
	private Map<String, String[]> formPDataHashMap;
	private Map<String, Integer> formRDataHashMap;
	private Map<String, Integer> formDDataHashMap;
	
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
				  arr.get(i)[4] + "," + 
				  arr.get(i)[5] + "\n");
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
		
		if (formPDataHashMap.get(carName).length >= 2){
			return formPDataHashMap.get(carName)[1];
		}
		
		return "No data";
	}
	
	public String getNoGPSYellowPrice(String carName){
		if(this.formPDataHashMap == null){
			this.createHashFormP();
		}
		
		if (formPDataHashMap.get(carName).length >= 3){
			return formPDataHashMap.get(carName)[2];
		}
		
		return "No data";
	}
	
	public String getNoGPSXenonPrice(String carName){
		if(this.formPDataHashMap == null){
			this.createHashFormP();
		}
		
		if (formPDataHashMap.get(carName).length == 4){
			return formPDataHashMap.get(carName)[3];
		}
		
		return "No data";
	}
	
	public String getGPSYellowPrice(String carName){
		if(this.formPDataHashMap == null){
			this.createHashFormP();
		}
		
		if (formPDataHashMap.get(carName).length == 5){
			return formPDataHashMap.get(carName)[4];
		}
		
		return "No data";
	}
	
	public String getGPSXenonPrice(String carName){
		if(this.formPDataHashMap == null){
			this.createHashFormP();
		}
		
		if (formPDataHashMap.get(carName).length == 6){
			return formPDataHashMap.get(carName)[5];
		}
		
		return "No data";
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
		return formRDataHashMap.get(position);
	}
	
	// fix this Boris!
	public int getRoundTime(){
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
	
	
	// Form S data
		public void setFormBData(ArrayList<String[]> formSData){
			this.formSData = new ArrayList<>();
			this.formSData = formSData;
		}
		
		public ArrayList<String[]> getFormBData(){
			if (this.formSData == null){
				this.formSData = new ArrayList<>();
			}
			return this.formSData;
		}
		
}
