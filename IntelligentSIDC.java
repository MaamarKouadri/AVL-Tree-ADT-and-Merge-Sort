package Assignment4;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Maamar Kouadri (...) and Emmanuel Mfumuangani (40033601)
 * 
 * This class implements all the methods for the Intelligent SIDC
 *
 */

public class IntelligentSIDC {

	private int size;

	private int add;

	private static boolean ManuelSize = false;

	private ArrayList<Student> list = new ArrayList<>();

	private AVLTree tree = new AVLTree();

	private MergeSort ms = new MergeSort(list);

	/**
	 * Method to set the threshold for the IntelligentSIDC
	 */
	public void SetSIDCThreshold2() {

		Random obj = new Random();

		this.size = obj.nextInt(500000 - 100 + 1) + 100;
		ManuelSize = true;

	}
	
	/**
	 * Parameterized method in order to set the size of the IntelligentSIDC
	 * @param Size is an integer representing the size of the IntelligentSIDC
	 */

	public void SetSIDCThreshold(int Size) {

		this.size = Size;

		ManuelSize = true; // sets the boolean variable to true

	}
	
	/**
	 * Getter for  the  static size of the SIDC
	 * @return an integer representing the static size of the IntelligentSIDC
	 */

	public int getSize() {
		
		if(!ManuelSize)
		return size;
		
		else
			return add;
	}
	
	/**
	 * Getter for the dynamic size of IntelligentSIDC
	 * @return an integer representing the dynamic size of the IntelligentSIDC
	 */
	
	public int getSize2() {
		return add;
	}
	
	

	
	
	/**
	 * Setter for the static size of IntelligentSIDC
	 * @param size is an integer representing the static size of the IntelligentSIDC
	 */

	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * Method to generate a number of Student given the size of IntelligentSIDC
	 */

	public void generate() {
		Random obj = new Random();
		long key;
		
		
		for (int i = 0; i < this.size; i++) {
			
		
			key = obj.nextInt(9999999 - 1000000 + 1) + 9999999; // generates 8 digits id numbers 

			if(i == size/2) {
				this.add(12809348, "Student" + i);	
			System.out.println("I is here" + i);
			}
			
		        if(i != size/2)	   
		          	
			this.add(key, "Student" + i); // adds student into the Intelligent SIDC

		}
	}

	
	/**
	 * Method to add an entry for the given key and value
	 * @param key is a long representing the id of a student
	 * @param name is a string representing the name of a student
	 */

	public void add(long key, String name) {
//System.out.println("We are adding");
		if (!ManuelSize) { // if the size is not specified manually
			size++;
			System.out.println("The size is :" + size);

			Student a1 = new Student(key, name); // creates a new student

			if (size == 1001) { // if size goes reaches the threshold , a transfer occurs
				System.out.println("Transfer occuring ! size is " + size);
				transfer();
			}
			if (this.size > 1000) {

				tree.insert(a1); // insert it in the AVL

			}

			else
			// list.add(a1);
			if (ms.checkDuplicate(key) == false)
				ms.getSortedArray().add(a1); // insert it in the array list

		}

		else {// same as the if statement above

			add++;
			//System.out.println("The size is :" + size);
			//System.out.println("We have added : " + add + " elements");

			Student a1 = new Student(key, name);

			if (add == 1001) { // if size goes reaches the threshold , a transfer occurs
				System.out.println("Transfer occuring ! size is " + add);
				transfer();
			}
			if (this.size > 1000) {

				tree.insert(a1); // insert it in the AVL

			}

			else {
			// list.add(a1);
				//System.out.println("We are adding " + a1);
			if (ms.checkDuplicate(key) == false)
				ms.getSortedArray().add(a1); // insert it in the array list
			
			}

		}

	}
	
	/**
	 * Method to remove the entry for the given key
	 * @param key is an long representing the id of a student
	 */

	public void remove(long key) {

		if (!ManuelSize) { // if the size is not specified manually
			size--;
			Student a1 = new Student(key, "");
			transfer();
			if (this.size > 1000) {

				tree.Remove(a1); // remove from the tree
			}

			else
				ms.Remove(a1); // remove the array list

		}

		else { // size is specified manually
			add--;
			// size --;
			Student a1 = new Student(key, "");
			transfer();
			if (this.add > 1000) {

				tree.Remove(a1); // remove the array list
			}

			else
				
				ms.Remove(a1); // remove the array list

		}

	}
	
	
	
	
	/**
	 * Method to return the values of the given key
	 * @param key is a long representing the id of a student
	 * @return an object of type Student
	 */
	public Student getValues(long key) {

		if (!ManuelSize) { // if the size is not specified manually
			if (this.size > 1000) {

				return tree.Values(key); // return a student from the tree 
			}

			else
				return ms.Values(key); // return a student from the array list 
		} else { // if the size is specified manually

			if (this.add > 1000) {

				return tree.Values(key); // return a student from a tree
			}

			else
				return ms.Values(key); // return a student from the array list
		}

	}

	
	/**
	 * Method to return the key for the predecessor of key;
	 * @param key is a long representing the id of a student
	 * @return a long representing the id of the student before the one whose key was provided
	 */

