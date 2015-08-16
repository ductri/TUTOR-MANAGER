package hcmut.tutorclub.model.classmanager;

//TODO check lai coi du cac field chua ?
public class Student {
//TODO xem lai cac tu tieng anh	
	private String name;
	private String studentId;
	private String major;
	private String year;
	private String phone;
	private String address;
	private String email;
	private String facebook;
	private String voiceRegion;
	private String others;
	
	/****************************************
	 *                                       *
	 *        --- CONSTRUCTOR --- 
	 *                                       *
	 ****************************************/
	
	
	/****************************************
	 *                                       *
	 *        --- GETTER/SETTER --- 
	 *                                       *
	 ****************************************/
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return studentId;
	}
	public void setId(String id) {
		this.studentId = id;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}

	public String getVoiceRegion() {
		return voiceRegion;
	}

	public void setVoiceRegion(String voiceRegion) {
		this.voiceRegion = voiceRegion;
	}
	
	
}
