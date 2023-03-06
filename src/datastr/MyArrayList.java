package datastr;

public class MyArrayList<T> {	//<T> - template
	private T[] elements;
	private final int DEFAULT_ARRAY_SIZE = 6;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;
	
	/*Izveidot konstruktoru, kas inicializē masīvu elementu glabāšanai un skaitītāju, 
	kas glabā informāciju par pievienoto elementu skaitu.
	Kā konstruktora parametrs tiek padots saraksta lielums.
	*/
	
	//no args(arguments) constructor
	public MyArrayList() {
		elements = (T[]) new Object[arraySize];	//izveidosim masivu, kur ir simboli, masivs ar 6 shunam (DEFAULT_ARRAY_SIZE)
	}
	
	//args constructor
	public MyArrayList(int inputArraySize) {
		if(inputArraySize > 0) {
			arraySize = inputArraySize;
	}
		
		elements = (T[]) new Object[arraySize];
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
	
	/*
	 * Izveidot funkciju, kura izveido jaunu masīvu ar izmēru 2 reizes lielāku kā esošā 
	 * masīva izmēru, pie nosacījuma - ja elementu skaits nav lielāks par 100, 
	 * pretēja gadījumā izmēru palielina 1.5 reizes. Neaizmirstam pārkopēt visus 
	 * elementus jaunizveidotajā masīvā.
	 */
	//TODO
	//1.create a definition of function increaseArray
		private void increaseArray() {
			
	//2.calculate the new size of the new array
			int newArraySize = (arraySize > 100) ? (int)(arraySize * 1.5) : arraySize * 2;
			
			/*int newArraySize = arraySize * 2;
			if(arraySize > 100) {
				newArraySize = (int)(arraySize * 1.5);
			}
			*/
	//3.create new array
			T[] newElements = (T[])new Object[newArraySize];
	//4.copy all elements from old array to the new array
			for(int i = 0; i < elementCounter; i++) {
				newElements[i] = elements[i];
			}
	//5.change reference to the new array and it's size
			elements = newElements;
			arraySize = newArraySize;
		}
		
		
	/*
	 * Izveidot funkciju, kas veic elementu pievienošanu pēdējam saraksta 
	 * elementam (veikt nepieciešamās pārbaudes).
	 */
		
	//1.create a definition of function add
		public void add(T newElement) {
	//2.verify if the array is full
			if(isFull()) {	//nevajag neko iekavas rakstit, jo pata funkcija ir boolean tipa
	//2.1.call an increaseArray() function
				increaseArray();
			}
			
	//3.add the new element in the array	
	//the optimize option
	elements[elementCounter++] = newElement;
		
	/*the non-optimize option
	 *elements[elementCounter] = newElement;
	 *elementCounter++;
	*/
			
	//4.increase elementCounter
		}
		
	//TODO
	//1.create a definition of function add
		public void add(T newElement, int index) throws Exception {
	//2.verify the index - is it appropriate
			if(index >= 0 && index <= elementCounter) {
				
	//3.verify if the index is equal with elementCounter
				if(index == elementCounter) {
					add(newElement);
				}
				else {
	//3.1.verify isFull					
					if(isFull()) {
						increaseArray();
					}
				}
		
	//4.copy from the end to the right side(using index) ->for cikls
				for(int i = elementCounter; i > index; i--) {
					elements[i] = elements[i - 1];
				}
	//5.add the new element in the specified index
				elements[index] = newElement;
	//6.increase elementCounter			
				elementCounter++;
			}
		//iznemums
			else {
				throw (new Exception("Wrong index"));
			}
		
		}
		
	/*
	 * Izveidot funkciju, kas veic elementu dzēšanu pēc indeksa 
	 * (veikt nepieciešamās pārbaudes).
	 */
		
	
	//TODO
	//1.create a definition of function remove
		public void remove(int index) throws Exception{
	//2.verify isEmpty
			if(isEmpty()) {
				throw (new Exception("Array is empty ad it is not possible to remove elements"));
				}
			else {
	//3.verify the index - is it appropriate
			if(index < 0 || index >= elementCounter) {
				throw (new Exception("Wrong index"));
			}
			else {
	//4.copy elements from index to end
				for(int i = index; i < elementCounter - 1; i++) {
					elements[i] = elements[i + 1];	//pa labi
				}
	//5.initialize the last element to NULL reference			
				elements[elementCounter - 1] = null; //NUL symbol
	//6.decrease element
				elementCounter--;
	//for optimization
	//elements[--elementCounter] = 0;			
			}
		}
	}
	
	/*
	 * Izveidot funkciju, kas veic elementa izgūšanu pēc indeksa 
	 * (veikt nepieciešamās pārbaudes).
	 */
		
	//TODO create "retrieve" function
		public T retrieve(int index) throws Exception{
			if(isEmpty()) {
			throw (new Exception("Array is empty ad it is not possible to retieve elements"));
			}
			else {
				if(index < 0 || index >= elementCounter) {
					throw (new Exception("Wrong index"));
				}
				else {
					return elements[index];
				}
			}
		}
		
	/*
	 * Izveidot funkciju, kas veic elementa meklēšanu;
	 */
		
		public boolean search(T inputElement) {
			for(int i = 0; i < elementCounter; i++) {
				if(elements[i].equals(inputElement)) {	
					return true;
				}
			}
			return false;	//pec for cikla return false bus, kas vins parbaudis
		}
		
	//TODO retrieveNextNeighbour
		/*
		 * Izveidot funkciju, kas kā argumentu saņem elementu un atgriež nākamo elementu (veikt nepieciešamās pārbaudes).
		 */
		public T[] retrieveNextNeighbour(T inputElement) throws Exception {
			//vispirms apskatisim vai vispar ir tas elements
			if(search(inputElement)) {
				int howManySearchedElements = 0;
			
				for(int i = 0; i < elementCounter; i++) {
					if(elements[i] == inputElement) {
						howManySearchedElements++;
				}
			}
				if(elements[elementCounter - 1].equals(inputElement)) {
					howManySearchedElements--;
				}
				
				T[] nextNeighbour = (T[])new Object[howManySearchedElements];
				int indexForNeighbors = 0;
				for(int i = 0; i < elementCounter - 1; i++) {
					if(elements[i].equals(inputElement)) {
					nextNeighbour[indexForNeighbors] = elements[i + 1];
					indexForNeighbors++;
				}
				}
				return nextNeighbour;
		}
		//false case
			else {
				throw(new Exception("Input element is not found in the array")); //metam iznemumu
			}
		}
		
		
	//TODO sort
		/*
		 * Izveidot funkciju, kas veic elementu kārtošanu.
		 */
		public T[] sort(SortingType type) throws Exception {
			if(isEmpty()) {
				throw (new Exception("Array is empty ad it is not possible to sort"));
			}
			else {
				T[] sortArray = (T[])new Object[elementCounter];
				
				for(int i = 0; i < elementCounter; i++) {
					sortArray[i] = elements[i];
				}
				
				int sortVariable = 1;	//DESC	
				if(type == SortingType.ASC) {
					sortVariable = -1;
				}
						

					for(int i = 0; i < elementCounter; i++) {
						for(int j = 0; j < elementCounter; j++) {
							//if(sortArray[i] < sortArray[j]) 
							if(((Comparable)(sortArray[i])).compareTo(sortArray[j]) == -1) { 
								// 0  6
								//[a] [x]
								//temp = a
								//samainam vietas
								//[x] [a]
								T temp = sortArray[i];
								sortArray[i] = sortArray[j];
								sortArray[j] = temp;
							}
						}
					}
				return sortArray;
					}
				}
			
		
			

	
		
	/*
	 * Izveidot funkciju, kas veic saraksta izvadi;.
	 */
		public void print() throws Exception{
			if(isEmpty()) {
				throw (new Exception("Array is empty ad it is not possible to print elements"));
			}
			else {
				for(int i = 0; i < elementCounter; i++) {
				System.out.print(elements[i] + " ");
		}
				System.out.println();
			}
		}
		
		
	//TODO makeEmpty
		public void makeEmpty() {
			arraySize = DEFAULT_ARRAY_SIZE;
			elementCounter = 0;
			elements = (T[])new Object[arraySize];
			System.gc();	//garbage collector
		}
}
