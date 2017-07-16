package com.hfh9527.demo.timertask;
import java.util.TimerTask;


public class MyTask extends TimerTask {

	private int count = 0;
	@Override
	public void run() {
		System.out.println("task " + count++);
		
	}

}
