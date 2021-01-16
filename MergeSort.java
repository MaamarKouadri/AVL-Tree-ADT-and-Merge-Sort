package Assignment4;

import java.util.ArrayList;
/**
 * 
 * @author Emmanuel Mfumuangani (40033601) and Maamar Kouadri (40057671)
 * 
 * This class implements the Merge Sort algorithm with which we use our Array List
 *
 */
public class MergeSort {
	
	private ArrayList<Student> inputArray;
	 
	/**
	 * Parameterized constructor
	 * @param inputArray represents an ArrayList of type student
	 */
	 public MergeSort(ArrayList<Student> inputArray){ // constructor
	        this.inputArray = inputArray;
	    }
	 
	 /**
	  * Getter for the class
	  * @return an ArrayList of type Student
	  */
	 public ArrayList<Student> getSortedArray() { // getter
	        return inputArray;
	    }
	 /**
	  * Sorting method
	  * @return a sorted ArrayList of type Student using the merge sort algorithm
	  */
	 public ArrayList<Student> sort(){       
	        divide(0, this.inputArray.size()-1);
	        
	        
	       
	       
	        return inputArray;
	    }
	 
	
	 /**
	  * Method to divide our array
	  * @param startIndex represents the first index of the array
	  * @param endIndex represents the last index of the array
	  */
	 public void divide(int startIndex,int endIndex){
	        
	        //Divide till you breakdown your list to single element (n arrays of size 1)
	        if(startIndex<endIndex && (endIndex-startIndex)>=1){
	            int mid = (endIndex + startIndex)/2;
	            divide(startIndex, mid);// takes the first half
	            divide(mid+1, endIndex);// takes the second half        
	            
	            //merging sorted array produce above into one sorted array
	            merger(startIndex,mid,endIndex);            
	        }       
	    }  
	 
	 /**
	  * Merging method to rebuilt our Array List  while also sorting
	  * @param startIndex represents the first index of the array list 
	  * @param midIndex  represents the middle index of the array list 
	  * @param endIndex  represents the last index of the array list 
	  */
	 public void merger(int startIndex,int midIndex,int endIndex){
	        
	        //Below is the merged array that will be sorted array Array[i-midIndex] , Array[(midIndex+1)-endIndex]
	        ArrayList<Student> mergedSortedArray = new ArrayList<Student>();
	        
	        int leftIndex = startIndex;
	        int rightIndex = midIndex+1;
	        
	        while(leftIndex<=midIndex && rightIndex<=endIndex){
	            if(inputArray.get(leftIndex).getStudentIDentificationCode()<=inputArray.get(rightIndex).getStudentIDentificationCode()){
	                mergedSortedArray.add(inputArray.get(leftIndex));
	                leftIndex++;
	            }else{
	                mergedSortedArray.add(inputArray.get(rightIndex));
	                rightIndex++;
	            }
	        }       
	        
	        //Either of below while loop will execute
	        while(leftIndex<=midIndex){
	            mergedSortedArray.add(inputArray.get(leftIndex));
	            leftIndex++;
	        }
	        
	        while(rightIndex<=endIndex){
	            mergedSortedArray.add(inputArray.get(rightIndex));
	            rightIndex++;
	        }
	        
	        int i = 0;
	        int j = startIndex;
	        //Setting sorted array to original one
	        while(i<mergedSortedArray.size()){
	            inputArray.set(j, mergedSortedArray.get(i++));
	            j++;
	        }
	    }
	 
	 
	 /**
	  * Remove method
	  * @param s is an object of type Student
	  */
	 public void Remove(Student s) {
		 
		 for(int i = 0 ; i < inputArray.size() ; i++) { // loop across the Array List
			 
			 if(inputArray.get(i).getStudentIDentificationCode() == s.getStudentIDentificationCode()) { // compares the Student at the current index with the Student passed as argument
				 
				 inputArray.remove(i); // removes student at said index
				 break;
			 }
			 
		 }
	 }
	 
	 /**
	  * Method returning a Student with the given key
	  * @param key is a long representing the Student's id
	  * @return an object of type Student
	  */
	 public Student Values(long key) {
		 
		 Student found = null; // reference variable is set to null
		 
		 for(int i = 0 ; i < inputArray.size() ; i++) { // loop across the Array List
			 
			 if(inputArray.get(i).getStudentIDentificationCode() == key) { // compares the Student's key at the current index with the key passed
				
				  found = inputArray.get(i); // assign the Student whose corresponding key is the same as the one passed
				  break;
			 }
			 
		 }
		return found;
		 
	 }
	 
	 /**
	  * Method for getting the id of the next Student
	  * @param key is long  representing the id of a Student
	  * @return a long representing the id of the next Student after the one with key provided as argument
	  */
	 public long next(long key) {
		 
		 Student found = null; // reference variable is set to null
		 long nextKey = 0;
		 
		 	for(int i = 0 ; i < inputArray.size() ; i++) { // loop across the Array List
			 
			 if(inputArray.get(i).getStudentIDentificationCode() == key) { // compares the Student's key at the current index with the key passed
				
				 found = inputArray.get(i + 1);// gets the Student which has the next key in the sequence
				 
				  nextKey = found.getStudentIDentificationCode();
				  break;
				 
			 }
			 
		 }
		 	
		 	return nextKey;
		 
		 
	 }
	 
	 /**
	  * Method for getting the id of the previous Student
	  * @param key is long  representing the id of a Student
	  * @return  a long representing the id of the previous Student before the one with key provided as argument
	  */
	 public long prev(long key) {
		 
		 Student found = null; // reference variable is set to null
		 long prevKey = 0;
		 
		 	for(int i = 0 ; i < inputArray.size() ; i++) { // loop across the Array List
			 
			 if(inputArray.get(i).getStudentIDentificationCode() == key) { // compares the Student's key at the current index with the key passed
				
				 found = inputArray.get(i - 1);// gets the Student which has the next key in the sequence
				 
				  prevKey = found.getStudentIDentificationCode(); // gets the ID of the found Student
				  break;
				 
			 }
			 
		 }
		 	
		 	return prevKey;
		 
		 
	 }
	 
	 /**
	  * Method to calculate the amount of Student between two IDs
	  * @param key1  represents the id of the first student in the range
	  * @param key2 represents the id of the last student in the range
	  * @return
	  */
	 public int calculateRange(long key1, long key2) {
		 
		 int firstIndex = 0;
		 int lastIndex = 0 ;
		 
		 
		 for(int i = 0 ; i < inputArray.size() ; i++) { // loop across the Array List
			 
			 if(inputArray.get(i).getStudentIDentificationCode() == key1) { // compares the Student's key at the current index with the key passed
				
				firstIndex = i; // index at which the key is situated
				break;
				 
			 }
			 
		 }
		 
		 for(int j = 0 ; j < inputArray.size() ; j++) { // loop across the Array List
			 
			 if(inputArray.get(j).getStudentIDentificationCode() == key2) { // compares the Student's key at the current index with the key passed
				
				lastIndex = j;
				break;
				 
			 }
			 
		 }
		 
		 
		 return lastIndex - firstIndex - 1; // the range between the two indices
		 
		 
	 }
	 
	 /**
	  * Method to check for duplicates before adding into the ArrayList
	  * @param key is a long representing a Student's ID
	  * @return a boolean (true if there is a duplicate, else false)
	  */
	 public boolean checkDuplicate(long key) {
		 
		 for(Student a : inputArray) {
			 if(a.getStudentIDentificationCode() == key) { // checks if a student in the input Array has such ID
				 return true;
			 }
			 
		 }
		 
		 return false;
	 }
	 

}
