package com.wilczewski.carpartsshop.service;

import com.wilczewski.carpartsshop.category.CategoryPageInfo;
import com.wilczewski.carpartsshop.entity.Category;
import com.wilczewski.carpartsshop.exception.CategoryNotFoundException;

import java.util.List;

public interface CategoryService {

   // List<Category> listAll(String sortDir);

    List<Category> listByPage(CategoryPageInfo pageInfo, int pageNumber, String sortDir, String keyword);

    List<Category> listOfCategories();

    public Category save(Category category);

    public  Category get(Integer id) throws CategoryNotFoundException;

    public String checkUnique(Integer id, String name, String alias);

    public void updateCategoryEnabledStatus(Integer id, boolean enabled);

    public void delete(Integer id) throws CategoryNotFoundException;
}
