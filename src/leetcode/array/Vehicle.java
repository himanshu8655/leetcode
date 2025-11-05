package leetcode.array;

public class Vehicle {
public int normal_var = 0;
public static int static_var = 0;
public Vehicle(){
	
}
public void incrementVar(){
	normal_var = normal_var + 1;
}

public void incrementStaticVar() {
static_var = static_var + 1;
}
}
