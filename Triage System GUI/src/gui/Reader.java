package gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Reader
{
	private BufferedReader br;
	private StringTokenizer st;

	public Person createPerson() throws IOException
	{
		br = new BufferedReader(new FileReader("/Users/nikhil/Desktop/Synopsys Project/Person.txt"));

		st = new StringTokenizer(br.readLine());
		String name = st.nextToken();
		
		for(int i=0; i<6; i++) st = new StringTokenizer(br.readLine());
		
		int triage = Integer.parseInt(st.nextToken());
		Person p = new Person(name, triage);
		
		return p;
		
	}
	
}
