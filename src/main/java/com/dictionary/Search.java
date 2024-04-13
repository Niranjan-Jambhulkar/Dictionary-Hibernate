package com.dictionary;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Search {
	static String word;
	
	public Search(String word) {
		this.word = word;
	}
	
	public Search() {
		
	}

	public String SearchMeaning() {
		Configuration cfg = new Configuration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Dictionary result  = session.get(Dictionary.class, word);
		String Meaning = result.getMeaning();
		return Meaning;
	}
	
}
