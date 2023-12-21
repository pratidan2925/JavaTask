package com.task;



	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;

	public class SimpleFileReader {

	    public static void main(String[] args) {
	        String filePath = "path/to/your/file.txt";

	        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                // Split line on comma to get values
	                String[] values = line.split(",");

	                try {
	                    // Store values into appropriate data types
	                    int intValue = Integer.parseInt(values[0]);
	                    double doubleValue = Double.parseDouble(values[1]);
	                    String stringValue = values[2];

	                    // Use the values as needed
	                    System.out.println("Integer: " + intValue + ", Double: " + doubleValue + ", String: " + stringValue);
	                } catch (Exception e) {
	                    // Catch exceptions for invalid data
	                    System.err.println("Error parsing values: " + line);
	                }
	            }
	        } catch (IOException e) {
	            // Catch exceptions for file-related issues
	            System.err.println("Error reading the file: " + filePath);
	        }
	    }
	}



