package com.practise.test;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="address_test")
public class Address {
	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	@Column(name="lineone")
	private String lineone;
	@Column(name="linelast")
	private String linelast;
	@ManyToOne
	@JoinColumn(name="fk_emp")
	private Employee employee;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLineone() {
		return lineone;
	}
	public void setLineone(String lineone) {
		this.lineone = lineone;
	}
	public String getLinelast() {
		return linelast;
	}
	public void setLinelast(String linelast) {
		this.linelast = linelast;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
