//Given a string of numbers and operators, 
//return all possible results from computing all the different possible ways to group numbers and operators. 
//The valid operators are +, - and *.
//
//
//Example 1
//Input: "2-1-1".
//
//((2-1)-1) = 0
//(2-(1-1)) = 2
//Output: [0, 2]
//
//
//Example 2
//Input: "2*3-4*5"
//
//(2*(3-(4*5))) = -34
//((2*3)-(4*5)) = -14
//((2*(3-4))*5) = -10
//(2*((3-4)*5)) = -10
//(((2*3)-4)*5) = 10
//Output: [-34, -14, -10, -10, 10]
//
//Credits:
//Special thanks to @mithmatt for adding this problem and creating all test cases.
package _241_differentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		for(Integer i : s.diffWaysToCompute("2*3-4*5")) {
			System.out.println(i);
		}
	}

//    public List<Integer> diffWaysToCompute(String input) {
//        char[] ca = input.toCharArray();
//        List<Character> sym = new ArrayList<Character>();
//        List<Integer> num = new ArrayList<Integer>();
//        StringBuffer tmp = new StringBuffer();
//        for(int i=0;i<ca.length;i++)
//        	if(ca[i]=='+'||ca[i]=='-'||ca[i]=='*') {
//        		sym.add(ca[i]);
//        		num.add(Integer.parseInt(tmp.toString()));
//        		tmp = new StringBuffer();
//        	}
//        	else {
//        		tmp.append(ca[i]);
//        	}
//        num.add(Integer.parseInt(tmp.toString()));
//        
//        List<Integer> result = new ArrayList<Integer>();
//    	compute(sym, num, result);
//        
//        return result;
//    }
    /*wrong :extra result*/
	/*对整个表达式进行递归，每次减少一次运算的长度。并不能算真正的递归*/
    private void compute(List<Character> sym, List<Integer> num, List<Integer> result) {
    	if(sym.isEmpty()) {
			result.add(num.get(0));
    	}
    	List<Character> s = new ArrayList<Character>();
    	s.addAll(sym);
    	List<Integer> n = new ArrayList<Integer>();
    	n.addAll(num);
    	for(int i=0; i<sym.size(); i++) {
    		if(sym.get(i)=='+') {
    			num.set(i, num.get(i)+num.get(i+1));
    			num.remove(i+1);
    			sym.remove(i);
    		}
    		else if(sym.get(i)=='-') {
    			num.set(i, num.get(i)-num.get(i+1));
    			num.remove(i+1);
    			sym.remove(i);
    		}
    		else if(sym.get(i)=='*') {
    			num.set(i, num.get(i)*num.get(i+1));
    			num.remove(i+1);
    			sym.remove(i);
    		}
        	compute(sym, num, result);
			sym.clear();
			sym.addAll(s);
			num.clear();
			num.addAll(n);
    	}
    }

    /*on csdn*/
    /*对每次运算两边的表达式递归*/
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            if('+' == c || '-' == c || '*' == c) {
                String lv = input.substring(0, i);
                String rv = input.substring(i+1);
                List<Integer> lefts = diffWaysToCompute(lv);
                List<Integer> rights = diffWaysToCompute(rv);
                for(int j : lefts) {
                    for(int k: rights){
                        int temp = 0;
                        switch(c){
                            case'+': 
                                temp = j+k;
                                break;
                            case'-': 
                                temp = j-k;
                                break;
                            case'*': temp = j*k;
                        }
                        res.add(temp);
                    }
                }
            }
        }
        if(res.isEmpty()){
                res.add(Integer.valueOf(input));
            }
        return res;
    }
}
