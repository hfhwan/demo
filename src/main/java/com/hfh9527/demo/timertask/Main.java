package com.hfh9527.demo.timertask;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		java.text.Format f = 
		
		
		Calendar calendar =  Calendar.getInstance();
		calendar.set(Calendar.HOUR, 9);
		calendar.set(Calendar.MINUTE, 50);
		calendar.set(Calendar.SECOND, 30);
		Date date = calendar.getTime();
		System.out.println(date);
		
		Timer t = new Timer();
		
		t.schedule(new MyTask(), 3000);
		
		t.schedule(new MyTask(), date, 3000);

	}

}
