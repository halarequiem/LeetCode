//Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.
//
//For example,
//123 -> "One Hundred Twenty Three"
//12345 -> "Twelve Thousand Three Hundred Forty Five"
//1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
//Hint:
//
//Did you see a pattern in dividing the number into chunk of words? For example, 123 and 123000.
//Group the number by thousands (3 digits). You can write a helper function that takes a number less than 1000 and convert just that chunk to words.
//There are many edge cases. What are some good test cases? Does your code work with input such as 0? Or 1000010? 
//(middle chunk is zero and should not be printed out)
package _273_integerToEnglishWords;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numberToWords(1001001001)); 
	}

    public String numberToWords(int num) {
    	StringBuffer result = new StringBuffer();
    	if(num==0)
    		result.append("Zero");
    	else if(num<1000)
    		result.append(threeDigitsToWords(num));
    	else if(num<1000000)
    		result.append(sixDigitsToWords(num));
    	else if(num<1000000000)
    		result.append(nineDigitsToWords(num));
    	else 
    		result.append(mostDigitsToWords(num));
    	return result.toString();
    }
    
    private String mostDigitsToWords(int num) {
    	StringBuffer result = new StringBuffer();
    	result.append(threeDigitsToWords(num/1000000000)+" Billion");
		int million = num%1000000000;
		if(million!=0)
			result.append(" "+nineDigitsToWords(million));
    	return result.toString();
    }
    
    private String nineDigitsToWords(int num) {
    	StringBuffer result = new StringBuffer();
    	int million = num/1000000;
    	int thousand = num%1000000;
    	if(million!=0&&thousand!=0)
    		result.append(threeDigitsToWords(million)+" Million "+sixDigitsToWords(thousand));
    	else if(million==0&&thousand!=0)
    		result.append(sixDigitsToWords(thousand));
    	else if(million!=0&&thousand==0)
    		result.append(threeDigitsToWords(million)+" Million");
    	return result.toString();
    }
    
    private String sixDigitsToWords(int num) {
    	StringBuffer result = new StringBuffer();
    	int thousand=num/1000;
    	int one = num%1000;
    	if(thousand!=0&&one!=0)
    		result.append(threeDigitsToWords(thousand)+" Thousand "+threeDigitsToWords(one));
    	else if(thousand==0&&one!=0)
    		result.append(threeDigitsToWords(one));
    	else if(thousand!=0&&one==0)
    		result.append(threeDigitsToWords(thousand)+" Thousand");
    	return result.toString();
    }
    
    private String threeDigitsToWords(int num) {
    	StringBuffer result = new StringBuffer();
    	
    	int hundred = num/100;
    	if(hundred!=0)
    		result.append(w1[hundred-1] + " Hundred ");
    	
    	int ten = num%100;
    	if(ten==0)
    		result.deleteCharAt(result.length()-1);
    	else if(ten<10)
    		result.append(w1[ten-1]);
    	else if(ten<20)
    		result.append(w2[ten-10]);
    	else {
    		if(ten%10==0)
    			result.append(w3[ten/10-2]);
    		else
    			result.append(w3[ten/10-2] + " " +w1[ten%10-1]);
    	}
    	
    	return result.toString();
    }
    
    private final String[] w1=new String[]{"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private final String[] w2=new String[]{"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private final String[] w3=new String[]{"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
}
