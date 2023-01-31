package com.genericlib.demoblaze;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Filelib {
	public String getdatafromproperties(String path,String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(path);
		prop.load(fis);
		String data=prop.getProperty(key);
		return data;
	}
	

}
