package model;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.util.ArrayList;
import java.util.List;

import com.Margin;

import Setting.FontSetting;

public class PrintableContent {
	
	
	private Margin margin;
	public Margin getMargin() {
		return margin;
	}

	public void setMargin(Margin margin) {
		this.margin = margin;
	}

	private PageFormat pf;
	
	private FontSetting fontSetting;
	
	private List<TextLine> listTextData;
	
	private List<ImageData> listImageData;

	private double cursorX;
	private double cursorY;
	
	public PrintableContent(Graphics g, PageFormat pf) {
		
		margin=new Margin(10, 10, 23.76, 9.36);
		this.pf=pf;
		
		fontSetting=new FontSetting(g);
		
		listTextData=new ArrayList<TextLine>();
		listImageData=new ArrayList<ImageData>();
		
		cursorX=margin.getLeft();
		cursorY=margin.getTop();
	}
	
	//Co dan trang
	public void writeLine(String text) {
		String line="";
		//Rectangle2D lineBound=fontSetting.getBoundString(line);
		
		int beginIndex=0,endIndex=0;
		
		int length=text.length();
		while (endIndex<length) {

			while (endIndex<length && cursorX+fontSetting.getBoundString(line).getWidth()<pf.getImageableWidth()-margin.getRight()) {
				endIndex++;
				line=text.substring(beginIndex, endIndex);
				//lineBound=fontSetting.getBoundString(line);
			}
		
			//Het 1 dong
			if (endIndex<length)
			{
				listTextData.add(new TextLine(cursorX, cursorY+fontSetting.getLineHeight(), 
					line.substring(0, line.length()),fontSetting.getFont()));
				beginIndex=endIndex;
				//Newline
				cursorY+=(fontSetting.getLineHeight()+fontSetting.getLineSpace());
				cursorX=margin.getLeft();
			}
			else //Het chuoi text
			{
				listTextData.add(new TextLine(cursorX, cursorY+fontSetting.getLineHeight(), 
						line,fontSetting.getFont()));
				cursorX+=fontSetting.getBoundString(line).getWidth();
				beginIndex=endIndex;
			}
			line="";
		}	
	}
	
	/**
	 * Notice: Be effected by fontSetting
	 * Tab from left margin
	 * @param spaceNo
	 */
	public void setTab(int spaceNo) {
		String spaces="";
		for (int i=0;i<spaceNo;i++)
			spaces+=" ";
		cursorX=margin.getLeft()+fontSetting.getBoundString(spaces).getWidth();
	}
	
	public void enter() {
		cursorX=margin.getLeft();
		
		cursorY+=(fontSetting.getLineSpace()+fontSetting.getLineHeight());
		if (cursorY>pf.getHeight()-margin.getBottom())
			cursorY-=(fontSetting.getLineSpace()+fontSetting.getLineHeight());
	}
	
	public void previousLine() {
		cursorY-=(fontSetting.getLineHeight()+fontSetting.getLineSpace());
		if (cursorY<margin.getTop())
			cursorY=(fontSetting.getLineHeight()+fontSetting.getLineSpace());
	}
	
	public void drawImage(Image image) {
		
		ImageData imageData=new ImageData(image, (int)cursorX, (int)cursorY);
		listImageData.add(imageData);
	}
	
	public List<TextLine> getListTextData() {
		return listTextData;
	}

	public void setListTextData(List<TextLine> listTextData) {
		this.listTextData = listTextData;
	}

	public List<ImageData> getListImageData() {
		return listImageData;
	}

	public void setListImageData(List<ImageData> listImageData) {
		this.listImageData = listImageData;
	}

	public void setFont(Font f) {
		fontSetting.setFont(f);
	}

	public void setLineSpace(float space) {
		fontSetting.setLineSpace(space);
	}
}
