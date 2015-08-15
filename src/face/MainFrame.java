package face;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PageRanges;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.BackLetter;
import com.CoverLetterPrinter;
import com.LetterPrinter;

import model.CoverLetter;
import model.Letter;

public class MainFrame {

	PrinterJob job;
	PageFormat pageFormat;

	/**
	 * Launch the application.
	 */
	private JFrame frmMuInPhng;
	private JTextField textTab2Ten;
	private JTextField textTab2Diachi;
	private JTextField textTab2Sdt;
	private JLabel lblaPhnCh;
	private JLabel lblNewLabel;
	private JTabbedPane tabbedPane;
	private JLayeredPane layeredPane;
	private JLayeredPane layeredPane_1;
	private JLabel lblHTnSv;
	private JTextField textTab1Hoten;
	private JTextField textTab1MSSV;
	private JTextField textTab1Sdt;
	private JTextField textTab1Email;
	private JTextField textTab1Quequan;
	private JTextField textTab1Noio;
	private JLabel lblMtIn;
	private JLabel lblMtIn_1;

	private double A5_WIDTH = 419.76;
	private double A5_HEIGHT = 595.44;
	private JLayeredPane layeredPane_2;
	private JButton btnInMtSau;

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();

	}

	private void printCoverLetter(CoverLetter coverLetter) {
		if (textTab2Ten.getText().isEmpty())
			JOptionPane.showMessageDialog(frmMuInPhng, "Chưa điền tên phụ huynh!");
		else {
			job=PrinterJob.getPrinterJob();
			PrintRequestAttributeSet attSet=new HashPrintRequestAttributeSet();
			
			attSet.add(new Copies(1));
			attSet.add(MediaSizeName.ISO_A5);
			attSet.add(new PageRanges(1));
			
			
			Paper paper = new Paper();
			paper.setSize(A5_WIDTH, A5_HEIGHT);
			PageFormat pf = new PageFormat();
			pf.setPaper(paper);
			pf.setOrientation(PageFormat.LANDSCAPE);
			
			job.setPrintable(new CoverLetterPrinter(coverLetter), pf);
			
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
	}

	private void printLetter(Letter letter) {
		
		//DocFlavor myFormat = DocFlavor.READER.TEXT_PLAIN;
		
		PrintRequestAttributeSet attSet=new HashPrintRequestAttributeSet();
		attSet.add(new Copies(1));
		attSet.add(MediaSizeName.ISO_A5);
		attSet.add(new PageRanges(1));
		
		PrinterJob job = PrinterJob.getPrinterJob();

		
		job.setCopies(1);
		
		Paper paper = new Paper();
		paper.setSize(A5_WIDTH, A5_HEIGHT);
		
		PageFormat pf = new PageFormat();
		pf.setPaper(paper);
		pf.setOrientation(PageFormat.LANDSCAPE);
		
		job.setPrintable(new LetterPrinter(letter), pf);
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

	private void printBackLetter()
	{
		PrintRequestAttributeSet attSet=new HashPrintRequestAttributeSet();
		attSet.add(new Copies(1));
		attSet.add(MediaSizeName.ISO_A5);
		attSet.add(new PageRanges(1));
		
		PrinterJob job = PrinterJob.getPrinterJob();

		job.setCopies(1);
		
		Paper paper = new Paper();
		paper.setSize(A5_WIDTH, A5_HEIGHT);
		
		PageFormat pf = new PageFormat();
		pf.setPaper(paper);
		pf.setOrientation(PageFormat.LANDSCAPE);
		
		job.setPrintable(new BackLetter(), pf);
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
	/**
	 * 
Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMuInPhng = new JFrame();
		InputStream input = getClass().getResourceAsStream("/LogoBK_icon.png");
		
		frmMuInPhng.setIconImage(new ImageIcon("LogoBK_icon.png").getImage());
		
		
		
		try {
			frmMuInPhng.setIconImage(ImageIO.read(input));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmMuInPhng.setFont(new Font("Consolas", Font.PLAIN, 12));
		frmMuInPhng.setTitle("MẪU IN GIAO/NHẬN LỚP - CLB Gia sư ĐH BK");
		frmMuInPhng.setBounds(100, 100, 569, 433);
		frmMuInPhng.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMuInPhng.getContentPane().setLayout(null);

		lblNewLabel = new JLabel(
				"B\u1EA3n quy\u1EC1n thu\u1ED9c v\u1EC1 CLB Gia s\u01B0 \u0110H B\u00E1ch Khoa");
		lblNewLabel.setBounds(10, 369, 512, 14);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		frmMuInPhng.getContentPane().add(lblNewLabel);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 520, 347);
		tabbedPane.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				textTab1Hoten.requestFocus();
			}
		});
		tabbedPane.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmMuInPhng.getContentPane().add(tabbedPane);

		layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Thư giới thiệu -Mặt trước", null, layeredPane_1, null);
		layeredPane_1.setLayout(null);

		lblHTnSv = new JLabel("Họ tên SV:");
		lblHTnSv.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHTnSv.setBounds(12, 73, 79, 32);
		layeredPane_1.add(lblHTnSv);

		textTab1Hoten = new JTextField();
		textTab1Hoten.setFont(new Font("Consolas", Font.PLAIN, 14));
		textTab1Hoten.setBounds(101, 73, 396, 32);
		layeredPane_1.add(textTab1Hoten);
		textTab1Hoten.setColumns(10);

		JLabel lblMssv = new JLabel("MSSV:");
		lblMssv.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMssv.setBounds(12, 107, 79, 34);
		layeredPane_1.add(lblMssv);

		JLabel lblinThoi = new JLabel("Điện thoại:");
		lblinThoi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblinThoi.setBounds(12, 147, 79, 32);
		layeredPane_1.add(lblinThoi);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmail.setBounds(264, 147, 50, 32);
		layeredPane_1.add(lblEmail);

		JLabel lblQuQun = new JLabel("Quê quán:");
		lblQuQun.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblQuQun.setBounds(12, 183, 79, 32);
		layeredPane_1.add(lblQuQun);

		JLabel lblNiHin = new JLabel("Nơi ở hiện nay:");
		lblNiHin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNiHin.setBounds(12, 220, 100, 32);
		layeredPane_1.add(lblNiHin);

		JButton buttonTab1In = new JButton("In");
		buttonTab1In.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letter letter = new Letter(textTab1Hoten.getText(),
						textTab1MSSV.getText(), textTab1Sdt.getText(),
						textTab1Email.getText(), textTab1Quequan.getText(),
						textTab1Noio.getText());
				printLetter(letter);
			}
		});
		buttonTab1In.setFont(new Font("Consolas", Font.PLAIN, 20));
		// button.setUI(new BEButtonUI (). setNormalColor
		// (BEButtonUI.NormalColor.blue));
		buttonTab1In.setBounds(12, 263, 485, 42);
		layeredPane_1.add(buttonTab1In);

		textTab1MSSV = new JTextField();
		textTab1MSSV.setFont(new Font("Consolas", Font.PLAIN, 14));
		textTab1MSSV.setColumns(10);
		textTab1MSSV.setBounds(101, 109, 396, 32);
		layeredPane_1.add(textTab1MSSV);

		textTab1Sdt = new JTextField();
		textTab1Sdt.setFont(new Font("Consolas", Font.PLAIN, 14));
		textTab1Sdt.setColumns(10);
		textTab1Sdt.setBounds(101, 147, 117, 32);
		layeredPane_1.add(textTab1Sdt);

		textTab1Email = new JTextField();
		textTab1Email.setFont(new Font("Consolas", Font.PLAIN, 14));
		textTab1Email.setColumns(10);
		textTab1Email.setBounds(314, 147, 183, 32);
		layeredPane_1.add(textTab1Email);

		textTab1Quequan = new JTextField();
		textTab1Quequan.setFont(new Font("Consolas", Font.PLAIN, 14));
		textTab1Quequan.setColumns(10);
		textTab1Quequan.setBounds(101, 183, 396, 32);
		layeredPane_1.add(textTab1Quequan);

		textTab1Noio = new JTextField();
		textTab1Noio.setFont(new Font("Consolas", Font.PLAIN, 14));
		textTab1Noio.setColumns(10);
		textTab1Noio.setBounds(101, 220, 396, 32);
		layeredPane_1.add(textTab1Noio);

		lblMtIn = new JLabel("Lưu ý: Mặt in để ngửa");
		lblMtIn.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));
		lblMtIn.setBounds(47, 24, 450, 25);
		layeredPane_1.add(lblMtIn);
		
		layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Thư giới thiệu - Mặt sau", null, layeredPane_2, null);
		
		btnInMtSau = new JButton("In mặt sau");
		btnInMtSau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printBackLetter();
				
			}
		});
		btnInMtSau.setFont(new Font("Consolas", Font.PLAIN, 30));
		btnInMtSau.setBounds(10, 95, 495, 104);
		layeredPane_2.add(btnInMtSau);

		layeredPane = new JLayeredPane();
		tabbedPane.addTab("Bìa thư", null, layeredPane, null);

		lblaPhnCh = new JLabel("2. Đưa phần chữ \"Kính gửi\" vào trước!");
		lblaPhnCh.setBounds(45, 39, 371, 23);
		layeredPane.add(lblaPhnCh);
		lblaPhnCh.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));

		JLabel lblHTnPh = new JLabel("Họ tên phụ huynh:");
		lblHTnPh.setBounds(20, 100, 106, 30);
		layeredPane.add(lblHTnPh);
		lblHTnPh.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		textTab2Ten = new JTextField();
		
		textTab2Ten.addKeyListener(new KeyAdapter() {			
			@Override
			public void keyTyped(KeyEvent e) {
				if (textTab2Ten.getText().length()>33)
					textTab2Ten.setText(textTab2Ten.getText().substring(0, 32));
			}
		});
		textTab2Ten.setBounds(127, 100, 370, 30);
		layeredPane.add(textTab2Ten);
		textTab2Ten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTab2Ten.setColumns(10);

		textTab2Diachi = new JTextField();
		textTab2Diachi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textTab2Diachi.getText().length()>42)
					textTab2Diachi.setText(textTab2Diachi.getText().substring(0, 42));
			}
		});
		textTab2Diachi.setBounds(127, 133, 370, 30);
		layeredPane.add(textTab2Diachi);
		textTab2Diachi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTab2Diachi.setColumns(10);

		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setBounds(20, 133, 97, 30);
		layeredPane.add(lblaCh);
		lblaCh.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JLabel lblSt = new JLabel("Sđt:");
		lblSt.setBounds(20, 166, 97, 30);
		layeredPane.add(lblSt);
		lblSt.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		textTab2Sdt = new JTextField();
		textTab2Sdt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textTab2Sdt.getText().length()>45)
					textTab2Sdt.setText(textTab2Sdt.getText().substring(0,45));
			}
		});
		textTab2Sdt.setBounds(127, 166, 370, 30);
		layeredPane.add(textTab2Sdt);
		textTab2Sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTab2Sdt.setColumns(10);

		JButton buttonTab2In = new JButton("In");
		buttonTab2In.setBounds(20, 207, 477, 42);
		// btnNewButton.setUI(new BEButtonUI (). setNormalColor
		// (BEButtonUI.NormalColor.blue));
		layeredPane.add(buttonTab2In);
		buttonTab2In.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				printCoverLetter(new CoverLetter(textTab2Ten.getText(),
						textTab2Diachi.getText(), textTab2Sdt.getText()));
			}
		});
		buttonTab2In.setFont(new Font("Consolas", Font.PLAIN, 20));

		lblMtIn_1 = new JLabel("1. Mặt in để ngửa");
		lblMtIn_1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));
		lblMtIn_1.setBounds(45, 14, 371, 30);
		layeredPane.add(lblMtIn_1);
		frmMuInPhng.setVisible(true);
	}
}
