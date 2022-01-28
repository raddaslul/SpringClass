package com.sparta.selectshop2.repository;

import com.sparta.selectshop2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { }