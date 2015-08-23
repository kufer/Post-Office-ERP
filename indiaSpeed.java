package PostOffice;
import java.io.*;
import java.util.*;
import PostOffice.*;
public class indiaSpeed
{
	final static protected String srcPin = "560025";
	final static protected String type = "N";
	final static protected double serTax = 0.10;
    final static protected double eduCes = 0.02;
    
    /*these variables are not manipulated in any of the functions below once they are 
     *assigned their values*/
    static protected String addLine1 = "";
    static protected String addLine2 = "";
    static protected String addLine3 = "";
    static protected String city = "";
    static protected String contentType = "";
    static protected String weight = "";
    
    static Calendar cal = Calendar.getInstance();
    
    static protected String date = cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
	static protected String time = cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
    
    
    static BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
    
	/*this method is used to accept relevant input from the user and validate it using 
	 *the functions of validate class*/
	
	public static void sendNationalSpeed() throws IOException
	{
	     
	     String state = "";
	     String pin = "";
	     String barcode = "";
	     String routeCode = "";
	     String text = "";
	     String det = "";
	     double rate = 0;
	     int stateOpt = 0;
	     int Weight = 0;
	     int choice = 0;
	     int ctr = 0;
	     int i = 0;
	     boolean flag = true;
	     boolean check = true;
	     boolean valid = true;
	     
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
	     
	     //begin state input
	     outer:
	     do
	     {
	     	 System.out.println("State: ");
	     	 System.out.println();
	     	 System.out.println("Please key in 'y' if you wish to proceed, and not enter this field.");
	     	 System.out.println("Please key in 'n' if you want to enter this field.");
	     	 det = keyin.readLine();
	     	 System.out.println();

	     	 if(det.equalsIgnoreCase("y"))
	     	 {
	     	 	break outer;
	     	 }
	     	 
	     	 else if(det.equalsIgnoreCase("n"))
	     	 {
	     	 	do
	     	 	{
	     	 		flag = true;
	     	 		
	     	 		System.out.println("Please key in the corresponding number for the State or Union Territory:");
	     	 		System.out.println();
	     	 		System.out.println("1 -- Andaman and Nicobar Islands");
                    System.out.println("2 -- Andhra Pradesh");
                    System.out.println("3 -- Arunachal Pradesh");
                    System.out.println("4 -- Assam");
                    System.out.println("5 -- Bihar");
                    System.out.println("6 -- Chandigarh");
                    System.out.println("7 -- Chattisgarh");
                    System.out.println("8 -- Dadra and Nagar Haveli");
                    System.out.println("9 -- Daman and Diu");
                    System.out.println("10 -- Delhi");
                    System.out.println("11 -- Goa");
                    System.out.println("12 -- Gujarat");
                    System.out.println("13 -- Haryana");
                    System.out.println("14 -- Himachal Pradesh");
                    System.out.println("15 -- Jammu and Kashmir");
                    System.out.println("16 -- Jharkhand");
                    System.out.println("17 -- Karnataka");
                    System.out.println("18 -- Kerala");
                    System.out.println("19 -- Lakshadweep");
                    System.out.println("20 -- Madhya Pradesh");
                    System.out.println("21 -- Maharashtra");
                    System.out.println("22 -- Manipur");
                    System.out.println("23 -- Meghalaya");
                    System.out.println("24 -- Mizoram");
                    System.out.println("25 -- Nagaland");
                    System.out.println("26 -- Orissa");
                    System.out.println("27 -- Puducherry");
                    System.out.println("28 -- Punjab");
                    System.out.println("29 -- Rajasthan");
                    System.out.println("30 -- Sikkim");
                    System.out.println("31 -- Tamil Nadu");
                    System.out.println("32 -- Tripura");
                    System.out.println("33 -- Uttar Pradesh");
                    System.out.println("34 -- Uttarakhand");
                    System.out.println("35 -- West Bengal");
                    System.out.println();

                    try
                    {
                    	stateOpt = Integer.parseInt(keyin.readLine());
                    }
                    
                    catch(NumberFormatException e)
                    {
                    	System.out.println("You entered non-numeric characters.");
                    	System.out.println();
                    	flag = false;
                    	continue; 
                    }
                    
                    if(stateOpt < 1 || stateOpt > 35)
                    {
                    	System.out.println("You entered an invalid choice!");
	        	    	System.out.println("Please re-enter your option correctly.");
	        	    	System.out.println();
                    }
                    else
                    {
                    	FileReader fin = new FileReader("states_info.txt");//reading the state based on the corresponding input number
		                BufferedReader bin = new BufferedReader(fin);
		                
		                while((text = bin.readLine()) != null)
		                {
		                	ctr++;
		                	if(ctr % 5 == 1)
		                	{
		                		i++;
		                		if(stateOpt == i)
		                		{
		                			state = text.trim();
		                			System.out.println("State: " + state);
		                			System.out.println();
		                			break outer;
		                		}
		                	}
		                }
		                bin.close();
                    }
                 }
                 while((stateOpt < 1 || stateOpt > 35) || flag == false);//end of inner do-while
	         
	          }
	          
	          else
	          {
	          	 System.out.println("You entered an invalid choice!");
	        	 System.out.println("Please re-enter your option correctly.");
	        	 System.out.println();
	          }
	      
	      }
	      while(!det.equalsIgnoreCase("y") || det.equalsIgnoreCase("n"));//end of outer do-while
	      //end of state input
	      
	      //beginning of pin code input
	      do
	      {
	     	 System.out.println("PIN Code: ");
	         pin = keyin.readLine();
	         System.out.println();
	        
             outer:
	         while(pin.equals(srcPin))
	         {
	        	 System.out.println("You are attempting to send a mail to a location under the jurisdiction of this post office.");
	        	 
	        	 do
	        	 {
	        	 	check = true;
	        	 	
	        	 	System.out.println("If you wish to continue, hit 1.");
	        	    System.out.println("If you wish to re-enter the PIN code, hit 2.");
	        	    
	        	    try
	        	    {
	        	    	choice = Integer.parseInt(keyin.readLine());
	        	    }
	        	    catch(NumberFormatException e)
	        	    {
	        	    	check = false;
	        	    }
	        	    
	        	    if(choice == 2)
	        	    {
	        		    System.out.println("PIN Code: ");
	                    pin = keyin.readLine();
	                    System.out.println();
	        	    }
	        	    else if(choice == 1)
	        	    {
	        	 	    break outer;
	        	    }
	        	    else
	        	    {
	        	    	System.out.println();
	        	    	System.out.println("You entered an invalid choice!");
	        	    	System.out.println("Please re-enter your option correctly.");
	        	    	System.out.println();
	        	    	check = false;
	        	    }
	        	 }
	        	 while(!check);
	         }
	         System.out.println();
	        
	         switch(validate.validIndianPin(pin))
	         {
	        	 case 1:
	        	 System.out.println("The entered PIN code is not a 6-digit code.");
	        	 break;
	        	
	        	 case 2:
	        	 System.out.println("The entered PIN code is not a numeric code.");
	        	 break;
	        	
	        	 case 3:
	        	 System.out.println("As per our record, the entered PIN code does not exist.");
	        	 break;
	         }
	         System.out.println();
	      }	
	      while(validate.validIndianPin(pin) != 0);
	      //end of pin code input
	      
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
	          	  System.out.println("The entered weight is not numerical!");
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
	      
	      rate = getNationalRate(getStateFromPin(pin), Weight);
	      
	      routeCode = routeBarcodeGen(pin);
	      
	      barcode = barcodeGen(type);
	      
	      display(routeCode, state, pin, barcode, rate);
	    
	}
	
