package com.hfh9527.demo.font;

import java.awt.GraphicsEnvironment;

public class FontList {

	public static void main(String[] args) {
		String []family = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (String fname : family) {
			System.out.println(fname);
		}
	}

}
