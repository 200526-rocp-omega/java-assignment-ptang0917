package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random; 
public class EvaluationService {

	/**
	 * 1.A Speed Converter - Convert to MilesPerHour
	 * 
	 * Write a method called toMilesPerHour that has 1 parameter of type double with
	 * the name kilometersPerHour. This method needs to return the rounded value of
	 * the calculation of type long.
	 * 
	 * If the parameter kilometersPerHour is less than 0, the method toMilesPerHour
	 * needs to return -1 to indicate an invalid value.
	 * 
	 * Otherwise if it is positive, calculate the value of miles per hour, round it
	 * and return it. For conversion and rounding use Math.round().
	 */
	static class SpeedConverter {

		public static long toMilesPerHour(double kilometersPerHour) {
			// TODO Write an implementation for this method declaration
			double milesPerHour = 0;
			long output = 0;
			long iPart;
			double fPart;
			if(kilometersPerHour < 0){
				output = -1;
				
			}
			else if(kilometersPerHour > 0){
				milesPerHour = kilometersPerHour * 0.62137;
				iPart = (long) milesPerHour;
				fPart = milesPerHour - iPart;
				if(fPart > 0 && fPart < 0.5) {
					output = iPart;
				}
				else if(fPart > 0.5 && fPart <= 0.99d){
					output = iPart+1;
				}
				
			}
			//System.out.println(kilometersPerHour + " " + output);

			
			return output;
		}

		/**
		 * 1.B Speed Converter - Print Conversion
		 * 
		 * Write another method called printConversion with 1 parameter of type double
		 * with the name kilometersPerHour. This method needs to return a String and
		 * needs to calculate milesPerHour from the kilometersPerHour parameter.
		 * 
		 * The String should print in the format: "XX km/h = YY mi/h"
		 * 
		 * XX represents the original value kilometersPerHour. YY represents the rounded
		 * milesPerHour from the kilometersPerHour parameter.
		 * 
		 * If the parameter kilometersPerHour is < 0, then print the text "Invalid
		 * Value"
		 */
		public static String printConversion(double kilometersPerHour) {
			// TODO Write an implementation for this method declaration
			String result;
			double milesPerHour;
			long iPart;
			double fPart;
			long output = 0;
			if(kilometersPerHour < 0) {
				result = "Invalid Value";
			}
			else {
				milesPerHour = 0.62137 * kilometersPerHour;
				iPart = (long) milesPerHour;
				fPart = milesPerHour - iPart;
				if(fPart > 0 && fPart < 0.5) {
					output = iPart;
				}
				else if(fPart > 0.5 && fPart <=0.99d) {
					output = iPart+1;
				}
				result = Double.toString(kilometersPerHour) + " km/h"  + " = " + Long.toString(output) + " mi/h";				
			}

			return result;
		}
	}

	/**
	 * 2. MegaBytes and KiloBytes
	 * 
	 * Write a method called printMegaBytesAndKiloBytes that has 1 parameter of type
	 * int with the name kiloBytes.
	 * 
	 * The method should return a String and it needs to calculate the megabytes and
	 * remaining kilobytes from the kilobytes parameter.
	 * 
	 * Then it needs to print a message in the format "XX KB = YY MB and ZZ KB".
	 * 
	 * XX represents the original value kiloBytes. YY represents the calculated
	 * megabytes. ZZ represents the calculated remaining kilobytes.
	 * 
	 * For examples, when the parameter kiloBytes is 2500 it needs to print "2500 KB
	 * = 2 MB and 452 KB"
	 * 
	 * If the parameter kiloBytes is less than 0 then print the text "Invalid
	 * Value".
	 */
	public String printMegaBytesAndKiloBytes(int XX) {
		// TODO Write an implementation for this method declaration
		int YY = 0;
		int ZZ = 0;
		String result;
		if(XX < 0) {
			result = "Invalid Value";
		}
		else {
			YY = XX / 1024;
			//System.out.println(YY);
			ZZ = XX % 1024;
			//System.out.println(ZZ);
			result = Integer.toString(XX) + " KB " + "= " + Integer.toString(YY) + " MB " + "and " + Integer.toString(ZZ) + " KB";
		}
		//System.out.println(result);

		
		
		

		return result;
	}

