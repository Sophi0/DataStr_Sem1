package service;

import java.io.File;	//lai importet sho, vajag uzrakstit keyword 'File' un uzpiest ctrl+space+enter
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import datastr.MyArrayList;
import datastr.SortingType;
import model.Faculty;
import model.Student;

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
		
		System.out.println(Arrays.toString(charList.retrieveNextNeighbour('g')));	//g a
		
		System.out.println(Arrays.toString(charList.sort(SortingType.ASC))); //a b d g z z z
		
		charList.print();//z g b d z a z
		charList.makeEmpty();	//empty array
		//charList.print();	//empty array
		charList.add('d'); 	//d
		charList.print(); //d
		
		
		System.out.println("----------------");
		//read from file
		MyArrayList fileList = getArrayElementsFromFile("resources/numbers (1).txt");
		
		fileList.print();
		fileList.add('z');
		fileList.remove(2);
		fileList.print();
		System.out.println(Arrays.toString(fileList.sort(SortingType.ASC)));
		
		MyArrayList<String> stringList = new MyArrayList<>();
		stringList.add("Sofja");
		stringList.add("Janis");
		stringList.add("Zanis", 0);
		stringList.print();	//Sofja Janis Zanis
		System.out.println(Arrays.toString(stringList.sort(SortingType.DESC)));
		stringList.remove(1);
		stringList.print(); //Sofja Zanis
		
		MyArrayList<Student> studentList = new MyArrayList<>();
		studentList.add(new Student("Janis", "Berzins", Faculty.EPF, "123456-12345"));
		studentList.add(new Student("Jana", "Berza", Faculty.ITF, "123436-18345"));
		studentList.add(new Student("Karlis", "Ivanovs", Faculty.TSF, "193456-22345"));
		studentList.print();
		studentList.add(new Student("Gatis", "Berins", Faculty.ITF, "166456-43215"));
		studentList.print();
		studentList.remove(1);
		studentList.print();
		System.out.println(Arrays.toString(studentList.sort(SortingType.DESC)));
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MyArrayList getArrayElementsFromFile(String path) throws FileNotFoundException{
		File myFile = new File(path); 
		FileInputStream myInputStream = new FileInputStream(myFile);
		
		Scanner myScanner = new Scanner(myInputStream);
		MyArrayList listFromFile = new MyArrayList();
		
		while(myScanner.hasNextLine()) {
			String line = myScanner.nextLine();
			char element = line.charAt(0);
			listFromFile.add(element);
		}
		myScanner.close();
		return listFromFile;
	}

}
