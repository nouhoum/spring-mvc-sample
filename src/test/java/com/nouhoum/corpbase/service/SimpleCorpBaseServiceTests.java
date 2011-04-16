package com.nouhoum.corpbase.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

import com.nouhoum.corpbase.service.CorpBaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = 
	{"classpath*:test-app-context.xml"})
public class SimpleCorpBaseServiceTests {
	@Autowired
	private CorpBaseService corpBaseService;
	
	@Test
	public void company_list_test() {
		assertEquals(3, corpBaseService.listCompanies().size());
	}
	
	@Test
	public void remove_company_test() {
		assertEquals(3, corpBaseService.listCompanies().size());
		corpBaseService.removeCompany(corpBaseService.listCompanies().get(0).getId());
		assertEquals(2, corpBaseService.listCompanies().size());
	}
	
	@Test
	public void find_company_by_id_test() {
		assertNotNull(corpBaseService.findCompany(1L));
		assertNotNull("IBM", corpBaseService.findCompany(1L).getName());
	}
}
