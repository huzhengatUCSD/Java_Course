package ch02;

import java.util.*;

public class ShowCurrentTime {
  public static void main(String[] args) {
    // Obtain the total milliseconds since midnight, Jan 1, 1970
    long totalMilliseconds = System.currentTimeMillis(); 
    // Use Date instance to process the time
    Date date = new Date(totalMilliseconds);
    
    // Obtain the total seconds since midnight, Jan 1, 1970
    long totalSeconds = totalMilliseconds / 1000;

    // Compute the current second in the minute in the hour
    long currentSecond = totalSeconds % 60;

    // Obtain the total minutes
    long totalMinutes = totalSeconds / 60;

    // Compute the current minute in the hour
    long currentMinute = totalMinutes % 60;

    // Obtain the total hours
    long totalHours = totalMinutes / 60;

    // Compute the current hour
    long currentHour = totalHours % 24;

    // Display results
    System.out.println("Current time is " + currentHour + ":"
      + currentMinute + ":" + currentSecond + " GMT");
    
    // Directly print date
    System.out.println(date);
    System.out.println("The elapsed time since Jan 1, 1970 is " +
    	    date.getTime()+ " millisecondes");
    
    
    // Calendar convension and output
    Calendar c = Calendar.getInstance();
    c.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    c.setTime(date);
    System.out.println("Current time is " +c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND)+" " +c.getTimeZone().getID());
    
    
  }
}
