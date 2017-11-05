package com.practise;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.practise.UserLoginModel;

public class HiberMain {
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration().configure("hi.cfg.xml");
		System.out.println("name");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();
		/*User user = new User();
		Cart cart = new Cart();
		cart.setId(4);
		cart.setName("poli");
		cart.setPrice(500);
		user.setUser_id(4);
		user.setUser_name("shmi");
		user.setUser_password("pasi");
		user.setUser_phonenum("99342938");
		user.setCart_id(cart);
		
		session.save(user);*/
		getData(session);
		//txn.commit();
	}

	private static void getData(Session session) {
		
		UserLoginModel userLogin = new UserLoginModel();
		UserAttributesModel userattr = new UserAttributesModel();
		/*userLogin=(UserLoginModel) session.createCriteria(UserLoginModel.class).add(Restrictions.eq("userName", "m")).add(Restrictions.eq("userPassword", "p")).uniqueResult();
		System.out.println(userLogin.getId());
		Long login_id = userLogin.getId();
		userattr=(UserAttributesModel) session.createCriteria(UserAttributesModel.class).add(Restrictions.eq("userLoginModel.id",login_id)).uniqueResult();
		*/
		//System.out.println(userattr.getFirstName()+" "+userattr.getUserLoginModel().getUserName());
		Criteria criteria = session.createCriteria(UserAttributesModel.class, "user");
		criteria.setFetchMode("user.login_id", FetchMode.JOIN);
		//criteria.createAlias("user.cart_id", "cart");
		@SuppressWarnings("unchecked")
		List<UserAttributesModel> userlist = criteria.list();
			for (Iterator iterator = userlist.iterator(); iterator.hasNext();) {
				UserAttributesModel userAttributesModel = (UserAttributesModel) iterator.next();
			
				System.out.println(userAttributesModel.getFirstName()+ " "+ userAttributesModel.getUserLoginModel().getUserName());
				
			}
	}

}
