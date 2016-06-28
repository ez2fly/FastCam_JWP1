package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	int add(String text) throws Exception {
		if (text == null || text.trim().isEmpty()) return 0;
		
		String[] arrText = SeperateText(text);
		return TotalSum(arrText);
	}
	
	
	String[] SeperateText(String text) throws Exception {
		if (text.indexOf("//")>=0 && text.indexOf("\n")>=0) {		// indexOf 를 contains 로 대체
			return SeperateTextCustom(text);
		}
		if (text.indexOf("\n")>=0){
			return SeperateTextBasic1(text);
		}
		if (text.indexOf(",") >= 0 || text.indexOf("|") >= 0 || text.indexOf(":") >= 0) {
			return SeperateTextBasic2(text);
		}
		String[] ret = new String[] {text};		// delimeter 가 없어도 정상적으로 되므로 이 코드는 필요 없다.
		return ret;
	}
	
	String[] SeperateTextBasic1(String text) throws Exception {
		return text.split(",|\n");
	}
	
	String[] SeperateTextBasic2(String text) throws Exception {
		return text.split(",|:");
	}
	
	String[] SeperateTextCustom(String text) throws Exception {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);		// 정규표현식
		m.find();																					// 이 함수의 리턴값으로 커스텀구분자 여부를 확인 가능함
		String customDelimeter = m.group(1);
		String[] tokens = m.group(2).split(customDelimeter);
		return tokens;
	}
	
	int TotalSum(String[] arrText) throws Exception {
		int sum = 0;
		for (String txt : arrText) {
			int n = Integer.parseInt(txt);
			if (n < 0) throw new RuntimeException();
			
			sum += n;
		}
		return sum;
	}
	
}
