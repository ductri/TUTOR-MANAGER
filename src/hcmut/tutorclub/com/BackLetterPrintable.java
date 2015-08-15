package hcmut.tutorclub.com;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import hcmut.tutorclub.model.printer.Margin;
import hcmut.tutorclub.model.printer.PrintableContent;
import hcmut.tutorclub.model.printer.TextLine;

public class BackLetterPrintable implements Printable {

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		
		if (pageIndex>0)
			return NO_SUCH_PAGE;
		
		Graphics2D g=(Graphics2D)graphics;
		g.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		
		PrintableContent content=new PrintableContent(g, pageFormat);
		content.setMargin(new Margin(30, 36, 30, 20));
		content.setFont(new Font("Times New Roman", Font.BOLD, 12));
		content.enter();
		content.enter();
		content.writeLine("Lý do để Phụ huynh – học sinh chọn Gia sư Trường Đại học Bách khoa ?");
		content.enter();
		content.enter();
		content.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		String temp="	Cộng đồng sinh viên Bách khoa - tuyển chọn từ các học sinh ưu tú ở các "
				+ "trường THPT, trường Chuyên cả nước: Thông minh - Năng động - Có nền tảng kiến thức phổ "
				+ "thông tốt, được rèn luyện khả năng tự học, có";
		content.writeLine(temp);
		content.enter();
		content.writeLine("phương pháp học hành, thi cử đạt hiệu quả cao - đặc biệt các môn Toán - Lý - Hoá - Tiếng Anh ...");
		content.enter();
		content.writeLine("•    Gia sư được Trung tâm tuyển chọn kỹ trước khi giới thiệu phụ huynh, học "
				+ "sinh, chúng tôi ưu tiên chọn SVBK với các tiêu chuẩn: ");
		content.enter();
		content.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		content.writeLine("1.    Điểm thi tuyển sinh ĐH cao và đạt kết quả trong học tập và rèn luyện tại "
				+ "ĐHBK, tư cách đạo đức tốt,");
		content.enter();
		content.writeLine("có thể làm người bạn tốt, tấm gương cho học sinh phấn đấu, học tập.");
		content.enter();
		content.writeLine("2.    Có kỹ năng giao tiếp - thuyết trình tốt, truyền đạt kiến thức dễ hiểu, ưu "
				+ "tiên có kinh nghiệm dạy kèm,");
		content.enter();
		content.writeLine("học nhóm.");
		content.enter();
		content.writeLine("3.   Phù hợp các yêu cầu khác về Gia sư của phụ huynh, học sinh.");
		content.enter();
		content.enter();
		content.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		content.writeLine("•    Chọn Gia sư Đại học Bách khoa - phụ huynh, học sinh không chỉ chọn người dạy kèm mà "
				+ "còn chọn");
		content.enter();
		content.writeLine("cho mình người bạn để chia sẻ, truyền lửa học tập, tư vấn hướng nghiệp ... ");
		content.enter();
		content.writeLine("•    Miễn phí cho phụ huynh - học sinh dịch vụ tư vấn, giới thiệu gia sư khi đăng ký tại Trung tâm. ");
		content.enter();
		content.writeLine("•    Trung tâm thường xuyên trao đổi, tiếp nhận phản hồi của phụ huynh, học sinh về chất lượng Gia "
				+ "sư,");
		content.enter();
		content.writeLine(" theo dõi tư cách Gia sư - quản lý sinh viên của nhà trường. ");
		
		for (TextLine i:content.getListTextData()) {
			g.setFont(i.getFont());
			g.drawString(i.getText(), (int)i.getX(), (int)i.getY());
		}
		return PAGE_EXISTS;
	}

}
