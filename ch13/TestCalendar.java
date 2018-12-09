package ch13;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestCalendar {
  public static void main(String[] args) {
    // Construct a Gregorian calendar for the current date and time
	String[] months = {"Januray","Feburary","March","April","May","June","July","August","Semptember","October","November","December"};
    Calendar calendar = new GregorianCalendar();
    System.out.println("Current time is " + new Date());
    System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
    System.out.println("MONTH: " + months[calendar.get(Calendar.MONTH)]);
    System.out.println("DATE: " + calendar.get(Calendar.DATE));
    System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
    System.out.println("HOUR_OF_DAY: " + 
      calendar.get(Calendar.HOUR_OF_DAY));
    System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
    System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
    System.out.println("DAY_OF_WEEK: " + 
      calendar.get(Calendar.DAY_OF_WEEK));
    System.out.println("DAY_OF_MONTH: " + 
      calendar.get(Calendar.DAY_OF_MONTH));
    System.out.println("DAY_OF_YEAR: " + 
      calendar.get(Calendar.DAY_OF_YEAR));
    System.out.println("WEEK_OF_MONTH: " + 
      calendar.get(Calendar.WEEK_OF_MONTH));
    System.out.println("WEEK_OF_YEAR: " + 
      calendar.get(Calendar.WEEK_OF_YEAR));
    System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
    
    // Construct a calendar for December 10, 2018
    Calendar calendar1 = new GregorianCalendar(2018, 11, 10);
    String[] dayNameOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", 
        "Thursday", "Friday", "Saturday"};
    System.out.println("December 10, 2018 is a " +
      dayNameOfWeek[calendar1.get(Calendar.DAY_OF_WEEK) - 1]);
    //format print
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE");
	GregorianCalendar cal = new GregorianCalendar();
	cal.setTime(new Date()); // cal表示当前日期
	System.out.println("当前时间: " + dateFormat.format(cal.getTime())+"\n"+cal.get(Calendar.YEAR)+"年已经过去了 "+(cal.get(Calendar.DAY_OF_YEAR)-1)+" 天了！");

	// 改为星期五
	cal.set(GregorianCalendar.DAY_OF_WEEK, GregorianCalendar.FRIDAY);
	System.out.println("改为星期五后的时间: " + dateFormat.format(cal.getTime()));

	int friday13Counter = 0;
	while (friday13Counter < 15) {
		// 获得下一个星期五
		cal.add(GregorianCalendar.DAY_OF_MONTH, 7);

		// 如果星期五刚好是某个月的13号
		if (cal.get(GregorianCalendar.DAY_OF_MONTH) == 13) {
			friday13Counter++;
			System.out.println(dateFormat.format(cal.getTime()));
		}
	}
  }
}
