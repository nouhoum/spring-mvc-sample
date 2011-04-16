package com.nouhoum.corpbase.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = 
	{"classpath*:test-app-context.xml"})
public class CompanyControllerTests {
	@Autowired
	private CompanyController companyController;
	
	@Test
	public void show_all_test() {
		ModelMap model = new ModelMap();
		assertEquals("companies", companyController.showAll(model));
	}
	
	@Test
	public void show_new_form_test() {
		assertEquals("form", companyController.companyForm());
	}
}
