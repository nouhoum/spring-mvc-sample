package com.nouhoum.corpbase.domain;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-app-context.xml"})
public class CompanyTests {
	private Company company;
	private Date date = new Date();
	
	@Before
	public void initialize() {
		company = new Company("Test Corp", "12345678912345", "Test domain", date, "Test description"); 
	}
	
	@Test
	public void test_get_properties() {		
		assertNotNull(company);
		assertEquals("Test Corp", company.getName());
		assertEquals(date, company.getCreationDate());
		assertEquals("Test domain", company.getDomain());
	}
	
	@Test
	public void test_set_properties() {		
		company.setName("New Name");
		assertEquals("New Name", company.getName());
		
		assertEquals(date, company.getCreationDate());
		assertEquals("Test domain", company.getDomain());
	}
}
