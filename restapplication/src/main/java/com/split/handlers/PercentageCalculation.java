package com.split.handlers;



public class PercentageCalculation {
	
	public PercentageCalculation() 
	{
		//this(null); 
		}
	/*public PercentageCalculation(Class<?> clazz) 
	{ 
		super(clazz); 
	} */

			public double getweekPercentage(double wpercent,double tquantity){
			double calculatedpercentage=0;
			calculatedpercentage=tquantity * wpercent/100;	
			System.out.println("w1calpercent" +calculatedpercentage);
			
			return calculatedpercentage;
				}
			
			public double validateTotalQuantity(){
				double calculatedTotalQuantity=0;
				
				return calculatedTotalQuantity;
				
			}
}