	/**
	 * 3. Barking Dog
	 * 
	 * We have a dog that loves to bark. We need to wake up if the dog is barking at
	 * night!
	 * 
	 * Write a method shouldWakeUp that has 2 parameters.
	 * 
	 * 1st parameter should be of type boolean and be named "barking". It represents
	 * if our dog is currently barking. 2nd parameter represents the hour of the day
	 * and is of type int with the name hourOfDay and has a valid range of 0-23.
	 * 
	 * We have to wake up if the dog is barking before 8 or after 22 hours, so in
	 * that case return true.
	 * 
	 * In all other cases return false.
	 * 
	 * If the hourOfDay parameter is less than 0 or greater than 23, return false.
	 */
	public boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
		// TODO Write an implementation for this method declaration
		boolean wakeUp = false;
		if(hourOfDay < 0 || hourOfDay > 23) {
			wakeUp = false;
		}
		else if(hourOfDay < 8 || hourOfDay > 22) {
			if(isBarking == true) {
				wakeUp = true;
			}
			else if(isBarking == false) {
				wakeUp = false;
			}
		}
		else {
			wakeUp = false;
		}
		return wakeUp;
	}

	/**
	 * 4. DecimalComparator
	 * 
	 * Write a method areEqualByThreeDecimalPlaces with two parameters of type
	 * double.
	 * 
	 * The method should return boolean and it needs to return true if two double
	 * numbers are the same up to three decimal places.
	 * 
	 * Otherwise, return false;
	 */
	public boolean areEqualByThreeDecimalPlaces(double firstNum, double secondNum) {
		// TODO Write an implementation for this method declaration
		boolean matches = false;
		String firstDec = Double.toString(firstNum);
		String secondDec = Double.toString(secondNum);
		int charcount = 0;
		if(firstNum == secondNum) {
			matches = true;
		}
		else {
			if(firstDec.length() > secondDec.length()) {
				for(int i =0; i < secondDec.length(); i++) {
					if(firstDec.charAt(i) == secondDec.charAt(i)) {
						charcount++;
					}
				}
			}
			else if(firstDec.length() < secondDec.length()) {
				for(int i =0; i < firstDec.length(); i++) {
					if(firstDec.charAt(i) == secondDec.charAt(i)) {
						charcount++;
					}
				}
			}
			if(charcount >= 4) {
				matches = true;
			}
			else {
				matches = false;
			}
		}

		return matches;
	}

	/**
	 * 5. Teen Number Checker
	 * 
	 * We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
	 * Write a method named hasTeen with 3 parameters of type int.
	 * 
	 * The method should return boolean and it needs to return true if ONE of the
	 * parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return
	 * false.
	 */
	static class TeenNumberChecker {

		public static boolean hasTeen(int x, int y, int z) {
			// TODO Write an implementation for this method declaration
			int TeenageCount =0;
			if(x >= 13 && x <= 19) {
				TeenageCount++;
			}
			if(y >= 13 && y <= 19) {
				TeenageCount++;
			}
			if(z >= 13 && z <= 19) {
				TeenageCount++;
			}
			if(TeenageCount >= 1) {
				return true;
			}
			else {
				return false;
			}
			
		}

		// We can initialize isTeen method first
		// Then pass the parameter to hasTeen method

		public static boolean isTeen(int number) {
			// TODO Write an implementation for this method declaration
			if(number >= 13 && number <= 19) {
				return true;
			}
			else {
				return false;
			}
			
		}
	}

	/**
	 * 6. Minutes To Years and Days Calculator
	 * 
	 * Write a method printYearsAndDays with parameter of type long named minutes.
	 * The method should not return anything (void) and it needs to calculate the
	 * years and days from the minutes parameter.
	 * 
	 * If the parameter is less than 0, print text "Invalid Value".
	 * 
	 * Otherwise, if the parameter is valid then it needs to print a message in the
	 * format "XX min = YY y and ZZ d".
	 * 
	 * XX represents the original value minutes. YY represents the calculated years.
	 * ZZ represents the calculated days.
	 */
	public String printYearsAndDays(long minutes) {
		// TODO Write an implementation for this method declaration
		long years;
		long days;
		String result;
		years = minutes / 525600;
		days = (minutes % 525600) / (60*24);

		result = Long.toString(minutes) + " min" + " = " + Long.toString(years) + " y " + "and " + Long.toString(days) + " d";
		//System.out.println(result);
		return result;
	}

	/**
	 * 7. Number In Word
	 * 
	 * Write a method called printNumberInWord. The method has one parameter number
	 * which is the whole number. The method needs to print "ZERO", "ONE", "TWO",
	 * ... "NINE", "OTHER" if the int parameter number is 0, 1, 2, .... 9 or other
	 * for any other number including negative numbers. You can use if-else
	 * statement or switch statement whatever is easier for you.
	 */
	public String printNumberInWord(int number) {
		// TODO Write an implementation for this method declaration
		String numberWord = null;
		switch(number) {
			case 0:
				numberWord = "ZERO";
				break;
			case 1:
				numberWord = "ONE";
				break;
			case 2:
				numberWord = "TWO";
				break;
			case 3:
				numberWord = "THREE";
				break;
			case 4:
				numberWord = "FOUR";
				break;
			case 5:
				numberWord = "FIVE";
				break;
			case 6:
				numberWord = "SIX";
				break;
			case 7:
				numberWord = "SEVEN";
				break;
			case 8:
				numberWord = "EIGHT";
				break;
			case 9:
				numberWord = "NINE";
			default:
				numberWord = "OTHER";
				
		}
		return numberWord;
	}

	/**
	 * 8. Greatest Common Divisor
	 * 
	 * Write a method named getGreatestCommonDivisor with two parameters of type int
	 * named first and second.
	 * 
	 * If one of the parameters is < 10, the method should return -1 to indicate an
	 * invalid value. The method should return the greatest common divisor of the
	 * two numbers (int).
	 * 
	 * The greatest common divisor is the largest positive integer that can fully
	 * divide each of the integers (i.e. without leaving a remainder).
	 * 
	 * For example 12 and 30: 12 can be divided by 1, 2, 3, 4, 6, 12 30 can be
	 * divided by 1, 2, 3, 5, 6, 10, 15, 30
	 * 
	 * The greatest common divisor is 6 since both 12 and 30 can be divided by 6,
	 * and there is no resulting remainder.
	 */
	
	
	public int getGreatestCommonDivisor(int first, int second) {
		// TODO Write an implementation for this method declaration
		int GCD = 0;
		boolean found = false;
		ArrayList<Integer> firstDivisor = new ArrayList<Integer>();
		ArrayList<Integer> secondDivisor = new ArrayList<Integer>();
		if(first < 10 || second < 10) {
			GCD = -1;
		}
		else {
			for(int i = 1; i <= first; i++) {
				if(first % i == 0) {
					firstDivisor.add(i);
				}
			}
			for(int i = 1; i <= second; i++) {
				if(second % i ==0) {
					secondDivisor.add(i);
				}
			}
			
//			for(Integer i: firstDivisor) {
//				System.out.println(i);
//			}
//			for(Integer i: secondDivisor) {
//				System.out.println(i);
//			}
			
			if(firstDivisor.size() >= secondDivisor.size()) {
				GCD = firstDivisor.get(0);
				for(int i =0; i < firstDivisor.size(); i++) {
					for(int j =0; j < secondDivisor.size(); j++) {
						if(secondDivisor.get(j)==firstDivisor.get(i)) {
							found = true;
							break;
						}
					}
					if(found == true) {
						if(firstDivisor.get(i) >= GCD) {
							GCD = firstDivisor.get(i);
						}
					}
					found = false;
					
				}
			}
			else if(secondDivisor.size() >= firstDivisor.size()) {
				GCD = secondDivisor.get(0);
				for(int i =0; i < secondDivisor.size(); i++) {
					for(int j =0; j < firstDivisor.size(); j++) {
						if(firstDivisor.get(j)==secondDivisor.get(i)) {
							found = true;
							break;
						}
					}
					if(found == true) {
						if(secondDivisor.get(i) >= GCD) {
							GCD = secondDivisor.get(i);
						}
					}
					found = false;
					
				}
			}

			
		}
		//System.out.println(GCD);
		return GCD;
	}

	/**
	 * 9. First and Last Digit Sum
	 * 
	 * Write a method named sumFirstAndLastDigit with one parameter of type int
	 * called number.
	 * 
	 * The method needs to find the first and the last digit of the parameter number
	 * passed to the method, using a loop and return the sum of the first and the
	 * last digit of that number.
	 * 
	 * If the number is negative then the method needs to return -1 to indicate an
	 * invalid value.
	 */
	public int sumFirstAndLastDigit(int num) {
		// TODO Write an implementation for this method declaration
		int sum;
		int firstDigit = 0;
		int lastDigit = 0;
		int size;
		int num2;
		String num_string;
		if(num < 0) {
			sum = -1;
		}
		else {
			num_string = Integer.toString(num);
			size = num_string.length()-1;
			firstDigit = (int)(num / (Math.pow(10, size)));
			while(num > 10) {
				num2 = (int)(num / (Math.pow(10, size)));
				num = num % (int)(num2 * (Math.pow(10, size)));;
				//System.out.println(num);
				size--;
				
			}
			lastDigit = num;
			//System.out.println(firstDigit);
			//System.out.println(lastDigit);
			sum = firstDigit+lastDigit;
			//System.out.println(sum);
		}
		



//		firstDigit = (int) (num / (Math.pow(10, size)));
//		num = (int)(num / (Math.pow(10, size)));
//		firstDigit = num;


		
		return sum;
	}

	/**
	 * 10. Reverse String
	 * 
	 * Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 */
	public String reverse(String string) {
		// TODO Write an implementation for this method declaration
		String result = "";
		int indexCount = string.length()-1;
		
		while(indexCount > -1) {
//			result += string.charAt(indexCount);
			char character = string.charAt(indexCount);
			//System.out.println(character);
			result = result + character;
			indexCount--;
		}
		
		//System.out.println(result);
		return result;

	}

	/**
	 * 11. Acronyms
	 * 
	 * Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String acronymString = "";
		for(int i = 0; i < phrase.length(); i++) {
			if(i == 0) {
				if(Character.isUpperCase(phrase.charAt(i))) {
					acronymString = acronymString + phrase.charAt(i);
				}
			}
			else if(i > 0){
				if(Character.isUpperCase(phrase.charAt(i)) && phrase.charAt(i-1) == ' ') {
					acronymString = acronymString + phrase.charAt(i);
				}
				else if(Character.isLowerCase(phrase.charAt(i)) && phrase.charAt(i-1) == ' ') {
					acronymString = acronymString + Character.toUpperCase(phrase.charAt(i));
				}
				else if(Character.isLowerCase(phrase.charAt(i)) && phrase.charAt(i-1) == '-') {
					acronymString = acronymString + Character.toUpperCase(phrase.charAt(i));
				}
			}

		}
		//System.out.println(acronymString);
		
		
		
		return acronymString;
	}

	/**
	 * 12. Triangles
	 * 
	 * Determine if a triangle is equilateral, isosceles, or scalene. An equilateral
	 * triangle has all three sides the same length. An isosceles triangle has at
	 * least two sides the same length.
	 * 
	 * (It is sometimes specified as having exactly two sides the same length, but
	 * for the purposes of this exercise we'll say at least two.) A scalene triangle
	 * has all sides of different lengths.
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			if(sideOne == sideTwo && sideOne == sideThree && sideTwo == sideThree) {
				return true;
			}
			return false;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if(sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree) {
				return true;
			}
			return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if(sideOne != sideTwo && sideTwo != sideThree && sideOne != sideThree) {
				return true;
			}
			return false;
		}

	}

	/**
	 * 13. Scrabble Score
	 * 
	 * Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		Hashtable<Character, Integer> letterBank = new Hashtable<Character, Integer>();
		letterBank.put('A', 1);
		letterBank.put('B', 3);
		letterBank.put('C', 3);
		letterBank.put('D', 2);
		letterBank.put('E', 1);
		letterBank.put('F', 4);
		letterBank.put('G', 2);
		letterBank.put('H', 4);
		letterBank.put('I', 1);
		letterBank.put('J', 8);
		letterBank.put('K', 5);
		letterBank.put('L', 1);
		letterBank.put('M', 3);
		letterBank.put('N', 1);
		letterBank.put('O', 1);
		letterBank.put('P', 3);
		letterBank.put('Q', 10);
		letterBank.put('R', 1);
		letterBank.put('S', 1);
		letterBank.put('T', 1);
		letterBank.put('U', 1);
		letterBank.put('V', 4);
		letterBank.put('W', 4);
		letterBank.put('X', 8);
		letterBank.put('Y', 4);
		letterBank.put('Z', 10);
		int score = 0;
		char upperCase;
		for(int i =0; i < string.length(); i++) {
			if(Character.isLowerCase(string.charAt(i))){
				upperCase = Character.toUpperCase(string.charAt(i));
				score += letterBank.get(upperCase);
			}
			else {
				score += letterBank.get(string.charAt(i));
			}
		}
		//System.out.println(score);
		return score;
	}

	/**
	 * 14. Clean the Phone Number
	 * 
	 * Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		String newNumber = ""; 
		for(int i =0; i < string.length(); i++) {
			if(Character.isDigit(string.charAt(i))) {
				newNumber = newNumber + string.charAt(i);
			}
		}
		//System.out.println(newNumber);
		if(newNumber.length() == 10) {
			return newNumber;
		}
		else {
			throw new IllegalArgumentException("number must contain only 10 digits");
		}
		
		
	}

	/**
	 * 15. Recurring Word Counter
	 * 
	 * Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		String foundword = "";
		string = string.replaceAll("\n","");
		Map<String, Integer> WordCountMap = new HashMap<>();
		List<String> stringList = new ArrayList<String>();
		for(int i = 0; i < string.length(); i++) {
			//System.out.println(string.charAt(i));
			
			if(string.charAt(i) == ' ') {
				stringList.add(foundword);
				foundword = "";
			}
			else if(string.charAt(i) == ',') {
				stringList.add(foundword);
				foundword = "";
			}
			
			else {
				foundword = foundword + string.charAt(i);
			}

		}
		
		stringList.add(foundword);
		
		for(String name: stringList) {
			if(WordCountMap.containsKey(name)) {
				//The frequencyMap already contains the count for this name;
				//So we want to increase that count by 1
				int currentCount = WordCountMap.get(name);
				WordCountMap.put(name, currentCount+1);
			}
			else {
				WordCountMap.put(name, 1); //Track the name with a count of 1 if we haven't seen it before
			}
		}
		
		
		
		return WordCountMap;
	}

	/**
	 * 16. Armstrong Number
	 * 
	 * An Armstrong number is a number that is the sum of its own digits each raised
	 * to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 */
	public boolean isArmstrongNumber(int input) {
		int size = Integer.toString(input).length();
		int sum = 0;
		int remainder;
		int num2;
		List<Integer> numList = new ArrayList<Integer>();
		String num_string = Integer.toString(input);
		for(int i =0; i < num_string.length(); i++) {
			char num_char = num_string.charAt(i);
			int chartonum = num_char - '0';
			numList.add(chartonum);
		}
		for(Integer i : numList) {
			//System.out.println(i);
			sum += (int)(Math.pow(i, size));
		}
		//System.out.println(sum);
		if(sum == input) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * 17. Prime Factors
	 * 
	 * Compute the prime factors of a given natural number. A prime number is only
	 * evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		List<Long> primeList = new ArrayList<Long>();
		//List<Long> divisorList = new ArrayList<Long>();
		for(long i = 2; i <= l; i++) {
			while(l % i == 0) {
				primeList.add(i);
				l = l / i; 
			}
		}

		return primeList;
	}

	/**
	 * 18. Calculate Nth Prime
	 * 
	 * Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 */
	public int calculateNthPrime(int k) {
		// TODO Write an implementation for this method declaration 
		int i =1;
		int testnum = 2;
		boolean isPrime = true; 
		if(k == 0) {
			throw new IllegalArgumentException("number cannot be 0 or 1");
		}
		while(i < k+1) {
			for(int j = 2; j < testnum; j++) {
				
				if(testnum % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime == true) {
				//System.out.println("test num" + " " + testnum);
				testnum++;
				i++;
			}
			else if(isPrime == false) {
				//System.out.println("composite" + " " + testnum);
				testnum++;
				isPrime = true;
			}
		}
		i--;
		testnum--;
		//System.out.println(i + " " + testnum);

		return testnum;
	}

	/**
	 * 19. Pangram
	 * 
	 * Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		Map<Character,Integer> alphabetmap = new HashMap<Character, Integer>();
		alphabetmap.put('a', 0);
		alphabetmap.put('b', 0);
		alphabetmap.put('c', 0);
		alphabetmap.put('d', 0);
		alphabetmap.put('e', 0);
		alphabetmap.put('f', 0);
		alphabetmap.put('g', 0);
		alphabetmap.put('h', 0);
		alphabetmap.put('i', 0);
		alphabetmap.put('j', 0);
		alphabetmap.put('k', 0);
		alphabetmap.put('l', 0);
		alphabetmap.put('m', 0);
		alphabetmap.put('n', 0);
		alphabetmap.put('o', 0);
		alphabetmap.put('p', 0);
		alphabetmap.put('q', 0);
		alphabetmap.put('r', 0);
		alphabetmap.put('s', 0);
		alphabetmap.put('t', 0);
		alphabetmap.put('u', 0);
		alphabetmap.put('v', 0);
		alphabetmap.put('w', 0);
		alphabetmap.put('x', 0);
		alphabetmap.put('y', 0);
		alphabetmap.put('z', 0);
		int count = 1;
		int sum = 0;
		for(int i =0; i < string.length(); i++) {
			if(Character.isUpperCase(string.charAt(i))) {
				Character.toLowerCase(string.charAt(i));
			}
			else if(!Character.isAlphabetic(string.charAt(i))) {
				continue;
			}
			if(alphabetmap.containsKey(string.charAt(i))) {
				if(alphabetmap.get(string.charAt(i)) == 0) {
					alphabetmap.put(string.charAt(i), count);
				}
				else {
					alphabetmap.put(string.charAt(i), count+1);
				}					
			}
		}
		for(Map.Entry<Character, Integer> iterator: alphabetmap.entrySet()) {
			if(iterator.getValue() > 0) {
				sum++;
			}
		}
		if(sum == 26) {
			return true;
		}
		else {
			return false;
		}
		

		
	}

	/**
	 * 20. Sum of Multiples 
	 * 
	 * Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 */
	public int getSumOfMultiples(int i, int[] set) {
		int min = set[0];
		int sum = 0;
		
		for(int k = 0; k < set.length; k++) {
			if(set[k] < min) {
				min = set[k];
			}
		}
		for(int x = min; x < i; x++) {
			boolean multiplefound = false;
			for(int y = 0; y < set.length; y++) {
				if(x % set[y] == 0) {
					multiplefound = true;
				}
			}
			if(multiplefound == true) {
				sum += x;
			}
			
		}
		//System.out.println(sum);
		return sum;
	}
	
	/**
	 * 21. Three Magic Numbers
	 * 
	 * You work at a casino in Las Vegas.  Your job is to program a slot machine to
	 * return 3 random numbers using the java.util.Random class.
	 * 
	 * Write a method to return an int array of 3 random numbers between 1 - 100.
	 * Generate the 3 random numbers (1 - 100 inclusive) using the java.util.Random class.
	 */
	
	public int[] threeLuckyNumbers() {
		int[] intArray = new int[3];
		Random rand = new Random(); 
		int rand_int1 = rand.nextInt(101);
		int rand_int2 = rand.nextInt(101);
		int rand_int3 = rand.nextInt(101);
		intArray[0] = rand_int1;
		intArray[1] = rand_int2;
		intArray[2] = rand_int3;
		
		
		
		return intArray;
	}
	
	/*
	 * 22. Easy Guessing Game
	 * 
	 * Create a program to generate a number between the given range:
	 * int x = minimum
	 * iny y = maximum (inclusive)
	 * 
	 * You must use the Math.random class to generate a random number between x and y.
	 */
	
	public int guessingGame(int x, int y) {
		Random rand = new Random();
		int random_number = (int)Math.random() * (x - y + 1) + x;
		return random_number;
	}
}