	/*function to obtain the destination state based on the destination pin code*/
	public static String getStateFromPin(String PIN) throws IOException
	{
		int ctr = 0;
		int i = 0;
		int numOfTokens = 0;
		String postCirc = "";
		String text = "";
		String state = "";
	
		postCirc = PIN.substring(0,2);

		FileReader fin_1 = new FileReader("states_info.txt");
		BufferedReader bin_1 = new BufferedReader(fin_1);

		outer:
		while((text = bin_1.readLine()) != null)
		{
			ctr++;
			if(ctr % 5 == 1)
			{
				state = text.trim();
			}
			if(ctr % 5 == 4)
			{
				StringTokenizer data = new StringTokenizer(text.trim(), ",");
				numOfTokens = data.countTokens();
				int arr[] = new int[numOfTokens];
				for(i = 0;i < numOfTokens;i++)
				{
					arr[i] = Integer.parseInt(data.nextToken());
					if(arr[i] == Integer.parseInt(postCirc))
					{
						break outer;
					}
				}
			}
		}
		bin_1.close();
		
		//finding the postal circle of the state.
		if(state.equals("Andaman and Nicobar Islands"))
		{
			state = "West Bengal";
		}
		else if(state.equals("Jharkhand"))
		{
			state = "Bihar";
		}
		else if(state.equals("Chandigarh"))
		{
			state = "Punjab";
		}
		else if(state.equals("Chattisgarh"))
		{
			state = "Madhya Pradesh";
		}
		else if(state.equals("Daman and Diu") || state.equals("Dadra and Nagar Haveli"))
		{
			state = "Gujarat";
		}
		else if(state.equals("Goa"))
		{
			state = "Maharashtra";
		}
		else if(state.equals("Lakshadweep"))
		{
			state = "Kerala";
		}
		else if(state.equals("Puducherry"))
		{
			state = "Tamil Nadu";
		}
		else if(state.equals("Uttarakhand"))
		{
			state = "Uttar Pradesh";
		}
		else if(state.equals("Arunachal Pradesh") || state.equals("Manipur"))
		{
			state = "North East";
		}
		else if(state.equals("Meghalaya") || state.equals("Mizoram"))
		{
			state = "North East";
		}
		else if(state.equals("Nagaland") || state.equals("Tripura"))
		{
			state = "North East";
		}
		else
		{
			state = state;
		}
		
		return state;
	}
	
