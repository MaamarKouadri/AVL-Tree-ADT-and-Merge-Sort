package Assignment4;
   public class DynamicArray {

	Student arr[] = new Student[1]; 
	
	public int size = arr.length;

	int lastIndex;
	int occupiedSize = 0;

	

	public DynamicArray() {
		super();
	}
	
	public DynamicArray(int n) {
		arr = new Student[n];
		size = n;
	}
	
	
	public Student [] NewArray(int n) {
		Student arr2[] = new Student[n];
		
	for(int i = 0; i < arr.length ; i++) {
		
		arr2[i] = arr[i];
			
	}	
	size = n;
	
	return arr2;
	}

	public int size() {

		return arr.length;
	}

	public void add(Student s) {

		/*
		System.out.println("Size is " + occupiedSize);
		
		System.out.println("Last index is  " + lastIndex);
		*/
		if (occupiedSize == 0) {

			arr[0] = s;
			occupiedSize++;
			lastIndex=0;
			
			
		}
		else if (occupiedSize > 0 && occupiedSize < arr.length) {

			arr[lastIndex + 1] = s;

			occupiedSize++;
			lastIndex++;
		}

		else {

		arr = NewArray(size + 1);
		arr[lastIndex + 1] = s;
		occupiedSize++;
		lastIndex++;

		}

	}

	private void DynamicArray(int i) {
		// TODO Auto-generated method stub

	}

	public void remove(int index) {

		for (int i = 0; i < arr.length; i++) {

			if(arr[i] != null)
			if (arr[i].equals(arr[index])) {
				
				//System.out.println(arr[i] + " will be deleted");
				arr[i] = null;
				this.occupiedSize--;
				this.lastIndex--;
			}
		}
	}

	public boolean isEmpty() {

		return this.occupiedSize == 0;
	}

	public Student get(int index) {

		
		
		return arr[index];

	}

	public void set(int index, Student a) {

		arr[index].modifiesStudent(a);

	}

	public void PrintArray() {

		System.out.println("The size of the array is " + size);
		
		System.out.println("The occupied size is " + this.occupiedSize);
		System.out.println("The last index is at " + this.lastIndex);
		
		int count = 0;
		for (Student a : this.arr) {
			
			System.out.println("index " + count + ": " + a + " ");
			
			count++;
		}

	}
	
	public int indexOf(Student s) {
		
		for (int i = 0; i < arr.length; i++) {

			if(arr[i] != null)
			if (arr[i].equals(s)) {
				
				return i;
			}
		}
		
		return -1;
		
	}

}
