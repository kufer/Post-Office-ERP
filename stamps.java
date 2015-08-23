package PostOffice;
import java.io.*;
import java.util.*;
import PostOffice.*;
public class stamps
{
	static protected String Re1 = "";
	static protected String Rs2 = "";
	static protected String Rs5 = "";
	static protected String Rs10 = "";
	static protected String Rs15 = "";
	
	static BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
	
	protected stamps()
	{
		Re1 = "0";
		Rs2 = "0";
		Rs5 = "0";
		Rs10 = "0";
		Rs15 = "0";
	}
	
	public static void buyStamps(int amt) throws IOException
	{ 	
		if(amt == 1)
		{
			Re1 = "1";
		}    
		else if(amt == 2)
		{
			Rs2 ="1";
		}
		else if(amt == 5)
		{
			Rs5 = "1";;
		}
		else if(amt == 10)
		{
			Rs10 = "1";;
		}
		else if(amt == 15)
		{
			Rs15 = "1";
		}
		
		else if(amt > 2 && amt < 5)
		{
			if(amt%2 == 0)
		    {
		        Rs2 = "2";
		    }
		    else
		    {
			    Re1 = "1";
			    Rs2 = "1";
		    }
		}
		
		else if(amt > 5 && amt < 10)
		{
			Rs5 = "1";
			amt = amt - 5;
			buyStamps(amt);
		}
		
		else if(amt > 10 && amt < 15)
		{
			Rs10 = "1";
			amt = amt - 10;
			buyStamps(amt); 
		}
		
		else if(amt > 10 && amt < 15)
		{
			Rs10 = "1";
			amt = amt - 10;
			buyStamps(amt); 
		}
		
		else if(amt > 15)
		{
			Rs15 = Integer.toString(amt / 15);
			amt = amt - (15 * Integer.parseInt(Rs15));
			buyStamps(amt); 
		}
	}
	public static void enterInStampsLog(stamps Obj) throws IOException
	{
		int Re1Stamps = 0;
		int Rs2Stamps = 0;
		int Rs5Stamps = 0;
		int Rs10Stamps = 0;
		int Rs15Stamps = 0;
		int ctr = 0;
		final String end = "* * * * *";
		String text = "";
		
		FileReader fin = new FileReader("stamps_reserve.txt");
		BufferedReader bin = new BufferedReader(fin);
		
		FileWriter fout = new FileWriter("temp.txt");
		BufferedWriter bout = new BufferedWriter(fout);
		PrintWriter out = new PrintWriter(bout);
		
		while((text = bin.readLine()) != null)
		{
			ctr++;
			
			if(ctr == 2)
			{
				Re1Stamps = Integer.parseInt(text);
				
				if(Re1Stamps < 100)
				{
					System.out.println();
					System.out.println("The number of Re.1 stamps is less than 100:" + Re1Stamps);
					System.out.println("Please update.");
					System.out.println();
				}
				
				Re1Stamps = Re1Stamps - Integer.parseInt(Obj.Re1);
				out.println(Re1Stamps);
			}
			else if(ctr == 5)
			{
				Rs2Stamps = Integer.parseInt(text);
				
				if(Rs2Stamps < 100)
				{
					System.out.println();
					System.out.println("The number of Rs.2 stamps is less than 100:" + Rs2Stamps);
					System.out.println("Please update.");
					System.out.println();
				}
				
				Rs2Stamps = Rs2Stamps - Integer.parseInt(Obj.Rs2);
				out.println(Rs2Stamps);
			}
			else if(ctr == 8)
			{
				Rs5Stamps = Integer.parseInt(text);
				
				
				if(Rs5Stamps < 100)
				{
					System.out.println();
					System.out.println("The number of Rs.5 stamps is less than 100:" + Rs5Stamps);
					System.out.println("Please update.");
					System.out.println();
				}
				
				Rs5Stamps = Rs5Stamps - Integer.parseInt(Obj.Rs5);
				out.println(Rs5Stamps);
			}
			else if(ctr == 11)
			{
				Rs10Stamps = Integer.parseInt(text);
				
				
				if(Rs10Stamps < 100)
				{
					System.out.println();
					System.out.println("The number of Rs.10 stamps is less than 100:" + Rs10Stamps);
					System.out.println("Please update.");
					System.out.println();
				}
				
				Rs10Stamps = Rs10Stamps - Integer.parseInt(Obj.Rs10);
				out.println(Rs10Stamps);
			}
			else if(ctr == 14)
			{
				Rs15Stamps = Integer.parseInt(text);
				
				
				if(Rs15Stamps < 100)
				{
					System.out.println();
					System.out.println("The number of Rs.15 stamps is less than 100:" + Rs15Stamps);
					System.out.println("Please update.");
					System.out.println();
				}
				
				Rs15Stamps = Rs15Stamps - Integer.parseInt(Obj.Rs15);
				out.println(Rs15Stamps);
			}
			else if(ctr != 2 || ctr != 5 || ctr != 8 || ctr != 11 || ctr != 14)
			{
				out.println(text);
			}
		}
		
		bin.close();
		out.close();
		
		new File("stamps_reserve.txt").delete();
		renameFile("stamps_reserve.txt", "temp.txt");
		new File("temp.txt").delete();

	}
	
	public static void renameFile(String toFilename, String currFilename) throws IOException
	{
		String text;
		
		FileReader fin = new FileReader(currFilename);
		BufferedReader bin = new BufferedReader(fin);
		
		FileWriter fout = new FileWriter(toFilename);
		BufferedWriter bout = new BufferedWriter(fout);
		PrintWriter out = new PrintWriter(bout);
		
		while((text = bin.readLine()) != null)
		{
			out.println(text);
		}
		out.close();
		bin.close();
		
	}
	    	
	
	public static void start() throws IOException
	{
		int det = 0;
		int qnty = 0;
		String den = "";
		String cho = "";
		boolean flag = true;
		boolean valid = false;
		
		do
		{
			System.out.println("Enter your choice:");
			System.out.println("1 -- to buy stamps.");
			
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
			
			if(det != 1)
			{
				 System.out.println("You entered an invalid choice!");
	        	 System.out.println("Please re-enter your option correctly.");
	        	 System.out.println();
			}
		}
		while(det != 1);
	    
	    
	    if(det == 1)
	    {
	    	stamps obj = new stamps();
		
			System.out.println("Enter the amount for which you want stamps.");
			System.out.println("Enter only numeric characters, no special characters are allowed!");
			buyStamps(Integer.parseInt(keyin.readLine()));
			enterInStampsLog(obj);
		
			System.out.println("Re.1 Stamps - " + obj.Re1);
			System.out.println("Rs.2 Stamps - " + obj.Rs2);
			System.out.println("Rs.5 Stamps - " + obj.Rs5);
        	System.out.println("Rs.10 Stamps - " + obj.Rs10);
        	System.out.println("Rs.15 Stamps - " + obj.Rs15);
        	System.out.println();
        	menu.exitMenu("stamps");
        }
	   
    }
    
}
	



 
		
		

