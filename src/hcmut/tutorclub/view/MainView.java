package hcmut.tutorclub.view;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.google.gdata.util.ServiceException;

import hcmut.tutorclub.controller.IClassManagerController;
import hcmut.tutorclub.controller.IPrinterController;
import hcmut.tutorclub.model.classmanager.Class;
import hcmut.tutorclub.model.printer.CoverLetter;
import hcmut.tutorclub.model.printer.Letter;
//TODO validate input
public class MainView implements IMainView{
	
	private JFrame frmMain;
	
	/****************************************
	 *                                       *
	 *        --- TABS --- 
	 *                                       *
	 ****************************************/
	JTabbedPane tabbedPane_Main;
	//--- Tab font letter ---
	private JTextField textTab1Hoten;
	private JTextField textTab1MSSV;
	private JTextField textTab1Sdt;
	private JTextField textTab1Email;
	private JTextField textTab1Quequan;
	private JTextField textTab1Noio;
	
	//--- Tab back letter ---
	private JTextField textTab2Ten;
	private JTextField textTab2Diachi;
	private JTextField textTab2Sdt;
	
	//--- Tab class manager ---
	private JLayeredPane layeredPane_ClassManager;
	private JScrollPane scrollPane;
	private JTable table;
	private String[] headers = new String[] {"ID","Tên phụ huynh", "Lớp"};
	private String[][] data = new String[5][];
	
	/****************************************
	 *                                       *
	 *   --- Button (used to set event) --- 
	 *                                       *
	 ****************************************/
	private JButton buttonTab1In;
	private JButton buttonInMtSau;
	private JButton buttonTab2In;
	
