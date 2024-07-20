package leetcode.bitmanipulation;

public class SumOfTwoIntegers {
	public int getSum(int a, int b) {
		int res = 0;
		int carry = 0;
		for (int i = 0; i < 32; i++) {
			int lsb_a = a & 1;
			int lsb_b = b & 1;
			res = res | ((lsb_a ^ lsb_b ^ carry) << i);
			carry = (lsb_a & lsb_b) | (carry & (lsb_a ^ lsb_b));
			a >>= 1;
			b >>= 1;
		}
		return res;
	}
}
