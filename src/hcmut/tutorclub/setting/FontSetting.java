package hcmut.tutorclub.setting;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class FontSetting {
	Graphics g;
	private Font font;
	private FontMetrics fontMetrics;
	
	/**
	 * The dimensions are supplied in 1/72nds of an inch
	 */
	private double lineSpace=0;
	
	private double lineHeight=0.1;
	
	public FontSetting(Graphics g) {
		this.g=g;
		font=new Font("Times New Roman", Font.PLAIN, 12);
		fontMetrics=g.getFontMetrics(font);
		lineHeight=fontMetrics.getHeight();
		setLineSpace(0.1*lineHeight);
	}

	/**
	 * 
	 * @return The dimensions are supplied in 1/72nds of an inch
	 */
	public double getLineSpace() {
		return lineSpace;
	}

	/**
	 * 
	 * @param lineSpace The dimensions are supplied in 1/72nds of an inch
	 */
	public void setLineSpace(double lineSpace) {
		this.lineSpace = lineSpace;
	}
	
	/**
	 * 
	 * @return The dimensions are supplied in 1/72nds of an inch
	 */
	public double getLineHeight() {
		return lineHeight;
	}
	
	public Rectangle2D getBoundString(String text) {
		return fontMetrics.getStringBounds(text, g);
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
		fontMetrics=g.getFontMetrics(font);
		lineHeight=fontMetrics.getHeight();
	}
}
