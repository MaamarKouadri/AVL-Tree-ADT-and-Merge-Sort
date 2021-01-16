package Assignment4;

import java.util.ArrayList;

/**
 * 
 * @author Emmanuel Mfumuangani (40033601) and Maamar Kouadri (40057671)
 * 
 * This class implements the AVL tree algorithm with which we use our Array List
 *
 */
public class AVLTree  {
	
	private MyNode root;

	private int NumberOfKeys = 0;

	ArrayList<Student> sequence = new ArrayList<Student>();
	
	ArrayList<Student> values = new ArrayList<Student>();
	
	/**
	 * This is the insert method method where we insert the students
	 * @param s
	 */

	public void insert(Student s) {

       // System.out.println(s +" is being inserted");

        if(this.Search(s.getStudentIDentificationCode(), this.root) == null)
        root = insert(root, s);

    }
	public MyNode getRoot() {
		return root;
	}

	/**
	 * This is the remove method that will can the remove method on the root.
	 * @param s
	 */
	public void Remove(Student s) {

		root = Remove(root, s);

	}

	/**
	 * This is the insert method that will insert a node containing the student.
	 * @param node
	 * @param s
	 * @return
	 */
	private MyNode insert(MyNode node, Student s) {

		if (node == null)
			return new MyNode(s);

		if (s.getStudentIDentificationCode() < node.getStudent().getStudentIDentificationCode())
			node.setLeftNode(insert(node.getLeftNode(), s));

		else {
			node.setRightNode(insert(node.getRightNode(), s));
		}
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

		node = CheckForImbalance(s, node);

		return node;
	}

	/**
	 * This methods checks if the tree is balance  or not .
	 * @param s Student variable 
	 * @param node Node containing the student 
	 * @return
	 */
	private MyNode CheckForImbalance(Student s, MyNode node) {

		int balance = this.getBalance(node);

		// left left situation
		if (balance > 1
				&& s.getStudentIDentificationCode() < node.getLeftNode().getStudent().getStudentIDentificationCode())
			return RightRotation(node);

		// right right situation
		if (balance < -1
				&& s.getStudentIDentificationCode() > node.getRightNode().getStudent().getStudentIDentificationCode())
			return LeftRotation(node);

		// left right situation balance smaller than -1
		if (balance > 1
				&& s.getStudentIDentificationCode() > node.getLeftNode().getStudent().getStudentIDentificationCode()) {
			node.setLeftNode(LeftRotation(node.getLeftNode()));
			return RightRotation(node);
		}

		if (balance < -1
				&& s.getStudentIDentificationCode() < node.getRightNode().getStudent().getStudentIDentificationCode()) {
			node.setRightNode(RightRotation(node.getRightNode()));
			return LeftRotation(node);
		}

		return node;
	}
	/**
	 * Performs a 
	 * @param node
	 * @return
	 */
	
	/**
	 * This  Method performs a right notation on the node
	 * @param node Node doing the right notation.
	 * @return will return a new node after the rotation.
	 */

