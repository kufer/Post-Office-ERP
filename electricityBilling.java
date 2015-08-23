package PostOffice;
import java.io.*;
import java.util.*;
import PostOffice.*;


public class electricityBilling 
{
	static BufferedReader keyin = new BufferedReader(new  InputStreamReader(System.in));
	
	final static protected double serTax = 0.10;
    final static protected double eduCes = 0.02;
    final static protected double rate1 = 1.85; 
    final static protected double rate2 = 2.90; 
    final static protected double rate3 = 3.60;
    final static protected double rate4 = 4.10; 
    
    static protected String accNum = "";
    
    static Calendar cal = Calendar.getInstance();
    
    static protected String date = cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
	static protected String time = cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
	
    
    public static void start()throws IOException 
    {
    	System.out.println();
		System.out.println();
      	
      	boolean flag = true;
      
	    System.out.println("\t\t Electricity Billing");
	    System.out.println();
      	
      	do
      	
	  	{
	  		flag = true;
	  		
	  	 	System.out.println("Please enter your account number in the format #######.");
	  	 	accNum = keyin.readLine();

	  	 	if(accNum.length() != 7)
		 	{
		 		System.out.println();
		 		System.out.println("The entered account number is not seven characters in length.");
		 		System.out.println("Please re-enter correctly.");
		 		System.out.println();
		 		flag = false;
		 		continue;
		 	}
		 
		 	flag = validate.validNum(accNum);
		 
		 	if(flag == false)
		 	{
		 		System.out.println();
		 		System.out.println("The entered account number contains non numerical characters.");
		 		System.out.println("Please re-enter correctly.");
		 		System.out.println();
		 		continue;
		 	}
		 	
		 	else
		 	{
		 		searchAccount();
		 	}
		}
		while(flag == false);
	}
	
		
	public static void searchAccount() throws IOException //checks existence of the account
	{
		String text = "";
		boolean flag = true;
		boolean exist = false;
		int det = 0;
			
		FileReader fin = new FileReader("electricity_info.txt");
		BufferedReader bin = new BufferedReader(fin);	
			
		while((text = bin.readLine()) != null)
		{
			if((text.trim()).equals(accNum))
			{
				exist = true;
			}
		}
		
		bin.close();
		
		if(exist == false)
		{
			do
			{
				flag = true;
				
				System.out.println();
				System.out.println("The account number you entered does not exist.");
				System.out.println();
				System.out.println("Please enter your option:");
				System.out.println("1 -- To re-enter the account number.");
				System.out.println("2 -- To view the main menu.");
				System.out.println("3 -- To exit the system.");
		    	System.out.println();
		    	try
		    	{
		    		det = Integer.parseInt(keyin.readLine());
		    	}
		    	catch(NumberFormatException e)
		    	{
		    		System.out.println("You entered non-numeric characters!");
		    		System.out.println("Please re-enter correctly");
		    		System.out.println();
		    		flag = false;
		    		continue;
		    	}
		    	
		    	if(det < 1 || det > 3)
                {
                   	System.out.println("You entered an invalid choice!");
	        	    System.out.println("Please re-enter your option correctly.");
	        	    System.out.println();
	        	    flag = false;
                }
			}
			while(flag == false);
			
			if(det == 1)
			{
				start();
			}
			else if(det == 2)
			{
				menu.startMenu();
			}
			else
			{
				System.exit(5);
			}
		}
		
		displayAccInfo();
 	}
 	
 	public static void displayAccInfo() throws IOException//displays the account info
 	
 	{
 		String text = "";
 		boolean flag = false;
 		int ctr = 0;
 		
 		FileReader fin = new FileReader("electricity_info.txt");
		BufferedReader bin = new BufferedReader(fin);	
			
		while((text = bin.readLine()) != null)
		{
			if((text.trim()).equals(accNum))
			{
				ctr = 0; 
				flag = true;
				System.out.println();
				System.out.println("Account Number: " + text);
			}
			
			if(flag == true)
			{
				if(ctr == 1)
				{
					System.out.println("Name: " + text);
				}
				
				if(ctr == 2)
				{
					System.out.println("Address: " + text);
					break;
				}
			}
			
			ctr++;
		}
		
		bin.close();
		displayBill();
 	}
	
    public static void displayBill()throws IOException// calculates and displays the bill
    
