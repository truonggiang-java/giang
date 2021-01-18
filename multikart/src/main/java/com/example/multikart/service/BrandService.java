package com.example.multikart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.multikart.projecttions.common.SelectCommom;
import com.example.multikart.repository.BrandRepository;

@Service
public class BrandService {
	@Autowired 
	private BrandRepository brandRepository;
	
	public List<SelectCommom> findBrand(){
		return brandRepository.findListBrand();
	}
}
