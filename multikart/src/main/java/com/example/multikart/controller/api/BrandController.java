package com.example.multikart.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.multikart.service.BrandService;

@Controller
@RequestMapping("/api/v1")
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	
}
