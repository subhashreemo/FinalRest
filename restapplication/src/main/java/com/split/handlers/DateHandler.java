package com.split.handlers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

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
//Date Format to DD/MM/YYYY
	public String convertDate(String startDate) {
		//Date rdate=null;
		String formatedDate=null;
		try 
		{
		//String startDate = "Tue May 01 00:00:00 IST 2018";//"Mon Jun 18 00:00:00 IST 2012";
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		Date date = (Date)formatter.parse(startDate);
		System.out.println(date);        

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +         cal.get(Calendar.YEAR);
		System.out.println("formatedDate : " + formatedDate); 
		/*DateFormat dformatter = new SimpleDateFormat("dd/mm/yyyy");
		rdate=(Date)dformatter.parse(formatedDate);
		return rdate;*/
		return formatedDate;
		}
		catch (ParseException e) {
            e.printStackTrace();
        }
		return formatedDate;
	}
	public int getweek(Date startDate,Date endDate) {
		//int nweek=0;
		//int weeks = Weeks.weeksBetween(startDate, endDate).getWeeks();
		/*if (startDate.before(endDate)) {
	        return -getWeeksBetween(endDate, startDate);
	    }*/
		startDate = resetTime(startDate);
		endDate = resetTime(endDate);
		
		System.out.println("resetTime startDate " +startDate);
		System.out.println("resetTime endDate " +endDate);
		Calendar cal = new GregorianCalendar();
	    cal.setTime(startDate);
	    int weeks = 0;
	    while (cal.getTime().before(endDate)) {
	        // add another week
	        cal.add(Calendar.WEEK_OF_YEAR, 1);
	        weeks++;
	    }
	    System.out.println("Number of weeks"+weeks);
		return weeks;
		
	}
	public static Date resetTime (Date d) {
	    Calendar cal = new GregorianCalendar();
	    cal.setTime(d);
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    return cal.getTime();
	}
	public boolean getvalidnumberOfweek(Date startDate,Date endDate) {
		boolean validweek=false;
		Date current = new Date();
		if(!startDate.before(current) && endDate.after(startDate)){
		
				LocalDate lsdate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate ledate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				long daysBetween = ChronoUnit.DAYS.between(lsdate, ledate);
				 System.out.println("noofdays Number of Days"+daysBetween);
				 if(daysBetween%7==0)
				 {
					 System.out.println("Valid number of week is "+ChronoUnit.WEEKS.between(lsdate, ledate)); 
					 validweek=true;
				 }
				 else{
					 System.out.println("InValid enter date");
					 validweek=false;
				 }
		}
		else{
			System.out.println("Past date not allowed and end date should be more than start date");
			validweek=false;
		}
		return validweek;
	}
	
}
