package com.Maven.Demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;

public class FutureDate {
    WebDriver  driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	System.out.println("Hi");
    	Calendar calculate = Calendar.getInstance();
    	calculate.add(Calendar.DATE,15);
		Date futuredate =calculate.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");
		 String stringFutureDate = sdf.format(futuredate);
	      System.out.println("Current Date = "+stringFutureDate);
	      String[] SplitFuturedate = stringFutureDate.split("/");
	      
/*	      for (String s: stringDate) {
	    	  System.out.println("Split String is "+s);
	      }
*/
	}

}
