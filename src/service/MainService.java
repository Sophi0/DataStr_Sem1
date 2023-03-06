package service;

import java.util.Arrays;

import datastr.MyArrayList;
import datastr.SortingType;

public class MainService {

	public static void main(String[] args) {
		MyArrayList charList = new MyArrayList();
		try {
		charList.add('a');	//a
		charList.add('g');	//a g
		charList.add('b');	//a g b
		charList.add('z', 0);	// z a g b
		
		charList.print(); //z a g b
		
		System.out.println(charList.howManyElements());	//4
		
		charList.remove(1);	//z g b
		charList.print(); //z g b
		
		System.out.println(charList.retrieve(1)); //g
		
		System.out.println("Search: " + charList.search('a')); //true
		
		charList.add('d');	//z g b d
		charList.add('z');	//z g b d z
		charList.add('a');	//z g b d z a
		charList.add('z');	//z g b d z a z increase() will be called
		
		System.out.println(Arrays.toString(charList.retrieveNextNeighbour('z')));	//g a
		
		System.out.println(charList.sort(SortingType.ASC)); //a b d g z z z
		
		charList.print();//z g b d z a z
		charList.makeEmpty();	//empty array
		//charList.print();	//empty array
		charList.add('d'); 	//d
		charList.print(); //d
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
