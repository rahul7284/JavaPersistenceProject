package com.practise;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="t_user")
public class User {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int user_id;
	@Column(name="user_name")
	public String user_name;
	@Column(name="user_password")
	public String user_password;
	@Column(name="user_phonenum")
	public String user_phonenum;
	@OneToOne
	@JoinColumn(name="cart_id")
	public Cart cart_id;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_phonenum() {
		return user_phonenum;
	}
	public void setUser_phonenum(String user_phonenum) {
		this.user_phonenum = user_phonenum;
	}
	public Cart getCart_id() {
		return cart_id;
	}
	public void setCart_id(Cart cart_id) {
		this.cart_id = cart_id;
	}
	
}
