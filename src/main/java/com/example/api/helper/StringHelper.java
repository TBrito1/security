package com.example.api.helper;

public class StringHelper {

	public static boolean isBlankOrNull(String str) {
		if(str == null || str.equals("") || str.equals(" ") )
			return true;
		else
			return false;
	}

}
