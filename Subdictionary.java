//-------------------------------------------------------------------------------------
// 
// Part: 1
// Written by: Uzair Ali 
//-------------------------------------------------------------------------------------

package part1;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/*This program takes any input file which contains a paragraph and collects the words in alphabetical order without any repetition of words in an output file.
 * @author Uzair Ali
 * */

public class Subdictionary {
	static Scanner in = new Scanner(System.in);

	/*
	 * method with three parameters with is used to store words in output file
	 * 
	 * @param a is character
	 * 
	 * @param ArrayList<String>array is an array list
	 * 
	 * @param p is output file
	 */
	private static void copyee(char a, ArrayList<String> array, PrintWriter p) {
		for (int r = 0; r < array.size(); r++) {
			String g = array.get(r);
			if (g.charAt(0) == a) {
				p.println(g);
			}

		}

	}

	/*
	 * This method sorts array list in an alphabetical order
	 * 
	 * @param x is an arraylist
	 */
	public static void sort(ArrayList<String> x) {
		String temp;
		for (int i = 0; i < x.size(); i++) {
			for (int j = i + 1; j < x.size(); j++) {
				if (x.get(i).compareToIgnoreCase(x.get(j)) > 0) {
					temp = x.get(i);
					x.set(i, x.get(j));
					x.set(j, temp);
				}
			}
		}
	}

	/* this is the main method */
	public static void main(String[] args) {
		System.out.println("Hello there!!");
		System.out.println("Please enter input file name: ");
		String inputfile = in.next();
		PrintWriter pw = null;
		Scanner sc = null;
		try {
			pw = new PrintWriter(new FileOutputStream("SubDictionary.txt"));
			sc = new Scanner(new FileInputStream(inputfile));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!");

		}
		ArrayList<String> a1 = new ArrayList<String>();
		String s;
		/* This loop add each word to an array list in upper case */
		while (sc.hasNext()) {
			s = sc.next();
			a1.add(s.toUpperCase());

		}
		/*
		 * This loop checks each word so that it does not contain any number, removes
		 * any punctuation marks
		 */
		for (int x = 0; x < a1.size(); x++) {
			String a;
			a = a1.get(x);
			for (int p = 0; p < a.length(); p++) {
				if (a.charAt(p) == '0' || a.charAt(p) == '1' || a.charAt(p) == '2' || a.charAt(p) == '3'
						|| a.charAt(p) == '4' || a.charAt(p) == '5' || a.charAt(p) == '6' || a.charAt(p) == '7'
						|| a.charAt(p) == '8' || a.charAt(p) == '9') {
					a1.remove(x);
				}
				if (a.charAt(p) == ',' || a.charAt(p) == '?' || a.charAt(p) == '!' || a.charAt(p) == '.'
						|| a.charAt(p) == ';' || a.charAt(p) == ':' || a.charAt(p) == '\'') {
					String c = a.substring(0, p);
					a1.set(x, c);
				}
				if (a.charAt(p) == '=') {
					a1.remove(x);
				}
				if (a.length() == 1 && a.charAt(0) != 'A' && a.charAt(0) != 'I') {
					a1.remove(x);
				}
				// if(a.length()==1&&a.charAt(0)!='A'||a.length()==1&&a.charAt(0)!='I') {
				// a1.remove(x);
				// }

			}
		}
		/* This loops removes any duplicate words */
		for (int m = 0; m < a1.size(); m++) {
			for (int k = m + 1; k < a1.size(); k++) {
				String a, g;
				a = a1.get(m);
				g = a1.get(k);
				if (a.equalsIgnoreCase(g)) {
					a1.remove(k);
				}

			}
		}

		/* And finally after sorting each word is added in output file */
Subdictionary.sort(a1);
		pw.println("The document produced this sub-dictionary, which includes " + a1.size() + " entries.");
		for (char hello = 'A'; hello <= 'Z'; hello++) {
			pw.println(hello + "\n==");
			copyee(hello, a1, pw);
			pw.println();
		}
		pw.close();
		System.out.println("Output file name SubDictionary.txt is created and you can check it now.");
		System.out.println("Thankyou for using!");
		

	}
}
