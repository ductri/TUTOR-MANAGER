package model;

public class Letter {
	String name;
	String mssv;
	String std;
	String email;
	String quequan;
	String diachi;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQuequan() {
		return quequan;
	}
	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public Letter(String name, String mssv, String std, String email,
			String quequan, String diachi) {
		super();
		this.name = name;
		this.mssv = mssv;
		this.std = std;
		this.email = email;
		this.quequan = quequan;
		this.diachi = diachi;
	}
	
}
