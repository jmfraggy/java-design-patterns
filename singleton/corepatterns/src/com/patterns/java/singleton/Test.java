package com.patterns.java.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Testing the Singleton
 * Both of them are pointing to the same Object in memory.
 */

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		DateUtil dateUtil1 = DateUtil.getInstance();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				new File("/Users/fraggy/Documents/Code/JAVA/java-design-patterns/singleton/dateUtil.ser")));
		oos.writeObject(dateUtil1); // Write the Instance to the File

		DateUtil dateUtil2 = null;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				new File("/Users/fraggy/Documents/Code/JAVA/java-design-patterns/singleton/dateUtil.ser")));
		dateUtil2 = (DateUtil) ois.readObject(); // Read the file, and typecast because it return an Object

		oos.close();
		ois.close();

		System.out.println(dateUtil1 == dateUtil2);

	}

}