package com.hfh9527.demo.font;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FontTest {

	public static void main(String[] args) throws IOException {

		int width = 100;
		int height = 100;
		System.err.println(System.getProperty("sun.jnu.encoding"));
		String s1 = "申鹭达";
		

		File file = new File("./font.jpg");

		Font font = new Font("Dialog", Font.BOLD, 10);
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		g2.setBackground(Color.WHITE);
		g2.clearRect(0, 0, width, height);
		g2.setPaint(Color.RED);

		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(s1, context);
		double x = (width - bounds.getWidth()) / 2;
		double y = (height - bounds.getHeight()) / 2;
		double ascent = -bounds.getY();
		double baseY = y + ascent;

		g2.drawString(s1, (int) x, (int) baseY);

		ImageIO.write(bi, "jpg", file);
	}
}
