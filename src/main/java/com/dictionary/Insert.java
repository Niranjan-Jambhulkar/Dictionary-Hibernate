package com.dictionary;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Insert {
	static String word;
	static String meaning;
	
	public Insert(String word, String meaning) {
		this.word = word;
		this.meaning = meaning;
	}
	
	public Insert() {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		//System.out.println(word +" " + meaning);
		Dictionary dt = new Dictionary(word, meaning);
		session.save(dt);
		tx.commit();
		session.close();
		factory.close();
	
	}
}
