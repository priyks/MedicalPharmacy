package com.pojo;

import java.util.List;

/**
 * This Class is used to set and get Pharmacy Details , it is a simple java POJO Class
 * @author priyankaku
 *
 */
public class Pharmacy {
  private String name;
  private String licenceNo;
  private String contactNo;
  private String address;
  private List<Doctor> doctorList;

/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @return the doctorList
 */
public List<Doctor> getDoctorList() {
	return doctorList;
}
/**
 * @param doctorList the doctorList to set
 */
public void setDoctorList(List<Doctor> doctorList) {
	this.doctorList = doctorList;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the licenceNo
 */
public String getLicenceNo() {
	return licenceNo;
}
/**
 * @param licenceNo the licenceNo to set
 */
public void setLicenceNo(String licenceNo) {
	this.licenceNo = licenceNo;
}
/**
 * @return the contactNo
 */
public String getContactNo() {
	return contactNo;
}
/**
 * @param contactNo the contactNo to set
 */
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
/**
 * @return the address
 */
public String getAddress() {
	return address;
}
/**
 * @param address the address to set
 */
public void setAddress(String address) {
	this.address = address;
}
  
/* (non-Javadoc)
 *
 */
@Override
public String toString() {
	return "Pharmacy [name=" + name + ", licenceNo=" + licenceNo + ", contactNo=" + contactNo + ", address=" + address
			+ "]";
}
  

}
