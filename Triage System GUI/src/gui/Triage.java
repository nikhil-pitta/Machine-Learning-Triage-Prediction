package gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Triage {
	
	public ArrayList[] triage;
	
	private Reader reader;
	
	public Triage() throws IOException
	{
		triage = new ArrayList[5];
		
		for(int i=0; i<5; i++){
			 triage[i] = new ArrayList<>();
		}
		
		reader = new Reader();

	}
	
	public void createTriage() throws IOException
	{
		Person p = reader.createPerson();
		int index = (int)p.triageNum;
		index--;
		
		triage[index].add(p.name);
		
		Collections.sort(triage[index]);
		
		System.out.println(Arrays.deepToString(triage));
		
	}

}
