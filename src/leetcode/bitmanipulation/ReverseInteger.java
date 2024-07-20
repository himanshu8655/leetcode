package leetcode.bitmanipulation;

public class ReverseInteger {
    public int reverse(int x) {
        int res = 0;
        while(x!=0){
            int remainder = x%10;
            x/=10;
            if(res>Integer.MAX_VALUE/10 || 
            res<Integer.MIN_VALUE/10 || 
            (res == Integer.MAX_VALUE/10 && remainder>7) || 
            res == Integer.MIN_VALUE && remainder<8)
                return 0;

            res = res*10+remainder;
        }
        return res;
    }
}
