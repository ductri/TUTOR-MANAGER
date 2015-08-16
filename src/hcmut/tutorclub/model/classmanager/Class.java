package hcmut.tutorclub.model.classmanager;

public class Class {
	private String id;
	private String parentName;
	private String sex;
	private String adddress;
	private String dateReceive;
	private String dateHandOver;
	private String salary;
	private String schedule;
	private String demain;
	private int fee;
	private String handOverPerson;
	private String others;
	private Student studentTaken;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAdddress() {
		return adddress;
	}
	public void setAdddress(String adddress) {
		this.adddress = adddress;
	}
	public String getDateReceive() {
		return dateReceive;
	}
	public void setDateReceive(String dateReceive) {
		this.dateReceive = dateReceive;
	}
	public String getDateHandOver() {
		return dateHandOver;
	}
	public void setDateHandOver(String dateHandOver) {
		this.dateHandOver = dateHandOver;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getDemain() {
		return demain;
	}
	public void setDemain(String demain) {
		this.demain = demain;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public Student getStudentTaken() {
		return studentTaken;
	}
	public void setStudentTaken(Student studentTaken) {
		this.studentTaken = studentTaken;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getHandOverPerson() {
		return handOverPerson;
	}
	public void setHandOverPerson(String handOverPerson) {
		this.handOverPerson = handOverPerson;
	}
	
}