	/*function to obtain the speed post centre for the entered pin code*/ 
	public static String getPinSpeedCtr(String PIN) throws IOException
	{
		
		String viaPin = "";
		String postCirc = "";
		String state = "";
		String text = "";
		int ctr = 0;
		int i = 0;
	
		state = getStateFromPin(PIN);
		postCirc = PIN.substring(0,2);
		
		File f = new File(new File(".").getCanonicalPath() + "\\States_PIN\\" + state + "\\" + postCirc);
		File files[] = f.listFiles();//reading file from a folder.

		for(i = 0;i < files.length;i++)
		{
			if(files[i].isFile())
			{
				FileReader fin = new FileReader(files[i]);
		        BufferedReader bin = new BufferedReader(fin);
		        while((text = bin.readLine()) != null)
		        {
		        	if((text.trim()).equals(PIN))
		        	{
		        		viaPin = files[i].getName();
		        	}
		        }
		        bin.close();
			}
		}
		
		viaPin = viaPin.substring(0,6);
		
		return viaPin;
	}
	
	/*function to generate the route taken by the post. 
	 *It is made up of the source pincode + speed post center + destination pin code.*/
	public static String routeBarcodeGen(String destPin) throws IOException
	{
		String pathCode = "";
		String viaPin = "";
		
		viaPin = getPinSpeedCtr(destPin);
		
		pathCode = srcPin + viaPin + destPin;
		
		return pathCode;
	}
	
	/*function to generate a unique barcode based on the source pin code, the date and
	 *the daily serial of the post office.*/
	public static String barcodeGen(String Type) throws IOException
	{
		
		StringTokenizer data;
		String text = "";
		String val = "";
		String code = "";
		String dateVal = "";
		String serial = "";
		String charDate = "";
		int ctr = 0;
		int det = 0;
		int dat = 0;
		char ch1 = ' ';
		char ch2 = ' ';
		char ch3 = ' ';
		char dateAlph = ' ';
		
		FileReader fin = new FileReader("log.txt");
		BufferedReader bin = new BufferedReader(fin);
		
		while((text = bin.readLine()) != null)
		{
			det++;	
		    val = text;
		}
		bin.close();

		if(det != 0)//genertaing serial.
		{
			serial = val.substring(9,12);
		
			ch1 = serial.charAt(0);
			ch2 = serial.charAt(1);
			ch3 = serial.charAt(2);
		
			if(ch3 == 'Z')
			{
				if(ch2 == 'Z')
				{
					ch1 = (char)((int)ch1 + 1);
				}
				else
				{
					ch2 = (char)((int)ch2 + 1);
				}
			}
			else
			{
				ch3 = (char)((int)ch3 + 1);
			}
		
			serial = Character.toString(ch1) + Character.toString(ch2) + Character.toString(ch3);
		}
		
		data = new StringTokenizer(date, "-");
		
		for(ctr = 0;ctr < 3;ctr++)//genertaing date value
		{
			dateVal = data.nextToken();
			
			if(ctr == 2)
			{
				dateVal = dateVal.substring(2,4);
			}
			
			dat = Integer.parseInt(dateVal);
			
			if(dat > 26)//converting date value to an alphabetical character(Eg:26 = a).
			{
				dateAlph = (char)(dat + 70);
			}
			else
			{
				dateAlph = (char)(dat + 64);
			}
			charDate = charDate + dateAlph;
		}
		
		if(det == 0)
		{
			serial = "AAA";
		}
		//if the date is different with repect to the last date in the log then the serial is reset to AAA.
		else if(!charDate.equals(val.substring(6,9)))
		{
			serial = "AAA";
		}
		
		code = srcPin + charDate + serial + Type;
		
		return code;
	}
	
