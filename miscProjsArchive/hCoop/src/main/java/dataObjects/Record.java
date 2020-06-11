package dataObjects;

import java.io.Serializable;

public class Record implements Serializable {
	private String id;
	private String department_id; // fk
	private String pos_id; // fk
	private String employee_name;
	private String kana_name;
	private String sex;
	private String birthdate;
	private String address;
	private String fixed_line_phone;
	private String mobile_phone;
	private String email;
	private String hired_date;
	private String department_name;
	private String pos_name;

	@Override
	public String toString() {
		return (id + " " + department_id + " " + pos_id + " " + employee_name + " " + kana_name + " " + sex + " "
				+ birthdate + " " + address + " " + fixed_line_phone + " " + mobile_phone + " " + email + " "
				+ hired_date + " " + department_name + " " + pos_name +"\n");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}

	public String getPosition_id() {
		return pos_id;
	}

	public void setPosition_id(String position_id) {
		this.pos_id = position_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getKana_name() {
		return kana_name;
	}

	public void setKana_name(String kana_name) {
		this.kana_name = kana_name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFixed_line_phone() {
		return fixed_line_phone;
	}

	public void setFixed_line_phone(String fixed_line_phone) {
		this.fixed_line_phone = fixed_line_phone;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHired_date() {
		return hired_date;
	}

	public void setHired_date(String hired_date) {
		this.hired_date = hired_date;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getPosition_name() {
		return pos_name;
	}

	public void setPosition_name(String position_name) {
		this.pos_name = position_name;
	}
}
