package basicJava;
import java.util.Scanner;

public class Larger3Numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =new Scanner (System.in);
		System.out.println("Eneter three numbers :");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if (a>b && a>c){
			System.out.println(a+" is larger than "+b+" and " +c);
		}
		
		else if (b>a && b>c) {
			System.out.println(b+" is larger than "+a+" and " +c);
		}
		else {
			System.out.println(c+" is larger than "+a+" and " +b);
			
		}
		
    sc.close();
	}

}
