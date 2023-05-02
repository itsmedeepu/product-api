package com.jsp.productservice.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.productservice.entity.ProductEntity;
import com.jsp.productservice.repositoryimpl.ProductServiceReposiotryImpl;
import com.jsp.productservice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductServiceReposiotryImpl productServiceReposiotryImpl;

	@Override
	public ProductEntity saveProduct(ProductEntity entity) {
		return productServiceReposiotryImpl.saveProduct(entity);
	}

	@Override
	public ProductEntity findProductById(Long id) {

		return productServiceReposiotryImpl.findProductById(id);
	}

	@Override
	public List<ProductEntity> findAllProduct() {

		return productServiceReposiotryImpl.findAllProduct();
	}

	@Override
	public Integer findProductQuantityById(Long id) {
		return productServiceReposiotryImpl.findProductQuantityById(id);
	}

	@Override
	public ProductEntity deleteProductbyId(Long id) {
		return productServiceReposiotryImpl.deleteProductbyId(id);
	}

	@Override
	public ProductEntity product(ProductEntity productEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductEntity> findAllProductSortedByName() {
		// TODO Auto-generated method stub
		return null;
	}

}
