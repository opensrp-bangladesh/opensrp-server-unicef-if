package org.opensrp.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.LocalDateTime;

public class DateTimeUtil {
    private static DateTimeUtility dateUtility = new RealDateTime();

    public static void fakeIt(LocalDateTime fakeDateTime) {
        dateUtility = new MockDateTime(fakeDateTime);
    }

    public static LocalDateTime now() {
        return dateUtility.now();
    }
    public static String getDayPlusOneDay(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		
		Date day = null;		
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, 1);	    
	    String today = dateFormat.format(now.getTime());
		return today;
	}
    
    public static long getTimeStampPlusOneDay(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		
		Date day = null;		
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DATE, 1);	    
	    String today = dateFormat.format(now.getTime());	   
		try {
			day = dateFormat.parse(today);			
		} catch (ParseException e) {			
			e.printStackTrace();
		}		
		return day.getTime();
	}
    public static long getTimeStampTodatDay(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		
		Date day = null;		
		Calendar now = Calendar.getInstance();			    
	    String today = dateFormat.format(now.getTime());	   
		try {
			day = dateFormat.parse(today);			
		} catch (ParseException e) {			
			e.printStackTrace();
		}		
		return day.getTime();
	}
}

interface DateTimeUtility {
    LocalDateTime now();
}

class RealDateTime implements DateTimeUtility {
    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}

class MockDateTime implements DateTimeUtility {
    private LocalDateTime fakeDateTime;

    MockDateTime(LocalDateTime fakeDateTime) {
        this.fakeDateTime = fakeDateTime;
    }

    @Override
    public LocalDateTime now() {
        return fakeDateTime;
    }
}