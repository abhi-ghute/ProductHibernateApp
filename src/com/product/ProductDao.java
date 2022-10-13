package com.product;

import java.io.Serializable;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDao {
	
	public void saveProduct(ProductEntity productEntity) {
		System.out.println(productEntity.getProductName());
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			
			// operation 1
			Object object = session.save(productEntity);
			
			// operation 2
			session.get(ProductEntity.class, (Serializable) object);
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}