package hcmut.tutorclub.controller;

import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PageRanges;

import hcmut.tutorclub.com.BackLetterPrintable;
import hcmut.tutorclub.com.CoverLetterPrintable;
import hcmut.tutorclub.com.FrontLetterPrintable;
import hcmut.tutorclub.model.printer.CoverLetter;
import hcmut.tutorclub.model.printer.Letter;
import hcmut.tutorclub.utils.PaperSize;
import hcmut.tutorclub.view.IMainView;


public class PrinterController implements IPrinterController{
	
	private IMainView mainView;
	
	public PrinterController(IMainView mainView) {
		this.mainView = mainView;
		this.mainView.setPrinterController(this);
	}
	
	@Override
	public void printCoverLetter(CoverLetter coverLetter) {
	
		PrinterJob job=PrinterJob.getPrinterJob();
		PrintRequestAttributeSet attSet=new HashPrintRequestAttributeSet();
		
		attSet.add(new Copies(1));
		attSet.add(MediaSizeName.ISO_A5);
		attSet.add(new PageRanges(1));
		
		
		Paper paper = new Paper();
		paper.setSize(PaperSize.A5_WIDTH, PaperSize.A5_HEIGHT);
		PageFormat pf = new PageFormat();
		pf.setPaper(paper);
		pf.setOrientation(PageFormat.LANDSCAPE);
		
		job.setPrintable(new CoverLetterPrintable(coverLetter), pf);
		
		boolean doPrinter=job.printDialog();
		if (doPrinter)
		{
			try {
				job.print(attSet);
			} catch (PrinterException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void printFrontLetter(Letter letter) {
		
		//DocFlavor myFormat = DocFlavor.READER.TEXT_PLAIN;
		
		PrintRequestAttributeSet attSet=new HashPrintRequestAttributeSet();
		attSet.add(new Copies(1));
		attSet.add(MediaSizeName.ISO_A5);
		attSet.add(new PageRanges(1));
		
		PrinterJob job = PrinterJob.getPrinterJob();

		
		job.setCopies(1);
		
		Paper paper = new Paper();
		paper.setSize(PaperSize.A5_WIDTH, PaperSize.A5_HEIGHT);
		
		PageFormat pf = new PageFormat();
		pf.setPaper(paper);
		pf.setOrientation(PageFormat.LANDSCAPE);
		
		job.setPrintable(new FrontLetterPrintable(letter), pf);
		boolean doPrint = job.printDialog();
		if (doPrint) {
			try {
				job.print(attSet);
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void printBackLetter()
	{
		PrintRequestAttributeSet attSet=new HashPrintRequestAttributeSet();
		attSet.add(new Copies(1));
		attSet.add(MediaSizeName.ISO_A5);
		attSet.add(new PageRanges(1));
		
		PrinterJob job = PrinterJob.getPrinterJob();

		job.setCopies(1);
		
		Paper paper = new Paper();
		paper.setSize(PaperSize.A5_WIDTH, PaperSize.A5_HEIGHT);
		
		PageFormat pf = new PageFormat();
		pf.setPaper(paper);
		pf.setOrientation(PageFormat.LANDSCAPE);
		
		job.setPrintable(new BackLetterPrintable(), pf);
		boolean doPrint = job.printDialog();
		if (doPrint) {
			try {
				job.print(attSet);
			} catch (PrinterException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void startup() {
		mainView.show();
	}
}
