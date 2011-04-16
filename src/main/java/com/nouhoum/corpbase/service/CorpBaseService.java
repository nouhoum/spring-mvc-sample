package com.nouhoum.corpbase.service;

import java.util.List;

import com.nouhoum.corpbase.domain.Company;

/**
 * Represents the interface of the Corporate base service.
 * 
 * @author nouhoum
 */
public interface CorpBaseService {
	Company createCompany(Company company);
	void removeCompany(Long companyId);
	List<Company> listCompanies();
	Company findCompany(Long id);
}
