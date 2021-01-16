package Assignment4;

public class MyNode {

	private Student student;
	private MyNode leftNode;

	private MyNode rightNode;

	private int height;

	public MyNode(Student s) {

		this.student = s;

	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public MyNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(MyNode leftNode) {
		this.leftNode = leftNode;
	}

	public MyNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(MyNode rightNode) {
		this.rightNode = rightNode;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;

	}

	@Override
	public String toString() {
		return "[student=" + student + "]";
	}
	
	
	
	
	
	
	
	
	
}
