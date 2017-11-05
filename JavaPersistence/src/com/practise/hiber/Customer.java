package com.practise.hiber;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="t_customer")
public class Customer {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	@Column(name="cust_name")
	private String name;
	@OneToMany
	@JoinColumn(name="add_fk")
	private List<CustomerAddress> customerAddress;
	
	@OneToMany
	@JoinColumn(name="card_fk")
	private List<MoneyCards> moneyCards;
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public List<CustomerAddress> getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(List<CustomerAddress> customerAddress) {
		this.customerAddress = customerAddress;
	}

	public List<MoneyCards> getMoneyCards() {
		return moneyCards;
	}

	public void setMoneyCards(List<MoneyCards> moneyCards) {
		this.moneyCards = moneyCards;
	}

	
}
