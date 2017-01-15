import java.util.ArrayList;

public class VForm {

	// fields
	float totRevenue;	// from B forms
	
	// expenditure
	private float empSalary;	// from S form
	private float agenSalary;	// from T form
	private float materials;	// from O form
	private float investment;	// from R form
	private float consFee;		// from R form
	private float totExpenditure;	// sum of all expenditures
	private float profit;		// revenue - expenditures
	
	// game session
	Game game;
	
	// constructor
	public VForm(Game game){
		this.game = game;
		
		empSalary = 0;	
		agenSalary = 0;	
		materials = 0;
		investment = 0;	
		consFee = 0;		
		totExpenditure = 0;	
		profit = 0;
	}
	
	// set all the values before outputting
	public void analyzeData(){
		setTotRevenue();
		setEmpSalary();
		setAgenSalary();
		setMaterials();
		setInvestment();
		setConsFee();
		setTotExpenditure();
		setProfit();
	}
	
	// setter methods
	public void setTotRevenue(){
		for (int i = 0; i < game.bForms.size(); i++){
			totRevenue += game.bForms.get(i).getRevenue();
		}
	}
	
	public void setEmpSalary(){
		// to do
	}
	
	public void setAgenSalary(){
		// to do
	}
	
	public void setMaterials(){
		// to do
	}
	
	public void setInvestment(){
		// to do
	}

	public void setConsFee(){
		// to do
	}
	
	public void setTotExpenditure(){
		totExpenditure = empSalary + agenSalary + materials + investment + consFee;
	}
	
	public void setProfit(){
		profit = totRevenue - totExpenditure;
	}
	
	// getter methods
	public float getTotRevenue(){
		return totRevenue;
	}
	
	public float getEmpSalary(){
		return empSalary;
	}
	
	public float getAgenSalary(){
		return agenSalary;
	}
	
	public float getMaterials(){
		return materials;
	}
	
	public float etInvestment(){
		return investment;
	}

	public float getConsFee(){
		return consFee;
	}
	
	public float getTotExpenditure(){
		return totExpenditure;
	}
	
	public float getProfit(){
		return profit;
	}
}
