package com.nouhoum.corpbase.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nouhoum.corpbase.domain.Company;
/**
 * A simple implementation of <code>CorpBaseService</code> based on
 * JPA.
 * 
 * @author nouhoum
 */
@Service("corpBaseService")
@Repository
public class SimpleCorpBaseService implements CorpBaseService {
	private EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public Company createCompany(Company company) {
		em.persist(company);
		return company;
	}

	@Transactional
	@Override
	public void removeCompany(Long companyId) {
		Company company = em.find(Company.class, companyId);
		if(company != null) {
			em.remove(company);
		}
	}

	@Transactional(readOnly = true)
	public List<Company> listCompanies() {		
		@SuppressWarnings("unchecked")
		List<Company> companies = em.createQuery("from Company").getResultList();
		return companies;
	}

	@Transactional(readOnly = true)
	public Company findCompany(Long id) {
		return em.find(Company.class, id);
	}
}
