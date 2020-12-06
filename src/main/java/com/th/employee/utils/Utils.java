package com.th.employee.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Utils {
	public static String getMemberType(double salary) {
		String memberType = "";		
		if(salary>50000) memberType = Constant.MEMBER_PLATINUM;
		else if(salary>=30000||salary<=50000) memberType = Constant.MEMBER_GOLD;
		else if(salary<30000) memberType = Constant.MEMBER_SILVER;
		return memberType;
	}
	
	public static String getDate(String format) {
		LocalDateTime ldt = LocalDateTime.now().plusDays(1);
		DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern(format, Locale.ENGLISH);
		return formmat1.format(ldt);
	}
}
