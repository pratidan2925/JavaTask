//- Take a sentence as input from user
//- Split the sentence into words 
//- Iterate over the words and reverse each word using StringBuilder
//- Accumulate the reversed words into another StringBuilder separated by space
//- Print out final reversed sentence
//- Write JUnit tests to validate below cases:
//  - empty string
//  - string with one word
//  - string with multiple words
//  - string with special characters


package com.taskjava;

import java.util.Scanner;




public class ReverseString {
	
	
	public static String reverseString(String s) {
if(s == null || s.trim().isEmpty()) {
	return "";
}	
	String[] words = s.split(" ");
	StringBuilder sb = new StringBuilder();
	
	for (String word : words) {
		sb.append(new StringBuilder(word).reverse()).append(" ");
	}
	return sb.toString().trim();

	
}

	
	

	public static void main(String[] args) {
		System.out.println("Enter the Sentence = ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		

    String reverse = reverseString(s);
    System.out.println(reverse);
		
      
	}
		
}
		
  
	

