package com.agl.util;

import java.lang.reflect.Type;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {
	
	static GsonBuilder gsonBuilder = new GsonBuilder();       

	static public Gson gson = gsonBuilder.excludeFieldsWithoutExposeAnnotation().create();
	
	
	public static <T> T fromJson(final String json, Class clazz)
	{
	        T item = null; 
	        if (json != null) {
	                try {
	                		item = (T) gson.fromJson(json, clazz);
	                } catch (Exception e) {
	                	 System.out.println("The JSON file received is  :::  "+json);;
	                	 System.err.println("Bad Deserialisation for "+clazz.getSimpleName());
	                }
	        }
	        return item;
	}
	
	public static <T> T fromJson(final String json, Type clazz)
	{
	        T item = null;
	        if (json != null) {
	                try {
	                      item = (T) gson.fromJson(json, clazz);

	                } catch (Exception e) {
	                	System.out.println("The JSON file received is  :::  "+json);;
	                	System.err.println("Bad Deserialisation for "+clazz.getTypeName());
	                }
	        }
	        return item;
	}
	
	public static String toJson(Object obj)
	{
		return  gson.toJson(obj);
	}
	
}

