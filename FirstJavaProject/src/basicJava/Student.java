package basicJava;

public class Student {

	String name;
	int roll_no;
	
	
	Student ()
	{	
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student std = new Student();
		std.name = "john";
		std.roll_no = 2;
		
		System.out.println("student name:"+std.name+" Student roll_no:"+std.roll_no);

	}

}
