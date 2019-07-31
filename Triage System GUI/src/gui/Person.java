package gui;

public class Person implements Comparable<Person>{
	
	public String name;
	public int triageNum;
	
	public Person(String name, int triageNum)
	{
		this.name = name;
		this.triageNum = triageNum;
	}

	public int compareTo(Person o) {
		return this.triageNum - triageNum;
	}
	
	public String toString()
	{
		return "Triage Num: " + triageNum + ", Name: " + name;
	}

}
