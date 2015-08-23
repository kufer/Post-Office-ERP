package PostOffice;
import java.io.*;
import java.util.*;
import PostOffice.*;
public class menu
{
	static BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void startMenu() throws IOException
	{
		System.out.println();
		int det = 0;
		int opt = 0;
    	boolean flag = true;
		
		do
 		{
 			flag = true;
 			System.out.println("\t\tPOSTAL SERVICES ");
 			System.out.println();
 			System.out.println("Enter your option:");
 			System.out.println("1 -- SpeedPost");
 			System.out.println("2 -- Indian Money Order");
 			System.out.println("3 -- e-Billing");
 			System.out.println("4 -- Stamps");
 			System.out.println("5 -- Exit");
 			System.out.println();
 			
 			try
        	{
            	det = Integer.parseInt(keyin.readLine());
        	}
        	catch(NumberFormatException e)
        	{
            	System.out.println("You entered non-numeric characters.");
            	System.out.println("Please re-enter your option correctly.");
            	System.out.println();
            	flag = false;
            	continue; 
        	}
                    
        	if(det < 1 || det > 5)
        	{
            	System.out.println("You entered an invalid choice!");
	        	System.out.println("Please re-enter your option correctly.");
	        	System.out.println();
	        	flag = false;
        	}
 		}
 		while(flag == false);
 		
 		flag = true;
 		
 		if(det == 1)
 		{
 			do
 			{
 				flag = true;
 				
 				System.out.println("Enter your option:");
 				System.out.println("1 -- National or Local SpeedPost");
 				System.out.println("2 -- International Speed Post");
 				System.out.println("3 -- Tracking and Information Services");
 				System.out.println();
 				
 				try
        		{
            		opt = Integer.parseInt(keyin.readLine());
        		}
        		catch(NumberFormatException e)
        		{
            		System.out.println("You entered non-numeric characters.");
            		System.out.println("Please re-enter your option correctly.");
            		System.out.println();
            		flag = false;
            		continue; 
        		}
                    
        		if(opt < 1 || opt > 3)
        		{
            		System.out.println("You entered an invalid choice!");
	        		System.out.println("Please re-enter your option correctly.");
	        		System.out.println();
	        		flag = false;
        		}
 			}
 			while(flag == false);
 			
 			if(opt == 1)
 			{
 				indiaSpeed.sendNationalSpeed();
 			}
 			else if(opt == 2)
 			{
 				foreignSpeed.sendInternationalSpeed();
 			}
 			else
 			{
 				tracking.start();
 			}
 		}
 		
 		else if(det == 2)
 		{
 			IMO.sendIMO();
 		}
 		
 		else if(det == 3)
 		{
 			do
 			{
 				flag = true;
 				System.out.println();
 				System.out.println("Enter your option:");
 				System.out.println("1 -- Electricity Billing");
 				System.out.println("2 -- Phone Billing");
 				System.out.println("3 -- Water Billing");
 				System.out.println();
 				
 				try
        		{
            		opt = Integer.parseInt(keyin.readLine());
        		}
        		catch(NumberFormatException e)
        		{
            		System.out.println("You entered non-numeric characters.");
            		System.out.println("Please re-enter your option correctly.");
            		System.out.println();
            		flag = false;
            		continue; 
        		}
                    
        		if(opt < 1 || opt > 3)
        		{
            		System.out.println("You entered an invalid choice!");
	        		System.out.println("Please re-enter your option correctly.");
	        		System.out.println();
	        		flag = false;
        		}
 			}
 			while(flag == false);
 			
 			if(opt == 1)
 			{
 				electricityBilling.start();
 			}
 			else if(opt == 2)
 			{
 				phoneBilling.start();
 			}
 			else
 			{
 				waterBilling.start();
 			}
 		}
 		
 		else if(det == 4)
 		{
 			for(int i =0;i<4;i++)
 			System.out.println();
 			System.out.println("\t Stamps Services ");
 			System.out.println();
 			stamps.start();
 		}
 		
 		else
 		{
 			System.exit(5);
 			System.out.println(" Thank you ... for using this service");
 		}
	}
	
	public static void exitMenu(String classname) throws IOException
 	{
    	int  det = 0;
    	boolean flag = true;
 		
 		do
 		{
 			flag = true;
 			System.out.println();
 			System.out.println("Enter your option:");
 			System.out.println("1 -- If you want to repeat the process again");
 			System.out.println("2 -- Go to main menu");
 			System.out.println("3 -- Exit");
 			System.out.println();
 		
 			try
        	{
            	det = Integer.parseInt(keyin.readLine());
        	}
        	catch(NumberFormatException e)
        	{
            	System.out.println("You entered non-numeric characters.");
            	System.out.println("Please re-enter your option correctly.");
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
 			if(classname.equals("foreignSpeed"))
 			{
 				foreignSpeed.sendInternationalSpeed();
 			}
 			else if(classname.equals("indiaSpeed"))
 			{
 				indiaSpeed.sendNationalSpeed();
 			}
 			else if(classname.equals("IMO"))
 			{
 				IMO.sendIMO();
 			}
 			else if(classname.equals("tracking"))
 			{
 				tracking.start();
 			}
 			else if(classname.equals("electricityBilling"))
 			{
 				electricityBilling.start();
 			}
 			else if(classname.equals("phoneBilling"))
 			{
 				phoneBilling.start();
 			}
 			else if(classname.equals("waterBilling"))
 			{
 				waterBilling.start();
 			}
 			else if(classname.equals("stamps"));
 			{
 				stamps.start();
 			}
 		}
 		else if(det == 2)
 		{
 			startMenu();
 		}
 		else
 		{
 			System.out.println("Thank You for using this service.");
 			System.exit(5);
 		}
 	}
}
