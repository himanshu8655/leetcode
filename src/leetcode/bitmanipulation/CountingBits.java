package leetcode.bitmanipulation;

public class CountingBits {
    public int[] countBits(int n) {
        int res[] = new int[n+1];
       for(int i = 0; i<=n; i++){
        int temp = i;
        while(temp!=0){
            temp = temp & (temp - 1);
            res[i]++;
        }
       } 
       return res;
    }
}
