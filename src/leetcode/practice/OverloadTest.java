package leetcode.practice;

public class OverloadTest {
	 public static void main(String[] args) {
	 OverloadTest test = new OverloadTest();
	 Integer a = 1;
	 int b = 2;
	 a++;
	 test.print(2);
	 }

	 void print(int i) {
	 System.out.println("int");
	 }

	 void print(Integer i) {
	 System.out.println("Integer");
	 }
	}
