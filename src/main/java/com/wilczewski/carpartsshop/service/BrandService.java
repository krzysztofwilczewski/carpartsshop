package com.wilczewski.carpartsshop.service;

import com.wilczewski.carpartsshop.entity.Brand;
import com.wilczewski.carpartsshop.exception.BrandNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BrandService {

    public List<Brand> listAll();

    public Brand save(Brand brand);

    public Brand get(Integer id) throws BrandNotFoundException;

    public void delete(Integer id) throws BrandNotFoundException;

    public String checkUnique(Integer id, String name);

    public Page<Brand> listByPage(int pageNumber, String sortField, String sortDir, String keyword);
}
