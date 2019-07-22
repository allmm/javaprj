package com.newlecture.web.dao.java;

import java.lang.reflect.InvocationTargetException;

import com.newlecture.web.entity.File;

public class Program {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
		// TODO Auto-generated method stub
		//D:\tools
		
		java.io.File directory = new java.io.File("D:\\tools");
		
		java.io.File[] files = directory.listFiles();
		
		for(int i=0; i<files.length;i++) {
			File f = new File(files[i]);
			System.out.println(f.toJSON());
		}
		
	}

}
