package com.split.handlers;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class DateHandler extends StdDeserializer<Date>{
	public DateHandler() 
	{
		this(null); 
		}
	public DateHandler(Class<?> clazz) 
	{ 
		super(clazz); 
	} 
	@Override public Date deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException { 
		//String date = jsonparser.getText();
		String date=jsonparser.getText();
		try { 
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat formater = new SimpleDateFormat("dd.mm.yyyy"); 
			System.out.println("DateHandler " +formater.parse(date));
			return formater.parse(date);
			
			} 
		catch (Exception e)
			{ return null; } 
		} 

	
}
