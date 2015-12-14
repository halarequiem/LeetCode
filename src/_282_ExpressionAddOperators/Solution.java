//Given a string that contains only digits 0-9 and a target value, 
//return all possibilities to add binary operators (not unary) +, -, or * between the digits
//so they evaluate to the target value.
//
//Examples: 
//"123", 6 -> ["1+2+3", "1*2*3"] 
//"232", 8 -> ["2*3+2", "2+3*2"]
//"105", 5 -> ["1*0+5","10-5"]
//"00", 0 -> ["0+0", "0-0", "0*0"]
//"3456237490", 9191 -> []
//Credits:
//Special thanks to @davidtan1890 for adding this problem and creating all test cases.
//
//Subscribe to see which companies asked this question
package _282_ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		for(String i:s.addOperators("3456237490", 9191))
			System.out.println(i);
	}
	
    public List<String> addOperators(String num, int target) {
    	r=new ArrayList<String>();
    	addOperators(num, target, 0, 0, "");
    	return r;
    }
    
    private List<String> r;

    private void addOperators(String num, int target, long lastAdd, long result, String exp) {
    	if(result==target&&num.isEmpty()) {
    		r.add(exp);
    		return;
    	}
    	for(int i=1;i<=num.length();i++) {
    		String numberStr = num.substring(0, i);
    		if(numberStr.length()>1&&numberStr.charAt(0)=='0')
    			return;//"105", 5 -> ["1*0+5","10-5"] 1*05 ?
    		long number = Long.parseLong(numberStr);//use long!
    		String rightStr = num.substring(i);
    		if(exp.isEmpty())
    			addOperators(rightStr, target, number, number, numberStr);
    		else {
	    		addOperators(rightStr, target, number, result+number, exp+"+"+number);
	    		addOperators(rightStr, target, -number, result-number, exp+"-"+number);
	    		addOperators(rightStr, target, lastAdd*number, result-lastAdd+lastAdd*number, exp+"*"+number);
    		}
    	}
    }
    
    private int needtosee;

}
