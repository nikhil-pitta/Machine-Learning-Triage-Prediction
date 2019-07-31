package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Writer 
{
	private PrintWriter pr;
	
	public Writer() throws IOException
	{
		pr = new PrintWriter(new BufferedWriter(new FileWriter("/Users/nikhil/Desktop/Synopsys Project/Person.txt")));

	}
	
	public void write(String name, String sp, String temp, String heart, String resp, String bp, String symptoms) throws IOException
	{
		pr.println(name);
		pr.println(sp);
		pr.println(temp);
		pr.println(heart);
		pr.println(resp);
		pr.println(bp);
		pr.println(symptoms);
		pr.close();
	}

}
