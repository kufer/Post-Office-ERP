package PostOffice;
import java.io.*;
import java.util.*;
import PostOffice.*;
public class foreignSpeed 
{
	final static protected String srcPin = "560025";
	final static protected String type = "F";
	final static protected double serTax = 0.10;
    final static protected double eduCes = 0.02;
    
    
    /*these variables are not manipulated in any of the functions below once they are 
     *assigned their values*/
    static protected String addLine1 = "";
    static protected String addLine2 = "";
    static protected String addLine3 = "";
    static protected String city = "";
    static protected String state = "";
    static protected String contentType = "";
    static protected String weight = "";
    
    static Calendar cal = Calendar.getInstance();
    
    static protected String date = cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
	static protected String time = cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
		
    
    static BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
    
	public static void sendInternationalSpeed() throws IOException
	{
	     for(int i=0;i<4;i++)
		 System.out.println();
	
	
	     String country = "";
	     String text = "";
	     String barcode = "";
	     String postalCode = "";
	     double rate = 0;
	     int countOpt = 0;
	     int Weight = 0;
	     int ctr = 0;
	     int i = 0;
	     int det = 0;
	     boolean flag = true;
	     boolean valid  = true;
	     
	     System.out.println("Enter the following details:");
	     System.out.println();
	     
	     //begin address input
	     do
	     {
	     	System.out.println("Address Line 1: ");
	        addLine1 = keyin.readLine();
	        
	        if(addLine1.length() == 0)
	        {
	        	System.out.println("This is a mandatory field!");
	        }
	     }
	     while(addLine1.length() == 0);
	     
	     System.out.println("Address Line 2: ");
	     addLine2 = keyin.readLine();
	     
	     System.out.println("Address Line 3: ");
	     addLine3 = keyin.readLine();
	     
	     //begin city input
	     do
	     {
	     	System.out.println("City: ");
	        city = keyin.readLine();
	        
	        if(!validate.validLocation(city))
	        {
	        	System.out.println();
	        	System.out.println("The entered city has non-alphabetical characters!");
	        	System.out.println("Please re-enter the city correctly.");
	        	System.out.println();
	        }
	     }	
	     while(!validate.validLocation(city));
	     //end of city input
	     
	     do
	     {
	     	System.out.println("State/District/Province: ");
	        state = keyin.readLine();
	        
	        if(!validate.validLocation(state))
	        {
	        	System.out.println();
	        	System.out.println("The entered city has non-alphabetical characters!");
	        	System.out.println("Please re-enter the city correctly.");
	        	System.out.println();
	        }
	     }	
	     while(!validate.validLocation(state));
	     
	   
	     //begin country input
	     System.out.println("Country: ");
	     System.out.println();
	     	 
	     outer:
	     do
	     {
	     	 flag = true;
	     	
	     	 System.out.println("Please key in the corresponding number for the State or Union Territory");
	     	 System.out.println();
	     	 System.out.println("1 -- Argentina");
			 System.out.println("2 -- Australia");
			 System.out.println("3 -- Austria");
			 System.out.println("4 -- Bahrain");
			 System.out.println("5 -- Bangladesh");
			 System.out.println("6 -- Barbados");
			 System.out.println("7 -- Belarus");
			 System.out.println("8 -- Belgium");
			 System.out.println("9 -- Bermuda");
			 System.out.println("10 -- Bhutan");
			 System.out.println("11 -- Botswana");
			 System.out.println("12 -- Brunei");
			 System.out.println("13 -- Bulgaria");
			 System.out.println("14 -- Cambodia");
			 System.out.println("15 -- Canada");
			 System.out.println("16 -- Cape Verde");
			 System.out.println("17 -- Cayman Iles");
			 System.out.println("18 -- China");
			 System.out.println("19 -- Cuba");
			 System.out.println("20 -- Cyprus");
			 System.out.println("21 -- Denmark");
			 System.out.println("22 -- Egypt");
			 System.out.println("23 -- El Salvador");
			 System.out.println("24 -- Eritrea");
			 System.out.println("25 -- Estonia");
			 System.out.println("26 -- Ethiopia");
			 System.out.println("27 -- Fiji");
			 System.out.println("28 -- France");
			 System.out.println("29 -- Georgia");
			 System.out.println("30 -- Germany");
			 System.out.println("31 -- Ghana");
			 System.out.println("32 -- Greece");
			 System.out.println("33 -- Guyana");
			 System.out.println("34 -- Hong Kong");
			 System.out.println("35 -- Hungary");
			 System.out.println("36 -- Iceland");
			 System.out.println("37 -- Indonesia");
			 System.out.println("38 -- Iran");
			 System.out.println("39 -- Iraq");
			 System.out.println("40 -- Ireland");
			 System.out.println("41 -- Israel");
			 System.out.println("42 -- Italy");
			 System.out.println("43 -- Japan");
			 System.out.println("44 -- Jordan");
			 System.out.println("45 -- Kenya");
			 System.out.println("46 -- Kuwait");
			 System.out.println("47 -- Latvia");
			 System.out.println("48 -- Luxemburg");
			 System.out.println("49 -- Macau");
			 System.out.println("50 -- Malawi");
			 System.out.println("51 -- Malaysia");
			 System.out.println("52 -- Maldives");
			 System.out.println("53 -- Mangolia");
			 System.out.println("54 -- Mauritius");
			 System.out.println("55 -- Mexico");
			 System.out.println("56 -- Morocco");
			 System.out.println("57 -- Namibia");
			 System.out.println("58 -- Nauru");
			 System.out.println("59 -- Nepal");
			 System.out.println("60 -- Netherlands");
			 System.out.println("61 -- New Zealand");
			 System.out.println("62 -- Niger");
			 System.out.println("63 -- Nigeria");
			 System.out.println("64 -- Norway");
			 System.out.println("65 -- Oman");
			 System.out.println("66 -- Pakistan");
			 System.out.println("67 -- Panama");
			 System.out.println("68 -- Papua New Guinea");
			 System.out.println("69 -- Phillippines");
			 System.out.println("70 -- Poland");
			 System.out.println("71 -- Portugal");
			 System.out.println("72 -- Qatar");
			 System.out.println("73 -- Romania");
			 System.out.println("74 -- Russia");
			 System.out.println("75 -- Rwanda");
			 System.out.println("76 -- Saudi Arabia");
			 System.out.println("77 -- Senegal");
			 System.out.println("78 -- Singapore");
			 System.out.println("79 -- South Korea");
			 System.out.println("80 -- Spain");
			 System.out.println("81 -- Sri Lanka");
			 System.out.println("82 -- Sudan");
			 System.out.println("83 -- Sweden");
			 System.out.println("84 -- Switzerland");
			 System.out.println("85 -- Taiwan");
			 System.out.println("86 -- Tanzania");
			 System.out.println("87 -- Thailand");
			 System.out.println("88 -- Tunisia");
			 System.out.println("89 -- Turkey");
			 System.out.println("90 -- U.A.E.");
			 System.out.println("91 -- U.S.A.");
			 System.out.println("92 -- Uganda");
			 System.out.println("93 -- Ukraine");
			 System.out.println("94 -- United Kingdom");
			 System.out.println("95 -- Vietnam");
			 System.out.println("96 -- Yemen");
			 System.out.println("97 -- Zaire");

             System.out.println();

             try
             {
                 countOpt = Integer.parseInt(keyin.readLine());
             }
                    
             catch(NumberFormatException e)
             {
                 System.out.println("You entered non-numeric characters.");
                 System.out.println("Please re-enter your option correctly.");
                 System.out.println();
                 flag = false;
                 continue; 
             }
                    
             if(countOpt < 1 || countOpt > 96)
             {
                  System.out.println("You entered an invalid choice!");
	        	  System.out.println("Please re-enter your option correctly.");
	        	  System.out.println();
             }
             else
             {
                  FileReader fin = new FileReader("international_info_tariff.txt");//reading the state based on the corresponding input number
		          BufferedReader bin = new BufferedReader(fin);
		                
		          while((text = bin.readLine()) != null)
		          {
		              ctr++;
		              if(ctr % 5 == 1)
		              {  
		                 i++;
		                 if(countOpt == i)
		             	 {  
		                	country = text.trim();
		                	System.out.println("Country: " + country);
		                	System.out.println();
		               		break outer;
		                 }
		              }
		          }
		          bin.close();
             }
          }
          while((countOpt < 1 || countOpt > 96) || flag == false);//end of inner do-while
	      
	      do
	      {
	      	 System.out.println();
	      	 System.out.println("Postal Code: ");
	      	 postalCode = keyin.readLine();
	         System.out.println();
	         
	         if(!validate.validInternationalPostCode(country, postalCode))
	         {
	         	System.out.println("Sorry, as per our existing record the entered Postal Code does not belong to the entered country("+ country + ").");
	         	System.out.println();
	         	System.out.println("The possible errors could be: ");
	         	System.out.println("1 - The format of the entered code is incorrect.");
	         	System.out.println("2 - The code does not exist.");
	         	System.out.println();
	         	System.out.println("This is only a precautionary measure and is not neccesarily true, IndiaPost cannot be held liable if the entered Postal Code is indeed correct.");
	         	System.out.println();
	         	
	         	do
	         	{
	         		System.out.println("If you wish to re-enter the Postal Code, hit '1'.");
	         	    System.out.println("If you wish to proceed, hit '2'.");
	         	    System.out.println();
	         	    
	         	    try
	         	    {
	         	    	det = Integer.parseInt(keyin.readLine());
	         	    }
	         	    catch(NumberFormatException e)
	         	    {
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
	         }
	      }
	      while(det == 1);   
	          
	      System.out.println();
	      
	      do
	      {
	     	 System.out.println("Enter the type of contents:");
	         contentType = keyin.readLine();
	        
	         if(contentType.length() == 0)
	         {
	        	 System.out.println("This is a mandatory field!");
	         }
	      }
	      while(contentType.length() == 0);
	      
	      System.out.println();
	      
	      //begin weight input
	      do
	      {
	      	
              valid = true;
              	      	
	      	  System.out.println("Enter the weight in grammes:");
	      	  System.out.println("Enter only numeric characters, no special characters are allowed!");
	          weight = keyin.readLine();
	          System.out.println();
	          
	          if(weight.length() == 0)
	          {
	        	  System.out.println("This is a mandatory field!");
	        	  System.out.println();
	        	  continue;
	          }
	          
	          
	          if(!validate.validNum(weight))
	          {
	          	  System.out.println("The entered weight is not a number!");
	          	  System.out.println("Please re-enter correctly.");
	          	  System.out.println();
	          	  continue;
	          }
	          else
	          {
	          	  Weight = Integer.parseInt(weight);
	          }
	          
	          if(Integer.parseInt(weight) > 10000 || Integer.parseInt(weight) < 0)
	          {
	          	  System.out.println("The entered value is out of bounds. Maximum weight is 10000 gms.");
	          	  System.out.println();
	          	  valid = false;
	          	  continue;
	          }
	          else
	          {
	          	  Weight = Integer.parseInt(weight);
	          }
	          
	          System.out.println();
	      }
	      while(!validate.validNum(weight) || valid == false);
	      
	      //end of inputs, call of methods
	      
	      rate = getInternationalRate(country, Weight);
	      
	      barcode = indiaSpeed.barcodeGen(type);
	      
          internationalDisplay(country, postalCode, barcode, rate);
	}
	
	/*function to calculate the rate for the post based on its weight and destination.*/
	public static double getInternationalRate(String toCountry, int weight) throws IOException
	{
		String text = "";
		String distance = "";
		String first250 = ""; 
		String per250mo = "";
		double rate = 0;
		int ctr = 0;
		boolean flag = false;
		
		if(toCountry.equalsIgnoreCase("Bhutan"))
		{
			if(weight <= 200)
			{
				rate = 75;
			}
			else if(weight > 200 && weight <= 1000)
			{
				rate = 75 + (((weight - 200) / 200d) * 15);
			}
			else
			{
				rate = 75 + 4*15 + (((weight - 1000) / 500d) * 40);
			}
			
			rate = rate + (rate * serTax) + (rate * eduCes);
		
		    return Math.rint(rate);
		}
		
		FileReader fin = new FileReader("international_info_tariff.txt");
		BufferedReader bin = new BufferedReader(fin);
	
		while((text = bin.readLine()) != null)
		{
			if((text.trim()).equalsIgnoreCase(toCountry))
			{
			    ctr = 0;
			    flag = true;
			}   
			
			ctr++;

			if(ctr == 3 && flag == true)
			{
				first250 = text;
				per250mo = text = bin.readLine();
				break;
			}
		}
		bin.close();
		
		if(weight <= 250)
		{
			rate = Double.parseDouble(first250);
		}
		else
		{
			rate = Double.parseDouble(first250) + (((weight - 250) / 250d) * Double.parseDouble(per250mo));
		}
		
		rate = rate + (rate * serTax) + (rate * eduCes);
		
		return Math.rint(rate);
	}
	
	/*function to write the details of the post to a date speed log.*/
	public static void writeToInternationalDateSpeedLog(String bCode, String country, String ZIP, double rate) throws IOException
	{	
	    String filename = "";
	    
		filename = date + "INTL.txt";
		
		FileWriter fout = new FileWriter(filename, true);
		BufferedWriter bout = new BufferedWriter(fout);
		PrintWriter out = new PrintWriter(bout);
		
		out.println(bCode);
		out.println(country + "," + ZIP);
		out.println("Rs." + rate + "/-");
		out.println(weight + "gm");
		out.println(contentType);
		out.println(time);
		out.println();
		out.println("* * * * *");
		
		out.close();
	}
	
	/*function to display the speed post summary.*/
	public static void internationalDisplay(String Country, String ZIP, String bCode, double Rate) throws IOException
	{
		int det = 0;
		
		System.out.println();
		System.out.println("-----Speed Post Confirmation-----");
		System.out.println();
		System.out.println(bCode);
		System.out.println();
		System.out.println(date);
		System.out.println(time);
		System.out.println();
		System.out.println("Rs." + Rate + "/-");
		System.out.println("Content Type: " + contentType);
		System.out.println();
		System.out.println(addLine1);
		
		if(addLine2.length() != 0)
		{
			System.out.println(addLine2);
		}
		if(addLine3.length() != 0)
		{
			System.out.println(addLine3);
		}
	    if(city.length() != 0)
		{
			System.out.println(city);
		}
		if(state.length() != 0)
		{
			System.out.println(state);
		}
		
		System.out.println(Country);
		System.out.println(ZIP);
		System.out.println();
		System.out.println("-------THANK YOU-------");
		
		do
		{
			System.out.println();
			System.out.println("If you have entered any of the requested information incorrectly and wish to re-enter the same: Key in '1'.");
		    System.out.println("If you have entered the requested information correctly.: Key in '2'.");
		    det = Integer.parseInt(keyin.readLine());
		    System.out.println();
		    
		    if(det == 1)
		    {
		    	System.out.println();
		    	sendInternationalSpeed();
		    }
		    else if(det == 2)
		    {
		    	writeToInternationalDateSpeedLog(bCode, Country, ZIP, Rate);
		    	indiaSpeed.writeToCodeLog(bCode);
		    	System.out.println();
		    	menu.exitMenu("foreignSpeed");
		    }
		    else
		    {
		    	System.out.println("You entered an invalid choice!");
	        	System.out.println("Please re-enter your option correctly.");
	        	System.out.println();
	        	continue;
		    }
		} 
		while(det != 1 || det != 2); 
	}
}
