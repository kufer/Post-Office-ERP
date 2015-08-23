package PostOffice;
import java.io.*;
import java.util.*;
import PostOffice.*;
public class tracking
{
	
	static BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
    
	
	public static void start() throws IOException
	{
		String code = "";
		String filename = "";
		String location = "";
		boolean flag = true;
		boolean valid = true;
		int det = 0;
		int opt = 0;
		int err = 0;
		for(int i=0;i<4;i++)
		System.out.println();
		do
		{
			System.out.println("Please enter your choice.");
			System.out.println("1 -- to track a speed post");
			System.out.println("2 -- to get the details of a speed post or iMO.");
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
                det = 5;
                continue; 
            }
			
			if(det != 1 && det != 2)
            {
                 System.out.println("You entered an invalid choice!");
	        	 System.out.println("Please re-enter your option correctly.");
	        	 System.out.println();
            }
		}
		while(det != 1 && det != 2);
		
		do
		{
			flag = true;
			
			System.out.println("Please enter the barcode of the speed post or iMO.");
			System.out.println("The format is ######XXXXXXX, and is case sensitive.");
			code = keyin.readLine();
			System.out.println();
			
			err = validate.validBarcode(code);
			
			if(err == 1)
			{
    			System.out.println("The length of the entered barcode is not 13 characters in length!");
    			System.out.println("Please re-enter correctly.");
    			System.out.println();
    			flag = false;
    			continue;
			}
			
			if(err == 2 || err == 3)
			{
				System.out.println("The entered barcode is not in the format ######XXXXXXX.");
    			System.out.println("Please re-enter correctly.");
    			System.out.println();
    			flag = false;
    			continue;
			}
			
			if(err == 4)
			{
				System.out.println("As per our record, the entered barcode does not exist.");
				System.out.println("It is possible that the case of the entered barcode is incorrect.");
    			
    			do
    			{
    				valid = true;
    				
    				System.out.println("Please enter your option:");
					System.out.println("1 -- To re-enter the barcode.");
					System.out.println("2 -- To view the main menu.");
					System.out.println("3 -- To exit the system.");
		    		System.out.println();
		    		try
		    		{
		    			opt = Integer.parseInt(keyin.readLine());
		    		}
		    		catch(NumberFormatException e)
		    		{
		    			System.out.println("You entered non-numeric characters!");
		    			System.out.println("Please re-enter correctly");
		    			System.out.println();
		    			valid = false;
		    			continue;
		    		}
		    	
		    		if(opt < 1 || opt > 3)
                	{
                   		System.out.println("You entered an invalid choice!");
	        	    	System.out.println("Please re-enter your option correctly.");
	        	    	System.out.println();
	        	    	valid = false;
                	}
    			}
    			while(valid == false);
    			
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
    			
    			System.out.println();
			}
			
			if(err == 0)
			{
				flag = true;
			}
		}
		while(flag == false);
		
		filename = getFilenameFromCode(code);
		
		if(det == 1)
		{
			if(code.charAt(12) == 'M')
			{
				System.out.println("Sorry, but we do not track iMO.");
				System.exit(5);
			}	
			
			location = track(code, filename);
			
			if(location.length() == 0)
			{
				System.out.println("Sorry, we do not have an exact location for " + code + ".");
			}
			else
			{
				System.out.println("Current Location of " + code + ": ");
				System.out.println(location);
			}
			
			System.out.println();
		    menu.exitMenu("tracking");
		}
		else
		{
			System.out.println("Details of " + code + " : ");
			System.out.println();
			getDetails(code, filename);
			
			System.out.println();
		    menu.exitMenu("tracking");
		}
	}
	
	/*function to determine whether the entered barcode is of a national or 
	 *international speed post or an iMO and hence obtain the date speed log.*/
	public static String getFilenameFromCode(String Code) throws IOException
	{
		String type = "";
		String date = "";
		String day = "";
		String month = "";
		String year = "";
		String filename = "";
		
		type = Character.toString(Code.charAt(12));
		
		if(Character.isUpperCase(Code.charAt(6)))
		{
			day = Integer.toString((int)(Code.charAt(6)) - 64);
		}
		else
		{
			day = Integer.toString((int)(Code.charAt(6)) - 70);
		}
		
		month = Integer.toString((int)(Code.charAt(7)) - 64);
		
		if(Code.charAt(8) < 'j')
		{
			year = "200" + Integer.toString((int)(Code.charAt(8)) - 64);
		}
		else
		{
			year = "20" + Integer.toString((int)(Code.charAt(8)) - 64);
		}
		
		date = day + "-" + month + "-" + year;
		
		if(type.equals("N"))
		{
			filename =  date + "NATL.txt";
		}
		else if(type.equals("F"))
		{
			filename = date + "INTL.txt";
		}
		else
		{
			filename = date + "IMON.txt";
		}
		
		return filename;
	}
	
	/*function to obtain the current location of the entered barcoded post from its date log*/
	public static String track(String Code, String Filename) throws IOException
	{
		String text = "";
		String currLocation = "";
		boolean flag = false;
		int ctr = 0;
		
		FileReader fin = new FileReader(Filename);
		BufferedReader bin = new BufferedReader(fin);
		
		while((text = bin.readLine()) != null)
		{
			if(text.equals(Code))
			{
				ctr = 0;
				flag = true;
			}
			
			ctr++;
			
			if(ctr == 7 && flag == true)
			{
				return currLocation = text;
			}
		}
		bin.close();
		
		return currLocation;
	}
	
	
	/*function to obtain the details of the entered barcoded post from its date log*/
	public static void getDetails(String Code, String Filename) throws IOException
	{
		String text = "";
		int ctr = 0;
		boolean flag = false;
		char type = ' ';
		
		type = Code.charAt(12);
		
		FileReader fin = new FileReader(Filename);
		BufferedReader bin = new BufferedReader(fin);
		
		while((text = bin.readLine()) != null)
		{
			if((text.trim()).equals(Code))
			{
				ctr = 0; 
				flag = true;
				System.out.println("Barcode: " + text);
			}
			
			if(flag == true)
			{
				if(ctr == 1)
				{
					if(type == 'N')
					{
						System.out.println("Route Barcode: " + text);
					}
					else if(type == 'F')
					{
						System.out.println("Country, Postal Code: " + text);
					}
					else
					{
						System.out.println("Remittance: " + text);
					}
				}
			
				if(ctr == 2)
				{
					if(type == 'N' || type == 'F')
					{
						System.out.println("Rate: " + text);
					}
				}
			
				if(ctr == 3)
				{
					if(type == 'N' || type == 'F')
					{
						System.out.println("Weight: " + text);
					}
					else
					{
						System.out.println("Destination Pin Code: " + text);
					}
				}
			
				if(ctr == 4)
				{
					if(type == 'N' || type == 'F')
					{
						System.out.println("Contents: " + text);
						System.out.println("Date: " + Filename.substring(0,10));
					}
					else
					{
						System.out.println("Amount Sent: " + text);
						System.out.println("Date: " + Filename.substring(0,10));
					}
				}
			
				if(ctr == 5)
				{
					System.out.println("Time: " + text);
				}
			
				if(ctr == 7)
				{
					System.out.println(text);
					break;
				}
				
				ctr++;
			}
		}
		bin.close();
	}
}
