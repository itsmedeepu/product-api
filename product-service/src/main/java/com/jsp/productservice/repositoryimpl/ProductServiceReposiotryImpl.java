package com.jsp.productservice.repositoryimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.jsp.productservice.entity.ProductEntity;
import com.jsp.productservice.repository.ProductRepository;
import com.jsp.productservice.service.ProductService;
import com.jsp.productservice.util.SessionFactoryUtil;

@Repository
public class ProductServiceReposiotryImpl implements ProductRepository {

	@Override
	public ProductEntity saveProduct(ProductEntity productentity) {

		SessionFactory sessionFactory = SessionFactoryUtil.getFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		ProductEntity merge = (ProductEntity) session.merge(productentity);

		transaction.commit();

		return merge;
	}

	@Override
	public ProductEntity findProductById(Long id) {
		SessionFactory sessionFactory = SessionFactoryUtil.getFactory();
		Session session = sessionFactory.openSession();
		String query = "from ProductEntity where altkey=:id";

		Query query2 = session.createQuery(query);
		query2.setParameter("id", id);
		ProductEntity productentity = (ProductEntity) query2.getSingleResult();
		return productentity;

	}

	@Override
	public List<ProductEntity> findAllProduct() {
		SessionFactory sessionFactory = SessionFactoryUtil.getFactory();
		Session session = sessionFactory.openSession();
		String query = "from ProductEntity";
		Query query2 = session.createQuery(query);
		List<ProductEntity> list = query2.getResultList();
		return list;
	}

	@Override
	public Integer findProductQuantityById(Long id) {
		SessionFactory sessionFactory = SessionFactoryUtil.getFactory();
		Session session = sessionFactory.openSession();
		String query = "select quantity from ProductEntity where altkey=:id";

		Query query2 = session.createQuery(query);
		query2.setParameter("id", id);
		Object quantity = query2.uniqueResult();
		String string = quantity.toString();
		Integer qu = (Integer) Integer.parseInt(string);
		return qu;

	}

	@Override
	public ProductEntity deleteProductbyId(Long id) {
		SessionFactory sessionFactory = SessionFactoryUtil.getFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String query = "delete from ProductEntity where altkey=:id";
		Query query2 = session.createQuery(query);
		query2.setParameter("id", id);
		ProductEntity productById = findProductById(id);
		query2.executeUpdate();
		transaction.commit();
		return productById;

	}

	@Override
	public ProductEntity product(ProductEntity productEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
