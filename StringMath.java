public class StringMath {
	public static String add(String opp0, String opp1) {
		//adds two numberic strings together without converting them into another type
		//ex: "1" + "1" = "2"
		String oppLong, oppShort;
		
		if(opp0.length() > opp1.length()) {
			oppLong = opp0;
			oppShort = opp1;
		} else {
			oppLong = opp1;
			oppShort = opp0;
		}
		int oppLongLen = oppLong.length();
		int oppShortLen = oppShort.length();
		String output = "";
		String carry = "";
		boolean carrying = false;
		//read the string in reverse cause the ones is at the end
		for(int i = oppLongLen - 1; i >= 0; i--) {
			if(i >= oppLongLen - oppShortLen) {
				if(carrying) {
					output = carry + output;
					carrying = false;
				} else {
					//offset used for the reversed index reading
					String sumPart = StringMath.addDigit(oppLong.charAt(i), oppShort.charAt(i - (oppLongLen - oppShortLen)));
					//return if the value is invalid
					if(sumPart.equals("")) {
						return "NaN";
					}
					
					if(sumPart.length() > 1) {
						output = sumPart.charAt(1) + output;
						String carryRecursive = sumPart.charAt(0) + "0";
						//append zeros to the carry thing
						for(int append = 1; append < oppLongLen - i; append++) {
							carryRecursive += "0";
						}
						//do recursively
						oppShort = StringMath.add(oppShort, carryRecursive);
						int oldOppShortLen = oppShortLen;
						oppShortLen = oppShort.length();
						carry = "";
						//what is this for? i forgot
						if(oldOppShortLen == oppShortLen || i == 0) {
							carry += sumPart.charAt(0);
						}
						i++; //go back in the "number"
						carrying = true;
					} else {
						output = sumPart + output;
					}
				}
			} else {
				output = oppLong.charAt(i) + output;
			}
		}
		
		return output;
	}
	
	private static String addDigit(char opp0, char opp1) {
		//script for constructing this table
		//i aint writing allat by hand
		/*
		String output = "switch(opp0) {\n";
		for(int opp0 = 1; opp0 <= 9; opp0++) {
			output += "\tcase \'" + opp0 + "\':\n";
				output += "\t\tswitch(opp1) {\n";
			for(int opp1 = 1; opp1 <= 9; opp1++) {
				output += "\t\t\tcase \'" + opp1 + "\':\n";
				output += "\t\t\t\treturn \"" + Integer.toString(opp0 + opp1) + "\";\n";
			}
			output += "\t\t}\n";
		}
		output += "}";
		System.out.println(output);
		*/
		//dont bother an opperand is zero
		if(opp0 == '0') {
			return "" + opp1;
		} else if(opp1 == '0') {
			return "" + opp0;
		}
		
		switch(opp0) {
			case '1':
				switch(opp1) {
					case '1':
						return "2";
					case '2':
						return "3";
					case '3':
						return "4";
					case '4':
						return "5";
					case '5':
						return "6";
					case '6':
						return "7";
					case '7':
						return "8";
					case '8':
						return "9";
					case '9':
						return "10";
				}
			case '2':
				switch(opp1) {
					case '1':
						return "3";
					case '2':
						return "4";
					case '3':
						return "5";
					case '4':
						return "6";
					case '5':
						return "7";
					case '6':
						return "8";
					case '7':
						return "9";
					case '8':
						return "10";
					case '9':
						return "11";
				}
			case '3':
				switch(opp1) {
					case '1':
						return "4";
					case '2':
						return "5";
					case '3':
						return "6";
					case '4':
						return "7";
					case '5':
						return "8";
					case '6':
						return "9";
					case '7':
						return "10";
					case '8':
						return "11";
					case '9':
						return "12";
				}
			case '4':
				switch(opp1) {
					case '1':
						return "5";
					case '2':
						return "6";
					case '3':
						return "7";
					case '4':
						return "8";
					case '5':
						return "9";
					case '6':
						return "10";
					case '7':
						return "11";
					case '8':
						return "12";
					case '9':
						return "13";
				}
			case '5':
				switch(opp1) {
					case '1':
						return "6";
					case '2':
						return "7";
					case '3':
						return "8";
					case '4':
						return "9";
					case '5':
						return "10";
					case '6':
						return "11";
					case '7':
						return "12";
					case '8':
						return "13";
					case '9':
						return "14";
				}
			case '6':
				switch(opp1) {
					case '1':
						return "7";
					case '2':
						return "8";
					case '3':
						return "9";
					case '4':
						return "10";
					case '5':
						return "11";
					case '6':
						return "12";
					case '7':
						return "13";
					case '8':
						return "14";
					case '9':
						return "15";
				}
			case '7':
				switch(opp1) {
					case '1':
						return "8";
					case '2':
						return "9";
					case '3':
						return "10";
					case '4':
						return "11";
					case '5':
						return "12";
					case '6':
						return "13";
					case '7':
						return "14";
					case '8':
						return "15";
					case '9':
						return "16";
				}
			case '8':
				switch(opp1) {
					case '1':
						return "9";
					case '2':
						return "10";
					case '3':
						return "11";
					case '4':
						return "12";
					case '5':
						return "13";
					case '6':
						return "14";
					case '7':
						return "15";
					case '8':
						return "16";
					case '9':
						return "17";
				}
			case '9':
				switch(opp1) {
					case '1':
						return "10";
					case '2':
						return "11";
					case '3':
						return "12";
					case '4':
						return "13";
					case '5':
						return "14";
					case '6':
						return "15";
					case '7':
						return "16";
					case '8':
						return "17";
					case '9':
						return "18";
				}
		}
		
		return "";
	}
}