package PostOffice;
import java.io.*;
public class stack 
{
	static String sender[] = new String[7];
	static String reciever[] = new String[7];
	static int pointer1 = -1;
	static int pointer2 = -1;
	static String data;
		
	public static void push(String Data, int chk)
	{
		if(chk == 1)
		{
			pointer1++;
			if(pointer1 < 7)
			{	
		   		sender[pointer1] = Data;
			}
		}
		else
		{
			pointer2++;
			if(pointer2 < 7)
			{
		   		reciever[pointer2] = Data;
			}
		}
	}
	
	public static String pop(int chk)
	{
		if(chk == 1)
		{
			data = sender[pointer1];
			sender[pointer1] = null;
			pointer1--;
		}
		else
		{
			data = reciever[pointer2];
			reciever[pointer2] = null;
			pointer2--;
		}
		
		return data;   
	}
}
