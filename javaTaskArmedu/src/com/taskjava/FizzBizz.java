//- Write a program to print numbers from 1 to 100
//- For multiples of 3 print "Fizz" instead of number 
//- For multiples of 5 print "Buzz"
//- For multiples of both 3 and 5 print "FizzBuzz"
//- Have a main method calling a separate fizzBuzz() method
//- Unit test the fizzBuzz() method by passing different values and validating output
//- Handle invalid input cases

package com.taskjava;

public class FizzBizz {
	
	public static void fizzBzz() {
		for (int i = 1; i <=100; i++) {
			if(i%3==0 && i%5==0)
			{System.out.println("FizzBuzz");}
			else if(i%5 ==0) {System.out.println("Buzz");}
			else if(i%3 ==0) {System.out.println("Fizz");}
			else System.out.println(i);
		}
	}

	public static void main(String[] args) {
		fizzBzz();
	

	}

}
