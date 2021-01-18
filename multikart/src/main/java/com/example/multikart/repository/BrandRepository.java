package com.example.multikart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.multikart.entity.Brand;
import com.example.multikart.projecttions.common.SelectCommom;

public interface BrandRepository extends JpaRepository<Brand, Integer>{
	@Query(value="select b.id as id, b.name as name from Brand b")
	List<SelectCommom> findListBrand();
}