	private MyNode RightRotation(MyNode node) {

		//System.out.println("I am rotating to the right for node " + node);

		MyNode tempLeftNode = node.getLeftNode();

		
	          if(tempLeftNode!=null) {
		MyNode t = tempLeftNode.getRightNode();

		tempLeftNode.setRightNode(node);
		node.setLeftNode(t);

		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
		tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftNode()), height(tempLeftNode.getRightNode())) + 1);

		return tempLeftNode;
	          }
	          
	          else return null;
	}
	
	/**
	 * Performs a left notation on the node  
	 * @param node  Node where the rotation will be performed
	 * @return will return a new node after the rotation.
	 */

	private MyNode LeftRotation(MyNode node) {

		//System.out.println("I am rotating to the left for the node " + node);

		MyNode tempRightNode = node.getRightNode();

		if(tempRightNode!= null) {
		MyNode t = tempRightNode.getLeftNode();

		tempRightNode.setLeftNode(node);
		node.setRightNode(t);
		;

		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
		tempRightNode
				.setHeight(Math.max(height(tempRightNode.getLeftNode()), height(tempRightNode.getRightNode())) + 1);

		return tempRightNode;
		}
		
		else
			return null;
	}

	/**
	 * This returns the height of this node.
	 * @param node Node that will be used to calculate the height
	 * @return return the specific height of that node.
	 */
	public int height(MyNode node) {

		if (node == null)
			return -1;

		return node.getHeight();

	}

	/**
	 * This method returns the balance of the node depending on its location and height 
	 * @param node
	 * @return
	 */
	public int getBalance(MyNode node) {

		if (node == null)
			return 0;

		return height(node.getLeftNode()) - height(node.getRightNode());

	}
	/**
	 * This method will traverse the entire tree and prints the   nodes content
	 */

	public void traverse() {
		if (root == null)
			return;

		inOrderTraversal(root);

	}
	
	/**
	 * This method will make the traversal
	 * @param node This is the root node.
	 */

	private void inOrderTraversal(MyNode node) {
		if (node.getLeftNode() != null)
			inOrderTraversal(node.getLeftNode());

		System.out.println(node);

		if (node.getRightNode() != null)
			inOrderTraversal(node.getRightNode());

	}

	
	/**
	 * This method is the same than in order traversal but is used for another time , for contain the number of keys
	 * inside the tree.
	 * @param node root node 
	 * @param key
	 * @param key2
	 */
	private void inOrderTraversal2(MyNode node, long key, long key2) {

		if (key <= node.getStudent().getStudentIDentificationCode()  &&node.getStudent().getStudentIDentificationCode() <= key2)
			NumberOfKeys++;

		if (node.getLeftNode() != null)
			inOrderTraversal2(node.getLeftNode(), key,key2);

		if (node.getRightNode() != null)
			inOrderTraversal2(node.getRightNode(), key,key2);
	}

	
	/**
	 * This method will add the nodes to the sorted sequence
	 * @param node
	 */
	public void SortedSequence(MyNode node) {

        if (node.getLeftNode() != null)
            SortedSequence(node.getLeftNode());

        sequence.add(node.getStudent());

        if (node.getRightNode() != null)
            SortedSequence(node.getRightNode());

    }

	
	/**
	 * This will return the Arraylist with a sorted list containing the values of all the nodes. 
	 * @return
	 */
	public ArrayList<Student> Sorted(){
		 ArrayList<Student> copy;
		 if(root!= null) {
        MyNode node = root;
		 
        System.out.println("Root"+ node.getStudent());
        SortedSequence(node);
        copy = this.sequence;
        return copy;
		 }
        
        else 
        	
       return null;

    }
	
	
	/**
	 * This will return the value required by the method in the Intelligent SIDC 
	 * @param node
	 * @param key
	 */
	public void ValuesList(MyNode node, long key) {

		if (node.getLeftNode() != null)
			ValuesList(node.getLeftNode(), key);

	if(node.getStudent().getStudentIDentificationCode() == key) 
		values.add(node.getStudent());
		
		if (node.getRightNode() != null)
			ValuesList(node.getRightNode(), key);
		
					
	}
	
	
	/**
	 * This will used the method Values List and return the specific value.
	 * @param key
	 * @return the return the value with that key if it is found 
	 */
	public Student Values(long key){

	    MyNode node = root;
	        System.out.println("Root"+ node.getStudent());
	        ValuesList(node,key);
	        return this.values.get(0);

	    }
	
/**
 * This method will return the ArrayList containing the values 
 * @return
 */
	public ArrayList<Student> getValues() {
		return values;
	}
/**
 * This method will return the values  that contain setValues
 * @param values
 */
	public void setValues(ArrayList<Student> values) {
		this.values = values;
	}

	/**
	 * This method will return the number  of keys inside the AVL tree
	 * @return
	 */
	public int getNumberOfKeys() {
		return NumberOfKeys;
	}
	
	/**
	 * This method will return the values  that contain the sorted sequence of students 
	 * @param values
	 */
	public ArrayList<Student> getSequence() {
		return sequence;
	}
	/**
	 * This method will set the sequence.
	 * @param sequence
	 */

	public void setSequence(ArrayList<Student> sequence) {
		this.sequence = sequence;
	}

	/**
	 * This is a search algorithm to find a particular node with a given key in the tree.
	 * @param key The key that we are going to be looking for
	 * @param node The root of the tree
	 * @return returns the node having this key if found.
	 */
	private MyNode Search(long key, MyNode node) {

		if (node != null) {

			if (key == node.getStudent().getStudentIDentificationCode())
				return node;

			else if (key < node.getStudent().getStudentIDentificationCode())
				return Search(key, node.getLeftNode());

			else
				return Search(key, node.getRightNode());
		}

		else
			return null;

	}

	
/**
 * This method will allow us to find the minimum value in the tree
 * @param root
 * @return
 */
	public MyNode findLowest(MyNode root) {
		while (root.getLeftNode() != null) {
			root = root.getLeftNode();
		}

		return root;
	}
