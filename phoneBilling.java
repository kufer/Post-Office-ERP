package PostOffice;
import java.io.*;
import java.util.*;
import PostOffice.*;
public class phoneBilling
{	
    static BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
	
	static protected String number = "";
	static protected String filename = "";
	
	static Calendar cal = Calendar.getInstance();
    
    static protected String date = cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
	static protected String time = cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
	
	public static void start() throws IOException
	{
		for(int i = 0;i < 4;i++)
		System.out.println();
	
	
	    System.out.println("\t\t Phone Billing");
	    System.out.println();
		String text = "";
		String landline = "";
		String mobile = "";
		int ctr = 0;
		int err = 0;
		int len = 0;
		int det = 0;
		int opt = 0;
		boolean valid = true;
		boolean flag  = false;
		boolean inc = true;
		
	    do
	    {
	    	valid = true;
	    	
			System.out.println("Please enter your phone number: ");
			number = keyin.readLine();
		
			err = validate.validTeleNumber(number);
    		
    		if(err == 1)
    		{
    			System.out.print("The entered phone number is not of length 8 or 10 or 11 digits.");
    			System.out.println("Please re-enter correctly.");
    			System.out.println();
    			valid = false;
    		}
    		else if(err == 2)
    		{
    			System.out.print("The entered phone number has non-numeric characters.");
    			System.out.println("Please re-enter correctly.");
    			System.out.println();
    			valid = false;
    		}
  
	  	}
	    while(valid == false);
	    
		landline = number.substring(0,3);
		mobile = number.substring(0,4);
		
		if(mobile.equals("0948"))
		{
			number = number.substring(1,11);
		}
		
		if(landline.equals("080"))
		{
			number = number.substring(3,11);
		}
		
		len = number.length();
		
		if(len == 10)
		{
			filename = "bsnl_mobile_info.txt";
		}
		
		if(len ==  8)
		{
			filename = "bsnl_landline_info.txt";
		}
		
		
		FileReader fin = new FileReader(filename);
	    BufferedReader bin = new BufferedReader(fin);
        
        while((text = bin.readLine()) != null)
		{
			if(text.equalsIgnoreCase(number))
			{
				ctr = 0;
				flag = true;
			}
					
			if(ctr == 0 && flag == true )
			{ 
		    	System.out.println();
		    	System.out.println("\t\tBSNL");
		    	System.out.println();
		    	System.out.println("-------------TELEPHONE BILL-------------");
		    	System.out.println();    
				System.out.println("*** \tPhone Number:   " + text);
				System.out.println(); 
			}
			
	    	if(ctr == 1 && flag == true)
	   		{
	    		System.out.println("*** \tName:           " + text);
	    		System.out.println(); 
	    	}
	    	if(ctr == 2 && flag == true)
	    	{ 
	  			System.out.println("*** \tAccount Number: " + text);
	  			System.out.println(); 
	  		}
	    	if(ctr == 3 && flag == true)
	    	{ 
	       		System.out.println("*** \tTariff Plan:    " + text);
	       		System.out.println(); 
	       	}
	    	if(ctr == 4 && flag == true)
	    	{ 
	       		System.out.println("*** \tBill Amount: " + "Rs." + text + "/-"); 
	       		System.out.println(); 

     			System.out.println("---------------THANK YOU---------------");
     			System.out.println();
				System.out.println(date);
				System.out.println(time);
				System.out.println();
	       	}		
		    
		    ctr++;						
     	}
     	bin.close();
     
     	if(flag == false)
     	{
     		do
			{
				inc = true;
				
				System.out.println();
				System.out.println("As per our records the entered number does not exist.");
				System.out.println();
				System.out.println("Please enter your option.");
				System.out.println("1 -- To re-enter the phone number.");
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
		    		inc = false;
		    		continue;
		    	}
		    
		    	
		    	if(det != 1 && det != 2 && det != 3)
                {
                   	System.out.println("You entered an invalid choice!");
	        	    System.out.println("Please re-enter your option correctly.");
	        	    System.out.println();
	        	    inc = false;
                }
			}
			while(inc == false);
			
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
		
		do
		{
			System.out.println();
			System.out.println("If you have entered any of the requested information incorrectly and wish to re-enter the same: Key in '1'.");
		    System.out.println("If you have entered the requested information correctly: Key in '2'.");
		    
		    try
		    {
		    	opt = Integer.parseInt(keyin.readLine());
		    }
		    catch(NumberFormatException e)
		    {
		    	System.out.println();
		    	System.out.println("You entered non-numeric characters.");
		    	System.out.println("Please re-enter your option correctly.");
		    	continue;
		    }
		   
		    System.out.println();
		    
		    if(opt == 1)
		    {
		    	System.out.println();
		    	start();
		    }
		    else if(opt == 2)
		    {
		    	System.out.println();
		    	menu.exitMenu("phoneBilling");
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
		while(opt != 1 && opt != 2); 
	}	   
}
	
	
