//Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
//
//For example:
//Given n = 13,
//Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
//
//Hint:
//
//Beware of overflow.
package _233_numberOfDigitOne;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.countDigitOne(13));
	}

//    public int countDigitOne(int n) {
//        if (n<=0) return 0;
//        
//        int r = 0;
//        for (int i=1; i<=n; i++) {
//        	char[] cc = (""+i).toCharArray();
//        	for(char c : cc)
//        		if(c-'0'==1) {
//        			r++;
//        		}
//        }
//        return r;
//    }
    
	/*	
	ÿ10����, ��һ����λ��1, ÿ100����, ��10��ʮλ��1, ÿ1000����, ��100����λ��1.  ��һ��ѭ��, ÿ�μ��㵥��λ��1���ܸ���(��λ,ʮλ, ��λ).  
	����:
	�����λ��1Ϊ����:   �����λ����0, 1, �� >=2 �������: 
	    case 1: n=3141092, a= 31410, b=92. �����λ��1�ĸ���Ӧ��Ϊ 3141 *100 ��.
	    case 2: n=3141192, a= 31411, b=92. �����λ��1�ĸ���Ӧ��Ϊ 3141 *100 + (92+1) ��. 
	    case 3: n=3141592, a= 31415, b=92. �����λ��1�ĸ���Ӧ��Ϊ (3141+1) *100 ��. 
	����������������� һ����ʽ����:
	(a + 8) / 10 * m + (a % 10 == 1) * (b + 1);
	*/
    public int countDigitOne(int n) {  
        int ones = 0;  
        for (long m = 1; m <= n; m *= 10) {  
            long a = n/m, b = n%m;  
            ones += (a + 8) / 10 * m;  
            if(a % 10 == 1) ones += b + 1;  
        }  
        return ones;  
    } 
}
