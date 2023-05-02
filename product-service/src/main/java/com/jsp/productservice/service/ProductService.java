package com.jsp.productservice.service;

import java.util.List;

import com.jsp.productservice.entity.ProductEntity;

public interface ProductService {
	public ProductEntity saveProduct(ProductEntity entity);

	public ProductEntity findProductById(Long id);

	public List<ProductEntity> findAllProduct();

	public Integer findProductQuantityById(Long id);

	public ProductEntity deleteProductbyId(Long id);

	public ProductEntity product(ProductEntity productEntity);

	public List<ProductEntity> findAllProductSortedByName();

}
