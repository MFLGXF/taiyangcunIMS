package com.cr.validator;

public class IsNumber {
	public static boolean isNumber(String number){
		boolean result=number.matches("[0-9]+");
		if(result == true){
			return true;
		}else{
			return false;
		}
		
	}
}
