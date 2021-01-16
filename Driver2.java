package Assignment4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			IntelligentSIDC IDC = new IntelligentSIDC();
			
			long start = System.currentTimeMillis();
		
			Scanner sc = new Scanner(new FileInputStream("CSTA_test_file3.txt"));
			/*
			ReadFileForLines(sc,IDC);
			sc.close();
			sc = new Scanner(new FileInputStream("CSTA_test_file5.txt"));
			ReadFileForAdding(sc,IDC);
			*/
			
			IDC.SetSIDCThreshold(1000000);
			IDC.generate();
			
			
			
			ArrayList<Student> list1 = IDC.AllKeys();
			System.out.println("************************************************");
			System.out.println("We are printing the list");
	
			print(list1);
			System.out.println("************************************************");
			Student list3 = IDC.getValues(12809348);
			System.out.println(list3.getStudentIDentificationCode());
			System.out.println("This value is for student " + list3 );
			long nextKey = IDC.nextKey(12809348); // this to check 
			System.out.println("************************************************");
			System.out.println("\n The next key of 12809348 is " + nextKey  );
		  long PrevKey = IDC.prevKey(12809348); //this to check
			System.out.println("The previous key of 12809348 is " + PrevKey  );
			System.out.println("************************************************");
			long y = 0;
			long z = 12809348;
			int number2 = IDC.rangeKey(y, z);
			System.out.println("\nThe number of keys between " + y +" and " + z +" is " + number2);

			//IDC.remove(12809348);	
			ArrayList<Student> list5 = IDC.AllKeys();
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			//System.out.println("We are printing list after remove");
			///print(list5);
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			sc.close();
			long end = System.currentTimeMillis();
			
			long time = end - start;
			System.out.println("*****************************************************************************************************");
			System.out.println("The program took "+ time +" milli seconds to complete ");
			System.out.println("The size of the SIDC is " + IDC.getSize());
			
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
		
		//IDC.SetSIDCThreshold(count);
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
