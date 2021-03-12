package com.cg.jhlb1.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.jhlb1.entity.Author;
import com.cg.jhlb1.util.JPAUtil;

public class App02 {

	public static void main(String[] args) {
		EntityManager em = JPAUtil.getEntityManager();

		Scanner scan = new Scanner(System.in);
		System.out.println("enter author id:");
		Long authorId = scan.nextLong();
		System.out.println("enter firstName to update:");
		String firstName = scan.next();

		Author author = em.find(Author.class, authorId);
		if (author == null) {
			System.out.println("author with id #" + authorId + "not found");
		} else {
			EntityTransaction txn = em.getTransaction();
			txn.begin();
			author.setFirstName(firstName);
			em.merge(author);
			txn.commit();

		}
		scan.close();
		em.close();

	}

}
