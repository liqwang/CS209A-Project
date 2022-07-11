package edu.sustech.backend.util;

import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStream;

public class Util {
	public static String readFile(String path){
		InputStream is = Util.class.getClassLoader().getResourceAsStream(path);
		Assert.notNull(is,"The file "+path+" doesn't exist, check the path");
		return readInputStream(is);
	}

	public static String readInputStream(InputStream is){
		int c;
		StringBuilder sb = new StringBuilder();
		try{
			while((c= is.read())!=-1){
				sb.append((char)c);
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		return sb.toString();
	}
}
