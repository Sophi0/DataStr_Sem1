package datastr;

public class MyArrayList {
	private char[] elements;
	private final int DEFAULT_ARRAY_SIZE = 6;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;
	
	/*Izveidot konstruktoru, kas inicializē masīvu elementu glabāšanai un skaitītāju, 
	kas glabā informāciju par pievienoto elementu skaitu.
	Kā konstruktora parametrs tiek padots saraksta lielums.
	*/
	
	//no args(arguments) constructor
	public MyArrayList() {
		elements = new char[arraySize];	//izveidosim masivu, kur ir simboli, masivs ar 6 shunam (DEFAULT_ARRAY_SIZE)
	}
	
	//args constructor
	public MyArrayList(int inputArraySize) {
		if(inputArraySize > 0) {
			arraySize = inputArraySize;
	}
		
		elements = new char[arraySize];
}
	
	/*Izveidot funkciju, kas pārbauda, vai masīvs nav jau pilns;
	 *Izveidot funkciju, kas pārbauda, vai masīvs ir tukšs;
	 */
	
	//TODO create ifFull and isEmpty functions
	public boolean isEmpty() {		//tur vērtība nevajag
		//LONG IF-ELSE
		
		/*if (elementCounter == 0) {
			return true;
		}
		else {
			return false;
		}
		
		return(arraySize > elementCounter) ? "var ievietot" : "nevar ievietot";
		if(arraySize < elementCounter){
			return "var ievietot"	;
			}
			else{
			"nevar ievietot";
			}
		*/
		
		//SHORT IF-ELSE
		
		//kopejais	(if izteiksme)		  ?ko darit true	:ko darit false
		//return 	(elementCounter == 0) ? true			:false;
		
		return (elementCounter == 0);
	}
	
	public boolean isFull() {
		/*
		if (elementCounter == arraySize) {
			return true;
		}
		else {
			return false;
		}
	*/
		//SHORT CODE
		return (elementCounter == arraySize);
}
	
	/*
	 * Izveidot funkciju, kas atgriež, cik elementu ir ievietoti sarakstā;
	 */
	
	public int howManyElements() {
		return elementCounter;
	}
	
	//TODO
	//1.create a definition of function increaseArray
	//2.calculate the new size of the new array
	//3.create new array
	//4.copy all elements from old array to the new array
	//5.change reference to the new array
	
}