	public long prevKey(long key) {
		if (!ManuelSize) { // if size was not manually provided
			Student a1 = new Student(key, ""); // create a student with the key provided
			if (this.size > 1000) {

				return tree.next(key).getStudentIDentificationCode(); // get the id in the tree
			}

			else
				return ms.prev(key); // get the id in the array list
		}

		else { // size is not manually provided

			Student a1 = new Student(key, ""); // create a student 
			if (this.add > 1000) {

				return tree.next(key).getStudentIDentificationCode(); // get the key from the tree
			}

			else
				return ms.prev(key); // get the id from the array list
		}

	}
	
	/**
	 * Method to return the key for the successor of key
	 * @param key is a long representing the id of a student
	 * @return a long representing the id of the student after the one whose key was provided
	 */

	public long nextKey(long key) {

		if (!ManuelSize) { // if size is not manually provided
			Student a1 = new Student(key, ""); // create a Student
			if (this.size > 1000) { 

				return tree.Previous(key).getStudentIDentificationCode(); // get the key from the tree
			}

			else
				return ms.next(key); // get the key from the array list
		}

		else { // if size is  manually provided

			Student a1 = new Student(key, "");  // create a Student
			if (this.add > 1000) {

				return tree.Previous(key).getStudentIDentificationCode(); // get the key from the tree
			}

			else
				return ms.next(key); // get the key from the array list
		}

	}
	
	/**
	 * Method to returns the number of keys that are within the specified range of the two keys
	 * @param key is a long representing the first key of the range 
	 * @param key2 is a long representing the last  key of the range 
	 * @return an integer representing the number of keys in the range between the two keys
	 */

	public int rangeKey(long key, long key2) {
		if (!ManuelSize) { // if size is not manually specified
			if (this.size > 1000) {

				return tree.CalculateRange(key, key2); // get the range from the tree
			}

			else
				return ms.calculateRange(key, key2); // get the range from the array list 
		}

		else { // if size is  manually specified

			if (this.add > 1000) {

				return tree.CalculateRange(key, key2); // get range from the tree
			}

			else
				return ms.calculateRange(key, key2); // get range from the array list 
		}

	}
	
	/**
	 * Method to return all keys in IntelligentSIDC as a sorted sequence
	 * @return an Array List of type Student
	 */

	public ArrayList<Student> AllKeys() {

		if (!ManuelSize) { // if size is not specified manually 

			if (this.size > 1000) {

				return tree.Sorted(); // get all the keys from the AVL tree
			}

			else {

				return ms.sort(); // return a sorted ArrayList using the Merge-Sort algorithm

			}
		}

		else {

			System.out.println("We are here and size is " + this.getSize());
			if (this.add > 1000) {

				return tree.Sorted(); // get all the keys from the AVL tree
			}

			else {

				return ms.sort(); // return a sorted ArrayList using the Merge-Sort algorithm

			}

		}

	}
	
	/**
	 * Method to transfer our Student objects from one ADT to the other
	 */

	public void transfer() {

		if (!ManuelSize) { // if size is not specified manually
			if (size == 1001) {
				System.out.println("Transferring the data");
				for (Student a : this.ms.getSortedArray()) {
					tree.insert(a); // insert Student object in the tree
				}

				ms.getSortedArray().removeAll(ms.getSortedArray()); // remove them all from the merge-sort array list

				/*
				 * for(Student a : this.ms.getSortedArray()) { ms.Remove(a); }
				 */
			}

			if (size == 1000 && tree.getNumberOfKeys() != 0) {
				ArrayList<Student> t = tree.Sorted(); // returns all the Student objects inside the tree
				System.out.println("Transferring the data");
				for (Student a : t) {
					ms.getSortedArray().add(a); // adds them all into the merge-sort array list 
				}

				for (Student a : t) {
					tree.Remove(a); // removes them all from the AVL tree 
				}
			}

			
		}

		else { // size is specified manually
			if (add == 1001) {
				System.out.println("Transferring the data");
				for (Student a : this.ms.getSortedArray()) {
					tree.insert(a); // insert Student object in the tree
				}

				ms.getSortedArray().removeAll(ms.getSortedArray()); // remove them all from the merge-sort array list

				/*
				 * for(Student a : this.ms.getSortedArray()) { ms.Remove(a); }
				 */
			}

			if (add == 1000 && tree.getNumberOfKeys() != 0) {
				ArrayList<Student> t = tree.Sorted(); // returns all the Student objects inside the tree
				System.out.println("Transferring the data");
				for (Student a : t) {
					ms.getSortedArray().add(a); // adds them all into the merge-sort array list 
				}

				for (Student a : t) {
					tree.Remove(a);  // removes them all from the AVL tree 
				}
			}

			
		}

	}

}
