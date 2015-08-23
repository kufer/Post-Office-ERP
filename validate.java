package PostOffice;
import java.io.*;
import java.util.*;
import PostOffice.*;
public class validate
{
	public static int validIndianPin(String PIN) throws IOException
	{
		int err = 0;
		int Pin = 0;
		int ctr = 0;
		int i = 0;
		int numOfTokens = 0;
		boolean valid = false;
		boolean flag = false;
		String postCirc = "";
		String text = "";
		String state = "";
		
		if(PIN.length() != 6)
		{
			return err = 1;
		}
		
		try
		{
			Pin = Integer.parseInt(PIN);
		}
		catch(NumberFormatException e)
		{
			return err = 2;
		}
		
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
						flag = true;
						break outer;
					}
				}
			}
		}
		bin_1.close();
		
		if(flag == false)
		{
			return err = 3;
		}
		
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
		
		text = "";
	
		try
		{
			File f = new File(new File(".").getCanonicalPath() + "\\States_PIN\\" + state + "\\" + postCirc);
			File files[] = f.listFiles();

			for(i = 0;i < files.length;i++)
			{
				if(files[i].isFile())
				{
					FileReader fin_2 = new FileReader(files[i]);
		        	BufferedReader bin_2 = new BufferedReader(fin_2);
		        	while((text = bin_2.readLine()) != null)
		        	{
		        		if((text.trim()).equals(PIN))
		        		{
		        			valid = true;
		        			break;
		        		}
		      		}
		        	bin_2.close();
				}
			}
		}
		catch(NullPointerException e)
		{
			valid = false;
		}
		catch(FileNotFoundException e)
		{
			valid = false;
		}
		
		
		if(valid == false)
		{
			return err = 3;
		}
		
		return err;
	}
	
	public static boolean validLocation(String Loc)
	{
		boolean valid = true;
		int ctr = 0;
		char ch = ' ';
		
		Loc = Loc.toLowerCase();
		
		for(ctr = 0;ctr < Loc.length();ctr++)
		{
			ch = Loc.charAt(ctr);
			if((int)ch < 97 || (int)ch > 122)
			{
				valid = false;
			}
		}
		return valid;
	}
	
	public static boolean validNum(String Num)
	{
		boolean valid = true;
		
		try
		{
			double num = Double.parseDouble(Num);
		}
		catch(NumberFormatException e)
		{
			return valid = false;
		}
		
		return valid;
	}
	
	public static boolean validInternationalPostCode(String Country, String ZIP) throws IOException
	{
		String text = "";
		boolean valid = false;
		int i = 0;
		
		File f = new File(new File(".").getCanonicalPath() + "\\Countries_PIN");
		File files[] = f.listFiles();

		for(i = 0;i < files.length;i++)
		{
			if(files[i].isFile())
			{
				if((files[i].getName()).equals(Country))
				{
					FileReader fin = new FileReader(files[i]);
		            BufferedReader bin = new BufferedReader(fin);
		            while((text = bin.readLine()) != null)
		            {
		        	   if((text.trim()).equals(ZIP))
		        	   {
		        		   valid = true;
		        		   break;
		        	   }
		            }
		            bin.close();
				}
			}
		}
		
		return valid;
	}
	
	public static int validTeleNumber(String Num)
	{
		int err = 0;
		int val = 0;
		int len = 0;
		int ctr = 0;
		char ch = ' ';
		
		Num = Num.trim();
		
		len = Num.length();
		
		if(len != 10 && len != 8 && len != 11)
		{
			return err = 1;
		}	
		
		for(ctr = 0;ctr < len;ctr++)
		{
			ch = Num.charAt(ctr);
			val = (int)ch;
			if(val < 48 || val > 57)
			{
				return err = 2;
			}
		}
		return err;
	}
	
	public static int validBarcode(String Code) throws IOException
	{
		String num = "";
		String alph = "";
		String text = "";
	    boolean flag = false;
		int err = 0;
		
		if(Code.length() != 13)
		{
			return err = 1;
		}
		
		num = Code.substring(0,6);
		alph = Code.substring(6,13);
		
		if(!validNum(num))
		{
			return err = 2;
		}
		
		if(!validLocation(alph))
		{
			return err = 3;
		}
		
		FileReader fin = new FileReader("log.txt");
		BufferedReader bin = new BufferedReader(fin);
		
		while((text = bin.readLine()) != null)
		{
			if((text.trim()).equals(Code))
			{
				flag = true;
			}
		}
		bin.close();
		
		if(flag == false)
		{
			return err = 4;
		}
		
		return err;
	}
}
