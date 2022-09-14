package ch02;
//Answer Exercise1-4 2020
import java.util.*;
import java.time.*;

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
    System.out.println("--------------Display results---------------------");
    //Display results with old way
    System.out.println("Current time is " + currentHour + ":"
      + currentMinute + ":" + currentSecond + " GMT");
    
    // Display results using Date-Time API
    LocalDateTime ldt=LocalDateTime.ofEpochSecond(totalMilliseconds / 1000, (int)((totalMilliseconds % 1000)*10^6) , ZoneOffset.of("+8")); //Without TimeZone  toInstant(ZoneOffset.of("+8")
    System.out.println("Current time is " + ldt.getHour()+ ":"
    	      + ldt.getMinute() + ":" + ldt.getSecond() );  
    
    Instant idt = Instant.ofEpochMilli(totalMilliseconds); //With TimeZone Considered
    ZonedDateTime zdt=ZonedDateTime.ofInstant(idt, ZoneId.of("UTC"));
    
    System.out.println("Current time is " + zdt.getHour()+ ":"
  	      + zdt.getMinute() + ":" + zdt.getSecond() + " GMT");

    System.out.println("--------------Directly print date---------------------");
    
    // Directly print date
    System.out.println("Current time is "+date);
    System.out.println("The elapsed time since Jan 1, 1970 is " +
    	    date.getTime()+ " millisecondes");
    // Directly print datetime
    System.out.println("Current time is "+ldt);
    System.out.println("Current time is " +zdt);
    System.out.println("Current time is " +idt);
    System.out.println("The elapsed time since Jan 1, 1970 is " +
    	    idt.toEpochMilli()+ " millisecondes");
   
    System.out.println("--------------Calendar convention and output---------------------");
    // Calendar convention and output using old way
    Calendar c = Calendar.getInstance();
    c.setTimeZone(TimeZone.getTimeZone(ZoneId.of("GMT+8")));//getTimeZone("GMT+8"));
    c.setTime(date);
    System.out.println("Current time is " +c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND)+" "+c.getTimeZone().getID());
    
    System.out.println("Current time is " + ldt.getHour() + ":" +ldt.getMinute()+":"+ldt.getSecond()+" "+ ZoneOffset.systemDefault());
    
    
  }
}