	/*function to calculate the rate for the post based on its weight and destination.*/
	public static double getNationalRate(String toState, int weight) throws IOException
	{
		String text = "";
		String distance = "";
		String und50 = ""; 
		String gm51to200 = ""; 
		String gm201to500 = ""; 
		String per500mo = "";
		double rate = 0;
		int ctr = 0;
		boolean flag = false;
		
		FileReader fin_1 = new FileReader("states_info.txt");
		BufferedReader bin_1 = new BufferedReader(fin_1);
	
		while((text = bin_1.readLine()) != null)
		{
			if((text.trim()).equalsIgnoreCase(toState))
			{
			    ctr = 0;
			    flag = true;
			}   
			
			ctr++;

			if(ctr == 4 && flag == true)
			{
				distance = text.trim();
				break;
			}
		}
		
		bin_1.close();
				
		FileReader fin_2 = new FileReader("india_tariff.txt");
		BufferedReader bin_2 = new BufferedReader(fin_2);
		
		text = "";
		ctr = 0;
		flag = false;
		
		while((text = bin_2.readLine()) != null)
		{
			if((text.trim()).equals(distance))
			{
				ctr = 0;
				flag = true;
			}
			
			ctr++;
			
			switch(ctr)
			{
				case 2: und50 = text.substring(9,11);//reading the rate from the file.
				break;
				
				case 3: gm51to200 = text.substring(9,11);
				break;
				
				case 4: gm201to500 = text.substring(9,11);
				break;
				
				case 5: per500mo = text.substring(9,11);
				break;
			}
			
			if(ctr == 5 && flag == true)
			break;
		}
		
		bin_2.close();
		
		if(weight <= 50)
		{
			rate = Double.parseDouble(und50);
		}
		else if(weight > 50 && weight <= 200)
		{
			rate = Double.parseDouble(gm51to200);
			rate = rate + (rate * serTax) + (rate * eduCes);
		}
		else if(weight > 200 && weight <= 500)
		{
			rate = Double.parseDouble(gm201to500);
			rate = rate + (rate * serTax) + (rate * eduCes);
		}
		else
		{
			rate = Double.parseDouble(gm201to500) + (((weight - 500) / 500d) * Double.parseDouble(per500mo));
			rate = rate + (rate * serTax) + (rate * eduCes);
		}
		
		return Math.rint(rate);
	}
	
	/*function to append the generated barcode to a national log in a sorted manner.*/
	public static void writeToCodeLog(String bCode) throws IOException
	{
		String text = "";
		
		linkedlist L = new linkedlist();
		
		FileReader fin = new FileReader("log.txt");
		BufferedReader bin = new BufferedReader(fin);
		
		while((text = bin.readLine()) != null)
		{
		     L.insert(text);
		}
		bin.close();
		
		L.insert(bCode);
		
		L.writeToFile();
	}
	
	/*function to write the details of the post to a date speed log.*/
	public static void writeToNationalDateSpeedLog(String bCode, String rCode, double rate) throws IOException
	{	
	    String filename = "";
	    
		filename = date + "NATL.txt";
		
		FileWriter fout = new FileWriter(filename, true);
		BufferedWriter bout = new BufferedWriter(fout);
		PrintWriter out = new PrintWriter(bout);
		
		out.println(bCode);
		out.println(rCode);
		out.println("Rs." + rate + "/-");
		out.println(weight + "gm");
		out.println(contentType);
		out.println(time);
		out.println();
		out.println("* * * * *");
		
		out.close();
	}
	
	/*function to display the speed post summary.*/
	public static void display(String rCode, String State, String Pin, String bCode, double Rate) throws IOException
	{
		int det = 0;
		
		System.out.println();
		System.out.println("-----Speed Post Confirmation-----");
		System.out.println();
		System.out.println(bCode);
		System.out.println();
		System.out.println(rCode);
		System.out.println(date);
		System.out.println(time);
		System.out.println();
		System.out.println("Rs." + Rate + "/-");
		System.out.println(contentType);
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
		if(State.length() != 0)
		{
			System.out.println(State);
		}
		
		System.out.println(Pin);
		System.out.println();
		System.out.println("-------THANK YOU-------");
		
		do
		{
			System.out.println();
			System.out.println("If you have entered any of the requested information incorrectly and wish to re-enter the same: Key in '1'.");
		    System.out.println("If you have entered the requested information correctly and wish to exit the system: Key in '2'.");
		    
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
		    	sendNationalSpeed();//restarting the process.
		    }
		    else if(det == 2)
		    {
		    	//if authenticity of data is confirmed it is written to the logs.
		    	writeToNationalDateSpeedLog(bCode, rCode, Rate);
		    	writeToCodeLog(bCode);
		    	System.out.println();
		    	menu.exitMenu("indiaSpeed");
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
