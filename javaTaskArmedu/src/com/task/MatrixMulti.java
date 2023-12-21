package com.task;
import java.util.Random;
public class MatrixMulti {
	
	



	    public static void main(String[] args) {
	        int s = 250;
	        int[][] a = randMatrix(s, s);
	        int[][] b = randMatrix(s, s);

	        if (a[0].length != b.length) {
	            System.out.println("Invalid dimensions for multiplication.");
	            return;
	        }

	        long t1 = System.currentTimeMillis();
	        int[][] r1 = multNaive(a, b);
	        long t2 = System.currentTimeMillis();
	        System.out.println("Naive: " + (t2 - t1) / 1000.0 + "s");

	        long t3 = System.currentTimeMillis();
	        int[][] r2 = multStrassen(a, b);
	        long t4 = System.currentTimeMillis();
	        System.out.println("Strassen: " + (t4 - t3) / 1000.0 + "s");

	        if (verify(r1, r2)) {
	            System.out.println("Results match.");
	        } else {
	            System.out.println("Results do not match.");
	        }
	    }

	    private static int[][] randMatrix(int r, int c) {
	        int[][] m = new int[r][c];
	        Random rnd = new Random();
	        for (int i = 0; i < r; i++)
	            for (int j = 0; j < c; j++)
	                m[i][j] = rnd.nextInt(100);
	        return m;
	    }

	    private static int[][] multNaive(int[][] a, int[][] b) {
	        int ra = a.length, ca = a[0].length, cb = b[0].length;
	        int[][] c = new int[ra][cb];

	        for (int i = 0; i < ra; i++)
	            for (int j = 0; j < cb; j++)
	                for (int k = 0; k < ca; k++)
	                    c[i][j] += a[i][k] * b[k][j];

	        return c;
	    }

	    private static int[][] multStrassen(int[][] a, int[][] b) {
	        // Implement Strassen's algorithm here (placeholder)
	        // Returning a copy of a for demonstration purposes
	        return copy(a);
	    }

	    private static boolean verify(int[][] a, int[][] b) {
	        int r = a.length, c = a[0].length;

	        for (int i = 0; i < r; i++)
	            for (int j = 0; j < c; j++)
	                if (a[i][j] != b[i][j])
	                    return false;

	        return true;
	    }

	    private static int[][] copy(int[][] m) {
	        int r = m.length, c = m[0].length;
	        int[][] cp = new int[r][c];

	        for (int i = 0; i < r; i++)
	            System.arraycopy(m[i], 0, cp[i], 0, c);

	        return cp;
	    }
	}



