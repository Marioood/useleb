import java.util.Hashtable;

public class Main {
	private static Hashtable<String, String> additionTable;
	
	public static void main(String[] args) {
		//least verbose java code
		//Hashtable<Character, Hashtable<Character, Character>> additionTable = new Hashtable<Character, Hashtable<Character, Character>>();
		//keys are xy (ex: 31, 43), which is both opperands concatenated
		additionTable = new Hashtable<String, String>();
		//comput addition table
		for(int opp0 = 0; opp0 <= 9; opp0++) {
			for(int opp1 = 0; opp1 <= 9; opp1++) {
				String key = Integer.toString(opp0) + Integer.toString(opp1);
				String value = Integer.toString(opp0 + opp1);
				additionTable.put(key, value);
			}
		}
		
		System.out.println(stringAdd("3", "12"));
		System.out.println(stringAdd("3", "122"));
		System.out.println(stringAdd("2", "99"));
		System.out.println(stringAdd("209", "8"));
		System.out.println(stringAdd("9999999", "1"));
	}
	
	public static String stringAdd(String opp0, String opp1) {
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
		//int lengthDif = ;
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
					//create key
					//offset used for the reversed index reading
					String key = "" + oppLong.charAt(i) + oppShort.charAt(i - (oppLongLen - oppShortLen));
					String sumPart = additionTable.get(key);
					//return if the value is invalid
					if(sumPart == null) {
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
						oppShort = stringAdd(oppShort, carryRecursive);
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
}