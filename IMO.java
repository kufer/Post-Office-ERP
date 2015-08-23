package PostOffice;
import java.io.*;
import java.util.*;
import PostOffice.*;
public class IMO
{
	final static protected String srcPin = "560025";
	final static protected String type = "M";
	final static protected double serTax = 0.10;
    final static protected double eduCes = 0.02;
    
    //these variables are not manipulated in any of the foll functions once they are assigned their values
    static protected String name = "";
    static protected String addLine1 = "";
    static protected String addLine2 = "";
    static protected String addLine3 = "";
    static protected String city = "";
    static protected String state = "";
    static protected String pin = "";
    static protected int amt = 0;
    
    static Calendar cal = Calendar.getInstance();
    
    static protected String date = cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
	static protected String time = cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
    
    
    static BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
    
    /* A function to iniate the process of sending an IMO. It calls function getInfo(),
     * and implements stacks for storing the informetion of sender and reciever.*/
     
    public static void sendIMO() throws IOException
    {
  		for(int i = 0;i < 4;i++)
  		{
    		System.out.println();
    	}
    	
	    System.out.println("\t\t Indian Money Order");
	    System.out.println();
    	boolean flag = true;
    	String barcode = "";
    	
    	System.out.println("Please enter the sender's details:");
    	
    	getInfo();
    	
    	stack.push(pin, 1);
    	stack.push(state, 1);
    	stack.push(city, 1);
    	stack.push(addLine3, 1);
    	stack.push(addLine2, 1);
    	stack.push(addLine1, 1);
    	stack.push(name, 1);
    	
    	do 
    	
        {
        	flag = true;
        	
        	System.out.println();
       		System.out.println("Please enter the amount you wish to send:");
       		System.out.println("Enter only numeric characters, no special characters are allowed!");
       		System.out.println("Maximum - Rs.10000/-.");
       		System.out.println("Minimum - Rs.1000/-.");
       		System.out.println();
            
            try
            {
         		amt = Integer.parseInt(keyin.readLine());
            }
         	catch(NumberFormatException e)
          	{
          		System.out.println("You entered non numeric characters!");
          		System.out.println("Please re-enter correctly.");
          		flag = false;
          		continue;
          	}
          	
            if(amt > 10000 ||  amt < 1000)
            { 
                System.out.println("The entered amount is out of bounds!");
                System.out.println("Please re-enter correctly.");
                flag = false;
            }
      	} 
      	while(flag == false);
      	
      	System.out.println();
      	System.out.println("Please enter the reciever's details:");
      	
      	getInfo();
      	
      	stack.push(pin, 2);
    	stack.push(state, 2);
    	stack.push(city, 2);
    	stack.push(addLine3, 2);
    	stack.push(addLine2, 2);
    	stack.push(addLine1, 2);
    	stack.push(name, 2);
    	
    	barcode = indiaSpeed.barcodeGen(type);
    	
    	display(barcode);
           
    }
    
    /* This function is used to get the name, address details and pin code of the
     * sender and reciever.*/
    
    public static void getInfo() throws IOException
    {
    	 //these variables are not class variables as they are to be manipulated in the foll functions
	     String text = "";
	     String det = "";
	     int stateOpt = 0;
	     int choice = 0;
	     int ctr = 0;
	     int i = 0;
	     boolean flag = true;
	     boolean check = true;
	     
	     do
	     {
	     	System.out.println("Name: ");
		 	name = keyin.readLine();
	        
	        if(name.length() == 0)
	        {
	        	System.out.println("This is a mandatory field!");
	        }
	        System.out.println();
	     }
	     while(name.length() == 0);   
	     
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
	     	 flag = true;
	     	
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
    }
    