/**
 * This method will allow us to find the maximum value in the tree 
 * @param root
 * @return
 */
	public MyNode FindHighest(MyNode root) {
		while (root.getRightNode() != null) {
			root = root.getRightNode();
		}

		return root;
	}

	/**
	 * This method would allow us to find the next value of a given node having a given key
	 * @param root This is the root of the three
	 * @param succ The node after the key 
	 * @param key the key that we are going to be looking for
	 * @return
	 */
	public Student FindNextValue(MyNode root, MyNode succ, long key) {
		
		if (root == null) {
			return null;
		}

		
		if (root.getStudent().getStudentIDentificationCode() == key) {
			if (root.getRightNode() != null) {
				return findLowest(root.getRightNode()).getStudent();
			}
		}

		
		else if (key < root.getStudent().getStudentIDentificationCode()) {
			
			succ = root;
			return FindNextValue(root.getLeftNode(), succ, key);
		}

	
		else {
			return FindNextValue(root.getRightNode(), succ, key);
		}

		return succ.getStudent();
	}

	/**
	 * This is the method to find the the predecessor , we have to find the value  before  this key  ,  it goes through the entire tree.
	 * @param root root of the tree
	 * @param prec  
	 * @param key  key that is going to verify
	 * @return
	 */
	public MyNode FindPreviousValue(MyNode root, MyNode prec, long key) {
	
		if (root == null) {
			return prec;
		}

		
		if (root.getStudent().getStudentIDentificationCode() == key) {
			if (root.getLeftNode() != null) {
				return FindHighest(root.getLeftNode());
			}
		}

		else if (key < root.getStudent().getStudentIDentificationCode()) {
			return FindPreviousValue(root.getLeftNode(), prec, key);
		}

		
		else {
			
			prec = root;
			return FindPreviousValue(root.getRightNode(), prec, key);
		}
		return prec;
	}
	/**
	 * This is the remove method that will remove a node from the tree.
	 * @param Node  root of the  tree
	 * @param s The student  s with the appropriate    student ID to be verified.
	 * @return
	 */

	private MyNode Remove(MyNode node, Student s) {

        if (node == null)
            return node;

        if (s.getStudentIDentificationCode() < node.getStudent().getStudentIDentificationCode())
            node.setLeftNode(Remove(node.getLeftNode(), s));

        else if (s.getStudentIDentificationCode() > node.getStudent().getStudentIDentificationCode())
            node.setRightNode(Remove(node.getRightNode(), s));

        else {

            if (node.getLeftNode() == null && node.getRightNode() == null) {

               

                return null;
            }

            if (node.getLeftNode() == null) {

              

                MyNode tempnode = node.getRightNode();
                node = null;
                return tempnode;

            } else if (node.getRightNode() == null) {
             
                MyNode tempnode = node.getLeftNode();
                node = null;
                return tempnode;

            }

            
         
            MyNode tempnode = getAncestor(node.getLeftNode());

            node.setStudent(tempnode.getStudent());
            node.setLeftNode(Remove(node.getLeftNode(), tempnode.getStudent()));
        }

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

 
        this.sequence.removeAll(this.sequence);
        SortedSequence(node);
        return BalanceAfterRemoval(node);

    }
	
	/**
	 * This method is used to verify the method after removal.
	 * @param node root of the 
	 * @return
	 */

	/**
	 * This is the method to verify  the balance after removal .
	 * @param node node that we are going to verify the balance for .
	 * @return
	 */
	private MyNode BalanceAfterRemoval(MyNode node) {
		int balance = getBalance(node);

		
		if (balance > 1) {

			
			if (getBalance(node.getLeftNode()) < 0) {

				node.setLeftNode(LeftRotation(node.getLeftNode()));
			}

			return RightRotation(node);
		}
	
		if (balance < -1) {
			
			if (getBalance(node.getRightNode()) > 0) {

				node.setRightNode(RightRotation(node.getRightNode()));
			}

			
			return LeftRotation(node);

		}
		return node;
	}
	
	/**
	 * This method will find the ancestor of a node.
	 * @param node Node to be verified.
	 * @return
	 */

	public MyNode getAncestor(MyNode node) {

		MyNode ancesstor = node;

		while (ancesstor.getRightNode() != null)
			ancesstor = ancesstor.getRightNode();

		return ancesstor;

	}

	/**
	 * This method will return the next value of the student.
	 * @param key
	 * @return
	 */
	public Student next(long key) {

		Student prec = FindNextValue(root, null, key);
		return prec;

	}
	 /**
	  * This method allows  you to find the previous value of  node having that key.
	  * @param key returns the node holding  that  key.
	  * @return
	  */

	public Student Previous(long key) {

		MyNode prec = FindPreviousValue(root, null, key);
		return prec.getStudent();

	}

	/**
	 * This method allows us to calculate the range of a key. 
	 * 
	 * @param key1 This the first key to be verified
	 * @param key2 This is the second key to be verified
	 * @return
	 */
	public int CalculateRange(long key1, long key2) {
		MyNode node = this.root;
		inOrderTraversal2(node, key1 ,key2);

		return this.NumberOfKeys;

	}


}
