package com;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import model.CoverLetter;
import model.PrintableContent;
import model.TextLine;


public class CoverLetterPrinter implements Printable {
	
	CoverLetter coverLetter;
	public CoverLetterPrinter(CoverLetter coverLetter) {
		this.coverLetter=coverLetter;
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		if (pageIndex>0)
			return NO_SUCH_PAGE;
		
		Graphics2D g=(Graphics2D)graphics;
		g.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		
		PrintableContent content=new PrintableContent(graphics, pageFormat);
		
		content.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		for (int i=0;i<15;i++)
			content.enter();
		content.setTab(110);
		content.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		content.writeLine(coverLetter.getName());
		content.enter();
		
		//Dai hon tab tren, do font lon hon
		content.setTab(75);
		content.writeLine("Địa chỉ: "+coverLetter.getAddress());
		content.enter();
		
		content.setTab(75);
		content.writeLine("Sđt: "+coverLetter.getPhone());
		
		for (TextLine i:content.getListTextData())
		{
			g.drawString(i.getText(), (int)i.getX(), (int)i.getY());
		}
		
		return PAGE_EXISTS;
	}
	
}
