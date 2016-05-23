package checkinput;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInput{
	public static boolean isNumber(String s){
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException nfe) {}
		return false;
	}
	
	public static boolean isCharacter(String s){
		try {
			Integer.parseInt(s);
			return false;
		} catch (NumberFormatException nfe) {}
		return true;
	}
	
	public static boolean isOnlyChar(String s){
		String expression = "^[a-zA-Z]*$";
        CharSequence inputStr = s;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches())
        {
             return true;
        }
        return false;
	}
	
	public static boolean isCheckDigit(String s,int digit){
		char[] name=s.toCharArray();
		if(name.length<=digit){
			System.out.println(s);
			return true;
		}
		
		return false;
	}
	
	public static boolean isValidEmail(String email){
		String regex="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		CharSequence inputString=email;
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(inputString);
		if(match.matches()) return true;
		
		return false;
	}
	
	public static boolean isValidGender(String gender){
		String regex= "^M(ale)?$|^m(ale)?$|^F(emale)?$|^f(emale)?$";
		CharSequence inputString=gender;
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(inputString);
		if(match.matches()) return true;
		
		return false;
	}
	
	public static boolean isPhoneNumber(String phoneNumber){
		String regex= "^[0-9]{10}$";
		CharSequence inputString=phoneNumber;
		Pattern pattern=Pattern.compile(regex);
		Matcher match=pattern.matcher(inputString);
		if(match.matches()){
			System.out.println(phoneNumber.split("-"));
			return true;
		}
		
		return false;
	}
	
	public static void TelephoneNumber(String aString){
        if(isPhoneNumber(aString)==true){
            StringTokenizer tokens = new StringTokenizer("-");
            int exchangeCode;
			int number,areaCode;
			if(tokens.countTokens()==3){
                areaCode = Integer.parseInt(tokens.nextToken());
                exchangeCode = Integer.parseInt(tokens.nextToken());
                number = Integer.parseInt(tokens.nextToken());
            }
            else if(tokens.countTokens()==2){
                exchangeCode = Integer.parseInt(tokens.nextToken());
                number = Integer.parseInt(tokens.nextToken());
            }
            else{
                //throw an excemption here
            }
        }

    }

	public static void main(String[] args) {
		System.out.println("Please input: ");
		Scanner in=new Scanner(System.in);
		String n=in.nextLine();
		System.out.println();
	}

}
