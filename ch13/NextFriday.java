package ch13;

import java.util.*;
import java.text.*;

public class NextFriday {
	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE");
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date()); // cal表示当前日期
		System.out.println("当前时间: " + dateFormat.format(cal.getTime()));

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
