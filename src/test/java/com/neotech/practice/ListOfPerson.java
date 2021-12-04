package com.neotech.practice;

import java.util.ArrayList;
import java.util.List;

public class ListOfPerson {

	public static void main(String[] args) {


		Person p1 = new Person("John", 30);
//		Person p2 = new Person(null, 0)
		
		List<Person> listOfPeople  = new ArrayList<>();
		
		listOfPeople.add(p1);
		listOfPeople.add(new Person("Brad", 40));
		listOfPeople.add(new Person("Mary", 25));
		
		System.out.println(listOfPeople.toString());
		
		for (Person element : listOfPeople)
		{
			System.out.println(element);
		}

	}

}


class Person{
	String name;
	int age;
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String toString()
	{
		return name + " -> " + age;
	}
}