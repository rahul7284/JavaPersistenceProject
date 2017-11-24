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
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.practise.UserAttributesModel;
import com.practise.UserLoginModel;
import com.practise.hiber.Customer;
import com.practise.hiber.CustomerAddress;

public class HiberEmpMany {
	public static void main(String[] args) {

		Configuration cfg = new AnnotationConfiguration().configure("hi.cfg.xml");
		System.out.println("customer changed for Git");
		System.out.println("changes made from different branch");
		
		for (int i = 0; i < 2; i++) {

			System.out.println("New Local Branch");
		}
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		 Transaction txn = session.beginTransaction();
		getData(session);
		System.out.println("it is now showing data");
		//insertData(session, txn);

	}

	private static void insertData(Session session, Transaction txn) {
		Employee emp = new Employee();
		Address add = new Address();
		Address add1 = new Address();
		Projects proj1 = new Projects();
		Projects proj2 = new Projects();
		emp.setFirstName("rahul");
		emp.setLastName("kumar");
		add.setLineone("jabalpur");
		add.setLinelast("mp");
		add1.setLineone("manjari");
		add1.setLinelast("pune");
		proj1.setProjectName("mtp");
		proj1.setClientName("mumbaipolice");
		proj1.setTechName("java");
		proj2.setProjectName("atms");
		proj2.setClientName("xrbia");
		proj2.setTechName("java");
		List<Address> addlist = new ArrayList<Address>();
		List<Projects> projectList = new ArrayList<Projects>();
		addlist.add(add1);
		addlist.add(add);
		projectList.add(proj1);
		projectList.add(proj2);
		emp.setAddress(addlist);
		emp.setProjects(projectList);
		add.setEmployee(emp);
		add1.setEmployee(emp);
		proj1.setEmployee(emp);
		proj2.setEmployee(emp);
		session.save(emp);
		 session.save(add); 
		 session.save(add1);
		 session.save(proj1); 
		 session.save(proj2);
		
		 session.flush();
		 txn.commit();
	}

	@SuppressWarnings("static-access")
	private static void getData(Session session) {

		
		Criteria criteria = session.createCriteria(Address.class,"address");
		criteria.createAlias("address.employee", "emp");
		criteria.add(Restrictions.eqOrIsNull("id", 13)).setFetchMode("emp", FetchMode.JOIN);
		
		System.out.println(criteria.list());

		for (Iterator iterator = criteria.list().iterator(); iterator.hasNext();) {
			Address customerAddress =   (Address) iterator.next();
			System.out.println(customerAddress);
			
		}
		// customerAdd=(CustomerAddress) criteria.uniqueResult();

		session.close();
	}

}
