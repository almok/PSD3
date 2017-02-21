import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AVNEmployeeList {

	private ArrayList<AVNEmployee> employees;
	
	public AVNEmployeeList(){
		employees = new ArrayList<>();
	}

	public ArrayList<AVNEmployee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<AVNEmployee> employees) {
		this.employees = employees;
	}
	
	// load employees from a file
	public void loadList(String filename){
		
		FileReader fileRead;
		BufferedReader buffRead;
		String line;
		String[] stats;
		
		try{
			
			fileRead = new FileReader(filename);
			buffRead = new BufferedReader(fileRead);
			
			//read file
			while ((line = buffRead.readLine()) != null){
				// split the lines into numbers
				stats = line.split(",");
				
				// convert to appropriate string input
				String department = "";
				for (int i = 0, n = stats[1].length(); i < n; i++) {
				    if(stats[1].charAt(i) == ' '){
				    	department += '\n';
				    }
				    else{
				    	department += stats[1].charAt(i);
				    }
				}
				
				//System.out.println(stats[]);
				
				// assign the numbers to PID, CBT and AAT in a process
				AVNEmployee employee = new AVNEmployee(stats[0], department, Boolean.parseBoolean(stats[2]), Integer.parseInt(stats[3]), 
						Integer.parseInt(stats[4]), Integer.parseInt(stats[5]), Float.parseFloat(stats[6]));
				
				// add a process to a collection of processes
				employees.add(employee);
			}
		}
		catch (IOException e){
		}
	}
	
	// save employee list to a file
	public void toFile(String filename){
		
		try{
		    PrintWriter writer = new PrintWriter(filename, "UTF-8");
		    
		    for (int i = 0; i < employees.size(); i ++){
				writer.println(employees.get(i).toString());
			}

		    writer.close();
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
