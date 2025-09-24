package com.rays.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestApp {
	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");
		
		System.out.println("url: " + rb.getString("url"));
		System.out.println("driver: " + rb.getString("driver"));
		System.out.println("password: " + rb.getString("password"));
		System.out.println("username: " + rb.getString("username"));
		
		System.out.println("--------------------------------------");
		System.out.println(rb.getString("greetings"));
		
		ResourceBundle rb1 = ResourceBundle.getBundle("com.rays.bundle.app", new Locale("hi"));
		System.out.println(rb1.getString("greetings"));
		
		ResourceBundle rb2 = ResourceBundle.getBundle("com.rays.bundle.app", new Locale("fr"));
		System.out.println(rb2.getString("greetings"));
		
		ResourceBundle rb3 = ResourceBundle.getBundle("com.rays.bundle.app", new Locale("jp"));
		System.out.println(rb3.getString("greetings"));
		
		ResourceBundle rb4 = ResourceBundle.getBundle("com.rays.bundle.app", new Locale("kr"));
		System.out.println(rb4.getString("greetings"));
		
		ResourceBundle rb5 = ResourceBundle.getBundle("com.rays.bundle.app", new Locale("sp"));
		System.out.println(rb5.getString("greetings"));
		
	}

}
