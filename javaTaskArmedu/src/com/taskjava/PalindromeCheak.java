//Accept a string as input from the user
//Check if the string is equal to its reverse (e.g. rotor = rotors) 
//Create a recursive method isPalindrome() which adds both end characters one by one to build the reverse string 
// Method returns true if original and new string match else false
//Write test cases to check for odd/even length strings, base cases



package com.taskjava;

import java.util.Scanner;



public class PalindromeCheak {
	
	public static boolean isPalindrome(String s) {
		String reverse = "";
	
		for (int i = s.length()-1; i >=0; i--) {
			reverse += s.charAt(i);
		//	System.out.println(reverse);
		}
		if(s.equals(reverse)) {return true ;}
		else
		return false;
	 }
	
	public static void isLenEvenOdd(String s) {
		int len = s.length();
		if(len%2==0) {System.out.println("Length of the given string is Even");}
		else {System.out.println("Length of the given string id Odd");}
	}
	
	

	public static void main(String[] args) {
		System.out.println("Enter the String = ");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(isPalindrome(s));
		isLenEvenOdd(s);
		sc.close();

	}

}
