package voter;

public class Voter {
private int aadhar_number;
private Double phone_no;
private String address;
private String email;
private String password;
private String name;
private int vote_status;
public int getAadhar_number() {
	return aadhar_number;
}
public void setAadhar_number(int aadhar_number) {
	this.aadhar_number = aadhar_number;
}
public Double getPhone_no() {
	return phone_no;
}
public void setPhone_no(int phoneNo_Long) {
	this.phone_no = (double) phoneNo_Long;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getVote_status() {
	return vote_status;
}
public void setVote_status(int vote_status) {
	this.vote_status = vote_status;
}

}
