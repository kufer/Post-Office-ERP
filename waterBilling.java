package PostOffice;
import java.io.*;
import java.util.*;
import PostOffice.*;
public class waterBilling
{
	static protected String accNum = "";
	
	static Calendar cal = Calendar.getInstance();
    
    static protected String date = cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
	static protected String time = cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
    
	static BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
	
	public static void start() throws IOException
	
	{
		for(int i=0;i<4;i++)
		System.out.println();
		boolean flag = true;
	
	        System.out.println("\t\t Water Billing");
			System.out.println();
		do
		{
			flag = true;
			
			System.out.println("Please enter your account number in the format ####.");
			accNum = keyin.readLine();  // accepts the account number

			flag = validate.validNum(accNum);
	    	
	    	if(flag == false)
	    	{
	    		System.out.println();
	    		System.out.println("You entered non-numeric characters!");
	    		System.out.println("Please re-enter correctly.");
	    		System.out.println();
	    	}
	    	
	    	if(accNum.length() != 4)
			{
				System.out.println("You entered an account number of more than 4 digits!");
				System.out.println();
				flag = false;
			}
		} 
		while(flag == false);
		
		isAccExist();
	}

	public static void isAccExist() throws IOException
	{
		String text = "";
		boolean exist = false;
		boolean flag = true;
		int det = 0;
		
		FileReader fin = new FileReader("water_info.txt");
		BufferedReader bin = new BufferedReader(fin);
	
		while((text = bin.readLine()) != null)
		{
			if((text.trim()).equals(accNum))
			{
				exist = true;
			}
		}
		bin.close();
		
		if(exist == true)
		{
			displayBill();
		}
		else 
		{
			do
			{
				flag = true;
				
				System.out.println();
				System.out.println("The account number you entered does not exist.");
				System.out.println();
				System.out.println("Please enter your option.");
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
		    		System.out.println("Please re-enter correctly.");
		    		System.out.println();
		    		flag = false;
		    		continue;
		    	}
		    	
		    	if(det != 1 && det != 2 && det != 3)
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
	}

	public static void displayBill() throws IOException  // displays bill
	{
		String text = "";
		boolean flag = false;
		int ctr = 0;
		int det = 0;
		
		FileReader fin = new FileReader("water_info.txt");
		BufferedReader bin = new BufferedReader(fin);
	
		System.out.println();
		System.out.println("-----------WATER BILL----------");
		System.out.println();
	
		while((text = bin.readLine()) != null)
		{
			if((text.trim()).equalsIgnoreCase(accNum))
			{
				ctr = 0;
				flag = true;
			}
		
			if(ctr == 0 && flag == true)
			{ 
				System.out.println("*** \tConsumer ID    " + text);
				System.out.println();
			}
	
			if(ctr == 1 && flag == true)
			{ 
				System.out.println("*** \tSubdivision    " + text);
				System.out.println();
			}
		
			if(ctr == 2 && flag == true)
			{
				System.out.println("*** \tConsumer Name  " + text);
				System.out.println();
			}
	
			if(ctr == 3 && flag == true)
			{
				System.out.println("*** \tType:          " + text);
				System.out.println();
			}
	
			if(ctr == 4 && flag == true)
			{
				System.out.println("*** \tBill number    " + text);
				System.out.println();
			}
	
			if(ctr == 5 && flag == true)
			{
				System.out.println("*** \tAmount:        " + "Rs." + text + "/-");
				System.out.println();
			} 
			
			ctr++;
		}
		bin.close();
		
		System.out.println("-----------THANK YOU----------");
		
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
		    	menu.exitMenu("waterBilling");
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
