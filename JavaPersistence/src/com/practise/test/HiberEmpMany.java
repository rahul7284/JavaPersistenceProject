package com.practise.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.FetchType;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.practise.UserAttributesModel;
import com.practise.UserLoginModel;
import com.practise.hiber.Customer;
import com.practise.hiber.CustomerAddress;

public class HiberEmpMany {
	public static void main(String[] args) {

		Configuration cfg = new AnnotationConfiguration().configure("hi.cfg.xml");
		System.out.println("customer");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		 Transaction txn = session.beginTransaction();
		//getData(session);
		Employee emp = new Employee();
		Address add = new Address();
		Address add1 = new Address();
		
		emp.setFirstName("rashmi");
		emp.setLastName("pyasi");
		add.setLineone("shimla");
		add.setLinelast("himachal");
		add1.setLineone("kuthla");
		add1.setLinelast("katni");
		List<Address> addlist = new ArrayList<Address>();
		addlist.add(add1);
		addlist.add(add);
		emp.setAddress(addlist);
		add.setEmployee(emp);
		add1.setEmployee(emp);
		session.save(emp);
		 session.save(add); 
		 session.save(add1);
		 session.flush();
		 txn.commit();

	}

	private static void getData(Session session) {

		Customer cust = new Customer();
		CustomerAddress customerAdd = new CustomerAddress();
		/*
		 * userLogin=(UserLoginModel)
		 * session.createCriteria(UserLoginModel.class).add(Restrictions.eq(
		 * "userName", "m")).add(Restrictions.eq("userPassword",
		 * "p")).uniqueResult(); System.out.println(userLogin.getId()); Long
		 * login_id = userLogin.getId(); userattr=(UserAttributesModel)
		 * session.createCriteria(UserAttributesModel.class).add(Restrictions.eq
		 * ("userLoginModel.id",login_id)).uniqueResult();
		 */
		// System.out.println(userattr.getFirstName()+"
		// "+userattr.getUserLoginModel().getUserName());

		Criteria criteria = session.createCriteria(CustomerAddress.class);
		criteria.createAlias("customer", "customeraddressalias", org.hibernate.sql.JoinType.INNER_JOIN);
		criteria.add(Restrictions.eq("customeraddressalias.id", 6));
		System.out.println(criteria.list());

		for (Iterator iterator = criteria.list().iterator(); iterator.hasNext();) {
			CustomerAddress customerAddress = (CustomerAddress) iterator.next();

			System.out.print(customerAddress + " ");

		}
		// customerAdd=(CustomerAddress) criteria.uniqueResult();

		session.close();
	}

}