	/****************************************
	 *                                       *
	 *        --- CONTROLLER --- 
	 *                                       *
	 ****************************************/
	private IPrinterController printerController;
	private IClassManagerController classManagerController;
	
		
	private void initialEventProcess() {
		buttonTab1In.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Letter letter = new Letter(textTab1Hoten.getText(),
						textTab1MSSV.getText(), textTab1Sdt.getText(),
						textTab1Email.getText(), textTab1Quequan.getText(),
						textTab1Noio.getText());
				printerController.printFrontLetter(letter);
			}
		});
		
		buttonInMtSau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printerController.printBackLetter();
				
			}
		});
		
		buttonTab2In.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				printerController.printCoverLetter(new CoverLetter(textTab2Ten.getText(),
						textTab2Diachi.getText(), textTab2Sdt.getText()));
			}
		});

		tabbedPane_Main.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (tabbedPane_Main.getSelectedIndex() == 3) {
					if (classManagerController != null) {
						if (!classManagerController.isAuthorization()) {
							try {
								classManagerController.authorize();
								List<Class> classes = classManagerController.findClassNotHandOver();
								
								int i=0;
								for (Class classEntry:classes) {
									data[i] = new String[3];
									data[i][0]=classEntry.getId();
									data[i][1]=classEntry.getParentName();
									data[i][2]=classEntry.getGrade();
									i++;
								}
								
								table=new JTable(data,headers);
								scrollPane.setViewportView(table);
								
							} catch (IOException | GeneralSecurityException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ServiceException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		});
	}

	private void setValidateInput() {
		
		textTab2Ten.addKeyListener(new KeyAdapter() {			
			@Override
			public void keyTyped(KeyEvent e) {
				if (textTab2Ten.getText().length()>33)
					textTab2Ten.setText(textTab2Ten.getText().substring(0, 32));
			}
		});
		
		textTab2Diachi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textTab2Diachi.getText().length()>42)
					textTab2Diachi.setText(textTab2Diachi.getText().substring(0, 42));
			}
		});
		
		textTab2Sdt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (textTab2Sdt.getText().length()>45)
					textTab2Sdt.setText(textTab2Sdt.getText().substring(0,45));
			}
		});
	}
	
	private void initializeInterface() {
		frmMain = new JFrame();
		InputStream input = getClass().getResourceAsStream("/LogoBK_icon.png");
		
		frmMain.setIconImage(new ImageIcon("LogoBK_icon.png").getImage());
		
		try {
			frmMain.setIconImage(ImageIO.read(input));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmMain.setFont(new Font("Consolas", Font.PLAIN, 12));
		frmMain.setTitle("MẪU IN GIAO/NHẬN LỚP - CLB Gia sư ĐH BK");
		frmMain.setBounds(100, 100, 600, 433);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"B\u1EA3n quy\u1EC1n thu\u1ED9c v\u1EC1 CLB Gia s\u01B0 \u0110H B\u00E1ch Khoa");
		lblNewLabel.setBounds(10, 369, 512, 14);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		frmMain.getContentPane().add(lblNewLabel);

		tabbedPane_Main = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_Main.setBounds(10, 11, 574, 347);
		tabbedPane_Main.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				textTab1Hoten.requestFocus();
			}
		});
		tabbedPane_Main.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		frmMain.getContentPane().add(tabbedPane_Main);

		JLayeredPane layeredPane_FrontLetter = new JLayeredPane();
		tabbedPane_Main.addTab("Thư giới thiệu -Mặt trước", null, layeredPane_FrontLetter, null);
		layeredPane_FrontLetter.setLayout(null);

		JLabel lblHTnSv = new JLabel("Họ tên SV:");
		lblHTnSv.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHTnSv.setBounds(12, 73, 79, 32);
		layeredPane_FrontLetter.add(lblHTnSv);

		textTab1Hoten = new JTextField();
		textTab1Hoten.setFont(new Font("Consolas", Font.PLAIN, 14));
		textTab1Hoten.setBounds(101, 73, 396, 32);
		layeredPane_FrontLetter.add(textTab1Hoten);
		textTab1Hoten.setColumns(10);

		JLabel lblMssv = new JLabel("MSSV:");
		lblMssv.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMssv.setBounds(12, 107, 79, 34);
		layeredPane_FrontLetter.add(lblMssv);

		JLabel lblinThoi = new JLabel("Điện thoại:");
		lblinThoi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblinThoi.setBounds(12, 147, 79, 32);
		layeredPane_FrontLetter.add(lblinThoi);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblEmail.setBounds(264, 147, 50, 32);
		layeredPane_FrontLetter.add(lblEmail);

		JLabel lblQuQun = new JLabel("Quê quán:");
		lblQuQun.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblQuQun.setBounds(12, 183, 79, 32);
		layeredPane_FrontLetter.add(lblQuQun);

		JLabel lblNiHin = new JLabel("Nơi ở hiện nay:");
		lblNiHin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNiHin.setBounds(12, 220, 100, 32);
		layeredPane_FrontLetter.add(lblNiHin);

		buttonTab1In = new JButton("In");
		
		buttonTab1In.setFont(new Font("Consolas", Font.PLAIN, 20));
		buttonTab1In.setBounds(12, 263, 485, 42);
		layeredPane_FrontLetter.add(buttonTab1In);

		textTab1MSSV = new JTextField();
		textTab1MSSV.setFont(new Font("Consolas", Font.PLAIN, 14));
		textTab1MSSV.setColumns(10);
		textTab1MSSV.setBounds(101, 109, 396, 32);
		layeredPane_FrontLetter.add(textTab1MSSV);

		textTab1Sdt = new JTextField();
		textTab1Sdt.setFont(new Font("Consolas", Font.PLAIN, 14));
		textTab1Sdt.setColumns(10);
		textTab1Sdt.setBounds(101, 147, 117, 32);
		layeredPane_FrontLetter.add(textTab1Sdt);

		textTab1Email = new JTextField();
		textTab1Email.setFont(new Font("Consolas", Font.PLAIN, 14));
		textTab1Email.setColumns(10);
		textTab1Email.setBounds(314, 147, 183, 32);
		layeredPane_FrontLetter.add(textTab1Email);

		textTab1Quequan = new JTextField();
		textTab1Quequan.setFont(new Font("Consolas", Font.PLAIN, 14));
		textTab1Quequan.setColumns(10);
		textTab1Quequan.setBounds(101, 183, 396, 32);
		layeredPane_FrontLetter.add(textTab1Quequan);

		textTab1Noio = new JTextField();
		textTab1Noio.setFont(new Font("Consolas", Font.PLAIN, 14));
		textTab1Noio.setColumns(10);
		textTab1Noio.setBounds(101, 220, 396, 32);
		layeredPane_FrontLetter.add(textTab1Noio);

		JLabel lblMtIn = new JLabel("Lưu ý: Mặt in để ngửa");
		lblMtIn.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));
		lblMtIn.setBounds(47, 24, 450, 25);
		layeredPane_FrontLetter.add(lblMtIn);
		
		JLayeredPane layeredPane_BackLetter = new JLayeredPane();
		tabbedPane_Main.addTab("Thư giới thiệu - Mặt sau", null, layeredPane_BackLetter, null);
		
		buttonInMtSau = new JButton("In mặt sau");
		
		buttonInMtSau.setFont(new Font("Consolas", Font.PLAIN, 30));
		buttonInMtSau.setBounds(10, 95, 495, 104);
		layeredPane_BackLetter.add(buttonInMtSau);

		JLayeredPane layeredPane_CoverLetter = new JLayeredPane();
		tabbedPane_Main.addTab("Bìa thư", null, layeredPane_CoverLetter, null);

		JLabel lblaPhnCh = new JLabel("2. Đưa phần chữ \"Kính gửi\" vào trước!");
		lblaPhnCh.setBounds(45, 39, 371, 23);
		layeredPane_CoverLetter.add(lblaPhnCh);
		lblaPhnCh.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));

		JLabel lblHTnPh = new JLabel("Họ tên phụ huynh:");
		lblHTnPh.setBounds(20, 100, 106, 30);
		layeredPane_CoverLetter.add(lblHTnPh);
		lblHTnPh.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		textTab2Ten = new JTextField();
		
		
		textTab2Ten.setBounds(127, 100, 370, 30);
		layeredPane_CoverLetter.add(textTab2Ten);
		textTab2Ten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTab2Ten.setColumns(10);

		textTab2Diachi = new JTextField();
		
		textTab2Diachi.setBounds(127, 133, 370, 30);
		layeredPane_CoverLetter.add(textTab2Diachi);
		textTab2Diachi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTab2Diachi.setColumns(10);

		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setBounds(20, 133, 97, 30);
		layeredPane_CoverLetter.add(lblaCh);
		lblaCh.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		JLabel lblSt = new JLabel("Sđt:");
		lblSt.setBounds(20, 166, 97, 30);
		layeredPane_CoverLetter.add(lblSt);
		lblSt.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		textTab2Sdt = new JTextField();
		
		textTab2Sdt.setBounds(127, 166, 370, 30);
		layeredPane_CoverLetter.add(textTab2Sdt);
		textTab2Sdt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textTab2Sdt.setColumns(10);

		buttonTab2In = new JButton("In");
		buttonTab2In.setBounds(20, 207, 477, 42);
		
		layeredPane_CoverLetter.add(buttonTab2In);
		
		buttonTab2In.setFont(new Font("Consolas", Font.PLAIN, 20));

		JLabel lblMtIn_1 = new JLabel("1. Mặt in để ngửa");
		lblMtIn_1.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 14));
		lblMtIn_1.setBounds(45, 14, 371, 30);
		layeredPane_CoverLetter.add(lblMtIn_1);
		
		layeredPane_ClassManager = new JLayeredPane();
		tabbedPane_Main.addTab("Quản lý lớp", null, layeredPane_ClassManager, null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 572, 305);
		layeredPane_ClassManager.add(scrollPane);
		
		
		
		
	}

	/**
	 * Constructor.
	 */
	public MainView() {
		initializeInterface();
		initialEventProcess();
		setValidateInput();
	}
	
	@Override
	public void show() {
		if (frmMain != null)
			frmMain.setVisible(true);
	}
	
	@Override
	public void setPrinterController(IPrinterController printerController) {
		
		this.printerController = printerController;
	}

	@Override
	public void setClassManagerController(IClassManagerController classManagerController) {
		
		this.classManagerController = classManagerController;
	}
}
