package main;

public class Round{

	private String roundNum;
	private String totalRevenue;
	private String employeeWage;
	private String aynPay;
	private String materialsSum;
	private String totalExpenditure;
	private String profitLoss;
	private Round formVData;

	public Round(String roundNum, String totalRevenue, String employeeWage, 
		String aynPay, String materialsSum, String totalExpenditure, String profitLoss){
		this.roundNum = roundNum;
		this.totalRevenue = totalRevenue;
		this.employeeWage = employeeWage;
		this.aynPay = aynPay;
		this.materialsSum = materialsSum;
		this.totalExpenditure = totalExpenditure;
		this.profitLoss = profitLoss;
	}

	public void setRoundData(Round formVData){
		this.formVData = formVData;
	}

	// getters and setters
	public String getRoundNum(){
		return roundNum;
	}
	public void setRoundNum(String roundNum){
		this.roundNum = roundNum;
	}
	public String getTotalRevenue(){
		return totalRevenue;
	}
	public void setTotalRevenue(String totalRevenue){
		this.totalRevenue = totalRevenue;
	}
	public String getEmployeeWage(){
		return employeeWage;
	}
	public void setEmployeeWage(String employeeWage){
		this.employeeWage = employeeWage;
	}
	public String getAynPay(){
		return aynPay;
	}
	public void setAynPay(String aynPay){
		this.aynPay = aynPay;
	}
	public String getMaterialsSum(){
		return materialsSum;
	}
	public void setMaterialsSum(String materialsSum){
		this.materialsSum = materialsSum;
	}
	public String getTotalExpenditure(){
		return totalExpenditure;
	}
	public void setTotalExpenditure(String totalExpenditure){
		this.totalExpenditure = totalExpenditure;
	}
	public String getProfitLoss(){
		return profitLoss;
	}
	public void setProfitLoss(String profitLoss){
		this.profitLoss = profitLoss;
	}
}