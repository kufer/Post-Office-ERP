package PostOffice;
import java.io.*;
class node
{
	protected node link;
	protected String data;
	
	public node(String a, node b)
	{
		data = a;
		link = b;
	}
	
	public void setdata(String x)
	{
		data = x;
	}
	public void setlink(node z)
	{
		link = z;
	}
	public String getdata()
	{
		return data;
	}
	public node getlink()
	{
		return link;
	}
}
class linkedlist 
{
	protected node start;
	protected static linkedlist Link;
	
	void linkedlist()
	{
		start = null;
	}
	
	public boolean isEmpty()
	{
		return(start == null);
	}
	
	public void insert(String code)
	{
		node nptr, ptr, save = null;
		nptr = new node(code, null);
		boolean flag = false;

		if(isEmpty())
		start = nptr;
		else if(code.compareTo(start.getdata()) < 1)
		{
			nptr.setlink(start);
			start = nptr;
		}
		else
		{
			save = start;
			ptr = start.getlink();
			while(ptr != null)
			{
				if((nptr.getdata().compareTo(save.getdata())) > 1 && (nptr.getdata().compareTo(ptr.getdata())) < 1)
				{
					save.setlink(nptr);
					nptr.setlink(ptr);
					flag = true;
					break;
				}
				else
				{
					save = ptr;
					ptr = ptr.getlink();
				}
			}
			if(flag == false)
		    save.setlink(nptr);
		}
		
	}
	
	public void writeToFile() throws IOException
	{
		String code = "";
		node ptr;
		
		FileWriter fout = new FileWriter("log.txt");
		BufferedWriter bout = new BufferedWriter(fout);
		PrintWriter out = new PrintWriter(bout);
		
		if(!isEmpty())
		{
			out.println(start.getdata());
			ptr = start.getlink();
			
			while(ptr != null)
			{
				out.println(ptr.getdata());
				ptr = ptr.getlink();
			}
		}
		
		out.close();
	}
}
