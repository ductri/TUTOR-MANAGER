package com;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;

import model.ImageData;
import model.Letter;
import model.PrintableContent;
import model.TextLine;

public class LetterPrinter implements Printable {
	
	Letter letter;
	public LetterPrinter(Letter letter) {
		this.letter=letter;
	}
	
	
	@Override
	public int print(Graphics arg0, PageFormat pf, int page)
			throws PrinterException {
		
		//Print only one page
		if (page>0)
			return NO_SUCH_PAGE;
		
		Graphics2D g=(Graphics2D)arg0;
		g.translate(pf.getImageableX(), pf.getImageableY());
		
		PrintableContent content=new PrintableContent(g, pf);
		int tabPhase1=27;
		int tabPhase2=73;
		int tabPhase3=20;
		int tabPhase4=100;
		int tabPhase5=10;
		try {
			
			Image img=ImageIO.read(this.getClass().getResourceAsStream("/LogoBK.png"));
			content.drawImage(img);
			content.setTab(125);
			img=ImageIO.read(this.getClass().getResourceAsStream("/logotrungtam.png"));
			content.drawImage(img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		content.setFont(new Font("Times New Roman", Font.BOLD, 12));
		content.setTab(tabPhase1);
		content.writeLine("Văn phòng tư vấn tuyển sinh & Giới thiệu việc làm");
		content.enter();
		content.setTab(tabPhase1);
		content.writeLine("Kios 78 – số 142A Tô Hiến Tô Hiến Thành – P.14 – Q.10");
		content.enter();
		content.setTab(tabPhase1);
		content.writeLine("(đối diện Saigon Village). Website: ");
		content.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		content.setTab(tabPhase1+60);
		content.writeLine("www.bktphcm.net");
		content.enter();
		content.enter();
		
		content.setTab(tabPhase2);
		content.setFont(new Font("Times New Roman", Font.BOLD, 16));
		content.writeLine("GIẤY GIỚI THIỆU");
		content.enter();
		content.setTab(tabPhase2-28);
		content.writeLine("GIA SƯ ĐẠI HỌC BÁCH KHOA");
		content.enter();
		content.enter();
		
		content.setFont(new Font("Times New Roman", Font.BOLD|Font.ITALIC, 12));
		content.setTab(tabPhase3);
		content.writeLine("Họ và tên:");
		content.setTab(tabPhase3+40);
		content.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		content.writeLine(letter.getName());
		content.enter();
		
		content.setTab(tabPhase3);
		content.setFont(new Font("Times New Roman", Font.BOLD|Font.ITALIC, 12));
		content.writeLine("MSSV:");
		content.setTab(tabPhase3+40);
		content.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		content.writeLine(letter.getMssv());
		content.enter();
		
		content.setFont(new Font("Times New Roman", Font.BOLD|Font.ITALIC, 12));
		content.setTab(tabPhase3);
		content.writeLine("Số điện thoại:");
		content.setTab(tabPhase3+40);
		content.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		content.writeLine(letter.getStd());
		content.enter();
		
		content.setFont(new Font("Times New Roman", Font.BOLD|Font.ITALIC, 12));
		content.setTab(tabPhase3);
		content.writeLine("Email:");
		content.setTab(tabPhase3+40);
		content.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		content.writeLine(letter.getEmail());
		content.enter();
		
		content.setFont(new Font("Times New Roman", Font.BOLD|Font.ITALIC, 12));
		content.setTab(tabPhase3);
		content.writeLine("Quê quán:");
		content.setTab(tabPhase3+40);
		content.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		content.writeLine(letter.getQuequan());
		content.enter();
		
		content.setFont(new Font("Times New Roman", Font.BOLD|Font.ITALIC, 12));
		content.setTab(tabPhase3);
		content.writeLine("Địa chỉ hiện tại:");
		content.setTab(tabPhase3+40);
		content.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		content.writeLine(letter.getDiachi());
		content.enter();
		
		content.enter();
		
		Calendar calendar=Calendar.getInstance();
		content.setFont(new Font("Times New Roman", Font.BOLD|Font.ITALIC, 12));
		content.setTab(tabPhase4);
		content.writeLine("Bách Khoa, ngày ");
		content.writeLine(Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)));
		content.writeLine(", tháng ");
		content.writeLine(Integer.toString(calendar.get(Calendar.MONTH)+1));
		content.writeLine(", năm ");
		content.writeLine(Integer.toString(calendar.get(Calendar.YEAR)));
		content.enter();
		
		content.setTab(tabPhase5+22);
		content.writeLine("------------------------------------------");	
		content.setLineSpace(0.05f);
		content.enter();
		content.setLineSpace(0.1f);
		content.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		content.setTab(tabPhase5);
		content.writeLine("Chương trình ");
		content.setFont(new Font("Times New Roman", Font.ITALIC|Font.BOLD, 11));
		content.writeLine("Gia sư trực tuyến");
		content.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		content.writeLine(" - Do sinh viên trường ĐH Bách Khoa");
		content.enter();
		content.setTab(tabPhase5+5);
		content.writeLine("phụ trách, nhằm hỗ trợ cho học sinh về việc giải đáp thắc mắc");
		content.enter();
		content.setTab(tabPhase5+17);
		content.writeLine("trong học tập: ");
		content.setFont(new Font("Times New Roman", Font.BOLD, 11));
		content.writeLine("Gọi (08) 1088, nhấn 152");
		content.enter();
		
		content.enter();
		content.enter();
		
		content.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		content.setTab(tabPhase5-5);
		content.writeLine("Mọi ý kiến đóng góp và trao đổi, phụ huynh vui lòng liên hệ: Nguyễn Thị Thu Hồng");
		content.enter();
		content.setTab(tabPhase5-5);
		content.writeLine("(Trường ĐH Bách Khoa - ĐH Quốc gia TP Hồ Chí Minh). Điện thoại: 08 22146 888 - 0946 429933");
		content.enter();
		content.setTab(tabPhase5-5);
		content.writeLine("Hoặc email: ");
		content.setFont(new Font("Times New Roman", Font.ITALIC|Font.HANGING_BASELINE, 11));
		content.writeLine("giasudaihocbachkhoa@hcmut.edu.vn.");
		content.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		content.writeLine("Chân thành cảm ơn!");
		
		for (TextLine i:content.getListTextData()) {
			g.setFont(i.getFont());
			g.drawString(i.getText(), (int)i.getX(), (int)i.getY());
		}
		
		for (ImageData i:content.getListImageData()) {
			
			//g.drawImage(i.getImage(), i.getX(), i.getY(), i.getX()+i.getImage().getWidth(null), i.getY()+i.getImage().getHeight(null),
			//			0, 0, i.getImage().getWidth(null), i.getImage().getHeight(null),new Color(255, 255, 255), null);
			g.drawImage(i.getImage(), i.getX(), i.getY(), i.getImage().getWidth(null), i.getImage().getHeight(null),null);
		}
		return PAGE_EXISTS;
	}
}