    {  
        boolean flag = true;
        int past = 0;
        int present = 0;
        int units = 0;
        int unit1 = 0;
        int unit2 = 0; 
        int unit3 = 0; 
        int unit4 = 0;
        int det = 0;
        double amt1 = 0;
        double amt2 = 0;
        double amt3 = 0;
        double amt4 = 0;
        double tot = 0;
        String name = "";
        String line = "";
        String Past = "";
        String Present = "";
        
        
        System.out.println();
        System.out.println();
        System.out.println("\t-----------------------------------------------------------");
        System.out.println("\t                 ELECTRICITY BILL                          ");
        System.out.println("\t-----------------------------------------------------------");
        System.out.println();
         
      
        do
        {
        	flag = true;
        	
            System.out.println("Past Meter Reading: ");
            Past = keyin.readLine();
            
            if(Past.length() > 10000000)
            {
            	System.out.println("You entered an invalid meter reading.");
                System.out.println("Please re-enter correctly.");
                flag = false;
                continue;
            }
            
            try
            {
                past = Integer.parseInt(Past);
            }
            catch(NumberFormatException e)
            {
                System.out.println("You entered non-numeric characters.");
                System.out.println("Please re-enter correctly.");
                System.out.println();
                flag = false;
                continue;
            }
           
            if(past < 0)
            {	
                System.out.print("The reading you entered was less than zero!");
                System.out.println("Please re-enter correctly.");
                System.out.println();
                flag = false;
            }
         }
         while(flag == false);
         
         do
         {
         	 flag = true;
         	
             System.out.println("Present Meter Reading: ");
             Present = keyin.readLine();
            
             if(Present.length() > 10000000)
             {
            	 System.out.println("You entered an invalid meter reading.");
                 System.out.println("Please re-enter correctly.");
                 flag = false;
                 continue;
             }
             
             try
             {
                 present = Integer.parseInt(Present);
             }
             catch(NumberFormatException e)
             {
             	 System.out.println();
                 System.out.println("You entered non-numeric characters.");
                 System.out.println("Please re-enter correctly.");
                 System.out.println();
                 flag = false;
                 continue;
             }
             
             units = present - past;
            
             if(units < 0)
             {	
                 System.out.print("The present reading you entered was less than the past reading!");
                 System.out.println("Please re-enter correctly.");
                 System.out.println();
                 flag = false;
                 continue;
             }
             else if(units > 10000)
             {	
                 System.out.print("The maximum consumption per household is 10000 kWh.");
                 System.out.println("Please re-enter correctly.");
                 System.out.println();
                 flag = false;
                 continue;
            
            }
          }
          
          while(flag == false);
          
          System.out.println();   
          System.out.println("Units: " + units);
          System.out.println();   
               
          if (units > 200)
          {
              unit4 = units - 200;
              amt4 = Math.rint(unit4 * rate4);
              units = 200;
          }
          if(units > 100)
          {
              unit3 = units - 100;
              amt3 = Math.rint(unit3 * rate3);
              units = 100;
          }
          if(units > 30)            
          {
              unit2 = units - 30;
              amt2 = Math.rint(unit2 * rate2);
              units = 30;
          }
                    
          unit1 = units;
          amt1  = Math.rint(units * rate1);
          tot  = Math.rint(amt1 + amt2 + amt3 + amt4);          
                          
                    
          System.out.println("_________________________________________________________________________");
          System.out.println("DESCRIPTION \t\t\tUNITS \t\tRATE \t\tAMOUNT");
          System.out.println("_________________________________________________________________________");
          System.out.println("Meter Rent\t\t\t  \t\t");
          System.out.println("0-30 units\t\t\t" + unit1 + "\t\t" + rate1 + "\t\t"  + "Rs." + amt1 + "/-\t\t\t");
          System.out.println("30-100 units\t\t\t" + unit2 + "\t\t" + rate2 + "\t\t" + "Rs." + amt2 + "/-\t\t\t");
          System.out.println("100-200 units\t\t\t" + unit3 + "\t\t" + rate3 + "\t\t" + "Rs." + amt3 + "/-\t\t\t");
          System.out.println("above 200 units\t\t\t" + unit4 + "\t\t" + rate4 + "\t\t" + "Rs." + amt4 + "/-\t\t\t");
          System.out.println("_________________________________________________________________________");
          System.out.println("Total:\t\t\t\t" + "Rs." + tot + "/-\t\t");
          System.out.println("_________________________________________________________________________");

          System.out.println();   
          System.out.println("\t\t\t-----------THANK YOU-----------");
          System.out.println();
          
		  System.out.println(date);
		  System.out.println(time);
		  System.out.println();
		
		  do
		  {
			  System.out.println();
			  System.out.println("If you have entered any of the requested information incorrectly and wish to re-enter the same: Key in '1'.");
		      System.out.println("If you have entered the requested information correctly: Key in '2'.");
		    
		      try
		      {
		    	  det = Integer.parseInt(keyin.readLine());
		      }
		      catch(NumberFormatException e)
		      {
		    	  System.out.println();
		    	  System.out.println("You entered non-numeric characters.");
		    	  System.out.println("Please re-enter your option correctly.");
		    	  continue;
		      }
		      
		      System.out.println();
		    
		      if(det == 1)
		      {
		    	  System.out.println();
		    	  start();
		      }
		      else if(det == 2)
		      {
		    	  System.out.println();
		    	  menu.exitMenu("electricityBilling");
		      }
		      else
		      {
		    	  System.out.println();
		    	  System.out.println("You entered an invalid choice!");
	        	  System.out.println("Please re-enter your option correctly.");
	        	  System.out.println();
	        	  continue;
		      }
		  } 
		  while(det != 1 && det != 2);                                  
    }             
}               
                            
                                
