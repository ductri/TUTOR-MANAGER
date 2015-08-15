package model;

import java.awt.Image;

public class ImageData {
	Image image;
	int x, y;


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public ImageData(Image image, int x, int y) {
		super();
		this.image = image;
		this.x = x;
		this.y = y;
	}
	
	
}
