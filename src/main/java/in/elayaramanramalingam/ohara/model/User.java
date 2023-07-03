package in.elayaramanramalingam.ohara.model;

public class User {
	
	//datatypes and table structure

	int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fName=" + fName + ", sName=" + sName + ", email=" + email + ", phone=" + phone
				+ ", passwd=" + passwd + ", status=" + status + "]";
	}

	String fName;
	String sName;
	String email;
	long phone;
	String passwd;
	boolean status = true;
	
	public String fullName() {
		return fName.concat(" ").concat(sName);
	}
	
}
