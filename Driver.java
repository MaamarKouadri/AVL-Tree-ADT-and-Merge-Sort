package Assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student a1 = new Student (6,"Maamar");
		Student a2 = new Student (10,"Olive");
		Student a3 = new Student (9,"Tom");
		
		Student a4 = new Student (10,"Zidane");
		Student a5 = new Student (11,"Zidane2");
		Student a6 = new Student (6,"Zidane3");
        AVLTree Tree =  new  AVLTree();
        
        Tree.insert(a1);
        Tree.insert(a2);
        Tree.insert(a3);
        Tree.insert(a4);
        Tree.insert(a5);
        Tree.insert(a6);
        
        
        Tree.traverse();
        
        ArrayList<Student> list = Tree.Sorted();
        System.out.println("------------------------------------------");
        System.out.println("Testing the sorted algorithm");
        print(list);
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println();
        System.out.println();
        /*ArrayList<Student> list2 = Tree.Values(6);
        
        System.out.println("------------------------------------------");
        System.out.println("Testing the values algorithm");
        for(Student a : list2) {
        	
        	System.out.print("{"+a+"}-->");
        	
        }
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println();
        
        */
        int number =Tree.CalculateRange(a1.getStudentIDentificationCode(), a6.getStudentIDentificationCode());
        
        System.out.println("Number is " + number);
    	 
       
        
        Student key =   Tree.next(6);
        
        Student key2 =   Tree.Previous(10);
        
        System.out.println(key);
        System.out.println(key2);
        
      
        
        System.out.println(number);
        
    	//CSTA_test_file1.txt
    	//CSTA_test_file2.txt
    	//CSTA_test_file3.txt
        long start = System.currentTimeMillis();
    	System.out.println("Now we are reading the file");
    	
    	IntelligentSIDC IDC = new IntelligentSIDC();
    	//IntelligentSIDC IDC2 = new IntelligentSIDC();
    	//IDC2.setSize(10);
    	//IDC2.generate();
    	try {
			Scanner sc = new Scanner(new FileInputStream("CSTA_test_file3.txt"));
			ReadFileForLines(sc,IDC);
			sc.close();
			sc = new Scanner(new FileInputStream("CSTA_test_file3.txt"));
			ReadFileForAdding(sc,IDC);
			
			
			ArrayList<Student> list1 = IDC.AllKeys();
			System.out.println("************************************************");
			System.out.println("We are printing the list");
			System.out.println(list1.size());
			//print(list1);
			System.out.println("************************************************");
			Student list3 = IDC.getValues(70165052);
			//System.out.println(list3.getStudentIDentificationCode());
			//print(list3);
			long nextKey = IDC.nextKey(70165052); // this to check 
			System.out.println("************************************************");
			System.out.println("\n The next key of 33279973 is " + nextKey  );
			long PrevKey = IDC.prevKey(70165052); //this to check
			System.out.println("The previous key of 33279973 is " + PrevKey  );
			System.out.println("************************************************");
			long y = 0;
			long z = 70165052;
			int number2 = IDC.rangeKey(y, z);
			System.out.println("\nThe number of keys between " + y +" and " + z +" is " + number2);
			System.out.println("We are here2");
			ArrayList<Student> list4 = IDC.AllKeys();
			//print(list4);
			//IDC.remove(70165052);	
			ArrayList<Student> list5 = IDC.AllKeys();
			//print(list5);
			System.out.println("We are here");
			sc.close();
			long end = System.currentTimeMillis();
			
			long time = end - start;
			System.out.println("*****************************************************************************************************");
			System.out.println("The program took "+ time +" seconds to complete ");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	

	public static void ReadFileForLines(Scanner sc, IntelligentSIDC IDC) {
		String Line = "";
		String Text = "";
		int count =0;
		
		if(!sc.hasNext()) {
			System.out.println("File is empty");
		System.exit(0);
		}
		while (sc.hasNextLine()) {
			Line = sc.nextLine();
			System.out.println(Line);
			count++;	
			
			// System.out.println(Line);
		}
		
		IDC.SetSIDCThreshold(count);
		System.out.println("We have reached this point the size is " + IDC.getSize());
		// System.out.print(Text);
		// System.out.println("This text has " + NumberOfLines + "lines.");
	}
	
	public static void ReadFileForAdding(Scanner sc, IntelligentSIDC IDC) {
		String Line = "";
		String Text = "";
		int count =0;
		System.out.println("Entering the second ReadFileForAdding");
		if(!sc.hasNext()) {
			System.out.println("File is empty");
		System.exit(0);
		}
		while (sc.hasNextLine()) {

			count++;
			
			Line = sc.nextLine();
			
			String [] split = Line.split("\\s+");
			
			long key = Long.parseLong(split[0]);
			
		
			
			IDC.add(key, "Student"+count);
			System.out.println(split[0]);

			
			// System.out.println(Line);
		}
		
		
		// System.out.print(Text);
		// System.out.println("This text has " + NumberOfLines + "lines.");
	}
	
	public static void print (ArrayList<Student> a ) {
		System.out.println();
		for(Student b : a ) {
			
			System.out.println(b);
			
		}
		System.out.println(a.size());
	}
	

}
