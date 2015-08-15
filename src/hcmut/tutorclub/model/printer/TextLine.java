package hcmut.tutorclub.model.printer;

import java.awt.Font;

public class TextLine {
	private double x;
	private double y;
	private String text;
	private Font font;
	public TextLine(double x, double y, String text, Font font) {
		super();
		this.x = x;
		this.y = y;
		this.text = text;
		this.font=font;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
	
}
