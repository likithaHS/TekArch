package Hackathon;

import java.util.Scanner;

public class Question30 {

	public static String largestP(String word) {
		String hold = "", pal = "";
		// StringBuilder sb;
		int len = 0;
		for (int i = 0; i < word.length(); i++) {
			for (int j = i + 1; j < word.length(); j++) {
				hold = word.substring(i, j);
				if (new StringBuilder(hold).reverse().toString().equals(hold) && hold.length() > len
						&& hold.length() > 2) {
					pal = hold;
					len = pal.length();
				}
			}
		}
		return pal;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Eneter the String ");
		// String word = "dadymmommlovemom";
		String word = sc.nextLine();
		System.out.println("Input string is :" + word);
		String result = largestP(word);
		System.out.println("Largest palindrome in the given strng is:" + result);
		sc.close();
	}

}