    /*This is a function to calculate the remittance to be paid.*/
    public static String calcRate() throws IOException
    {
    	String data = "";
    	String rate = "";
		int ctr = 0; 
		boolean flag = false;
   		
   		FileReader fin = new FileReader("imo_tariff.txt");
		BufferedReader bin = new BufferedReader(fin);

		while((data = bin.readLine())!=null)
		{
			if(amt < 1000)
			{
				if((data.trim()).equals("<1000"))
				{
					ctr = 0;
					flag = true;
				}
    		}
			
			else if(amt >= 1000 && amt <= 5000)
			{
				if((data.trim()).equals("<5000"))
				{
					ctr = 0;
					flag =true;
				}
			}
			
			else if(amt > 5000 && amt <= 10000)
			{
				if((data.trim()).equals("<10000"))
				{
					ctr = 0;
					flag = true;
				}
    		}
			
 			if(ctr == 1 && flag == true)
			{
			 	rate = data;
			 	break;
			}
			
			ctr++;
		} 
		bin.close();

		return rate;
	}
	
	/*This is a function to write the details of the sent IMO to a data file.*/
	public static void writeToIMODateLog(String bCode, String Rate, String PIN) throws IOException
	{	
	    String filename = "";
	    
		filename = date + "IMON.txt";
		
		FileWriter fout = new FileWriter(filename, true);
		BufferedWriter bout = new BufferedWriter(fout);
		PrintWriter out = new PrintWriter(bout);
		
		out.println(bCode);
		out.println("Rs." + Rate + "/-");
		out.println("---------");
		out.println(PIN);
		out.println("Rs." + amt + "/-");
		out.println(time);
		out.println();
		out.println("* * * * *");
		
		out.close();
	}
	
	public static void display(String bCode) throws IOException   
	{   
		String name = "";
		String addline2 = "";
		String addline3 = "";
		String city = "";
		String state = "";
		String rate = "";
		String pin = "";
		int det = 0; 
		
		rate = calcRate();                                               
    
		System.out.println();
		System.out.println("-------------IMO Confirmation------------");
		System.out.println();
		System.out.println(bCode);
		System.out.println();
		System.out.println("Sender Details:");
		
		if((name = stack.pop(1)).length() != 0)
		{
			System.out.println(name);
		}
		
		System.out.println();
		System.out.println(stack.pop(1));
		
		if((addline2 = stack.pop(1)).length() != 0)
		{
			System.out.println(addline2);
		}
		if((addLine3 = stack.pop(1)).length() != 0)
		{
			System.out.println(addLine3);
		}
	    if((city = stack.pop(1)).length() != 0)
		{
			System.out.println(city);
		}
		if((state = stack.pop(1)).length() != 0)
		{
			System.out.println(state);
		}

		System.out.println(stack.pop(1));
		System.out.println();
		
		name = "";
		addline2 = "";
		addline3 = "";
		city = "";
		state = "";

		System.out.println("Reciever Details:");
		
		if((name = stack.pop(2)).length() != 0)
		{
			System.out.println(name);
		}
		
		System.out.println();
		System.out.println(stack.pop(2));
		
		if((addline2 = stack.pop(2)).length() != 0)
		{
			System.out.println(addline2);
		}
		if((addLine3 = stack.pop(2)).length() != 0)
		{
			System.out.println(addLine3);
		}
	    if((city = stack.pop(2)).length() != 0)
		{
			System.out.println(city);
		}
		if((state = stack.pop(2)).length() != 0)
		{
			System.out.println(state);
		}
		
		pin = stack.pop(2);
		
		System.out.println(pin);
		System.out.println();
		System.out.println();
		System.out.println("Amount to be sent: Rs." + amt + "/-");
		System.out.println();
		System.out.println("Remittance: Rs." + rate + "/-");
		System.out.println();
		
		System.out.println();
		System.out.println(date);
		System.out.println(time);
		System.out.println();
		
		System.out.println("-----------THANK YOU----------");
		
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
		    	sendIMO();
		    }
		    else if(det == 2)
		    {
		    	writeToIMODateLog(bCode, rate, pin);
		    	indiaSpeed.writeToCodeLog(bCode);
		    	System.out.println();
		    	menu.exitMenu("IMO");
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
