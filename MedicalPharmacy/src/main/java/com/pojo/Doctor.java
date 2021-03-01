package com.pojo;

public class Doctor {
private int drID;
private String firstName;
private String lastName;
private String drQualification;
private String drLicence;
/**
 * @return the drID
 */
public int getDrID() {
	return drID;
}
/**
 * @param drID the drID to set
 */
public void setDrID(int drID) {
	this.drID = drID;
}

/**
 * @return the firstName
 */
public String getFirstName() {
	return firstName;
}
/**
 * @param firstName the firstName to set
 */
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
/**
 * @return the lastName
 */
public String getLastName() {
	return lastName;
}
/**
 * @param lastName the lastName to set
 */
public void setLastName(String lastName) {
	this.lastName = lastName;
}
/**
 * @return the drQualification
 */
public String getDrQualification() {
	return drQualification;
}
/**
 * @param drQualification the drQualification to set
 */
public void setDrQualification(String drQualification) {
	this.drQualification = drQualification;
}
/**
 * @return the drLicence
 */
public String getDrLicence() {
	return drLicence;
}
/**
 * @param drLicence the drLicence to set
 */
public void setDrLicence(String drLicence) {
	this.drLicence = drLicence;
}
/*  
 */
@Override
public String toString() {
	return "Doctor [drID=" + drID + ", firstName=" + firstName + ", lastName=" + lastName + ", drQualification="
			+ drQualification + ", drLicence=" + drLicence + "]";
}


}
