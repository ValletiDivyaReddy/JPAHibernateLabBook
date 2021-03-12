package com.cg.jhlb1.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.jhlb1.entity.Author;
import com.cg.jhlb1.util.JPAUtil;

public class App01 {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();
		Author a1 = new Author("Divya", "Reddy", "Valleti", "77880290088");
		Author a2 = new Author("Navya", "Reddy", "Valleti", "90744547253");
		Author a3 = new Author("Jaya", "Reddy", "Valleti", "54931603727");

		EntityTransaction txn = em.getTransaction();
		txn.begin();

		em.persist(a1);
		em.persist(a2);
		em.persist(a3);

		txn.commit();
		em.close();

	}

}
