package com.practise;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.practise.UserLoginModel;

@Entity
@Table(name="userAttributes")
public class UserAttributesModel {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	@Column(name="first_name")
	public String firstName;
	@Column(name="last_name")
	public String lastName;
	@Column(name="phone_num")
	public String phoneNumber;
	@Column(name="st_number")
	public String streetNumber;
	@Column(name="add_line1")
	public String addressLine1;
	@Column(name="add_line2")
	public String addressLine2;
	@Column(name="city")
	public String city;
	@Column(name="username")
	public String userName;
	@Column(name="password")
	public String userPassword;
	@OneToOne
	@JoinColumn(name = "login_id")
	public UserLoginModel userLoginModel;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public UserLoginModel getUserLoginModel() {
		return userLoginModel;
	}
	public void setUserLoginModel(UserLoginModel userLoginModel) {
		this.userLoginModel = userLoginModel;
	}
}

