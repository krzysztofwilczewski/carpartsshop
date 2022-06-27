package com.wilczewski.carpartsshop.service;

import com.wilczewski.carpartsshop.entity.Product;
import com.wilczewski.carpartsshop.exception.ProductNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    public List<Product> listAll();

    public Product save(Product product);

    public String checkUnique(Integer id, String name);

    public void updateProductEnabledStatus(Integer id, boolean enabled);

    public void delete(Integer id) throws ProductNotFoundException;

    public Product get(Integer id) throws ProductNotFoundException;

    public Page<Product> listByPage(int pageNumber, String sortField, String sortDir, String keyword, Integer categoryId);

    public void saveProductPrice(Product productInForm);
}
