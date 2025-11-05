package leetcode.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

	class User implements Serializable {
    private static final long serialVersionUID  = 1L;

    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class SerializeExample {

	
	public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("user.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        User user = (User) in.readObject();
        in.close();
        fileIn.close();

        System.out.println("Name: " + user.name);
        System.out.println("Age: " + user.age);
    }
}
