package com.nouhoum.corpbase.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.nouhoum.corpbase.domain.Company;
import com.nouhoum.corpbase.service.CorpBaseService;

/**
 * Controller handling requests related to companies.
 * 
 * @author nouhoum
 */
@Controller
@RequestMapping("/companies")
public class CompanyController {
	private CorpBaseService corpBaseService;
	
	private void initialize() {
		List<Company> companies = corpBaseService.listCompanies();
		
		if(companies.size() == 0) {
			try {
				corpBaseService.createCompany(
						new Company("IBM", "45676544434989", "Software engineering", new SimpleDateFormat("dd-MM-yyyy").parse("16-06-1911"), 
								"International Business Machines (IBM) (NYSE: IBM) is an American multinational technology and consulting firm " +
								"headquartered in Armonk, New York. IBM manufactures and sells computer hardware and software, and it offers " +
								"infrastructure, hosting and consulting services " +
								"in areas ranging from mainframe computers to nanotechnology... (source: Wikipedia)"));
				corpBaseService.createCompany(
						new Company("Google", "45676544588888", "Internet business", new SimpleDateFormat("dd-MM-yyyy").parse("04-09-1998"), 
								"Google Inc. is an American multinational public corporation invested in Internet search, " +
								"cloud computing, and advertising technologies. Google hosts and develops a number of " +
								"Internet-based services and products, and generates profit primarily from advertising " +
								"through its AdWords program. The company was founded by Larry Page and Sergey Brin, " +
								"often dubbed the \"Google Guys\", while the two were attending Stanford University " +
								"as PhD candidates. It was first incorporated as a privately held company on " +
								"September 4, 1998, and its initial public offering followed on " +
								"August 19, 2004. At that time Larry Page, Sergey Brin, and Eric Schmidt agreed to work together..."));
				corpBaseService.createCompany(
						new Company("Oracle", "45676544577766", "Software engineering", new SimpleDateFormat("dd-MM-yyyy").parse("01-01-1886"), 
								"Oracle Corporation (NASDAQ: ORCL) is an American multinational computer " +
								"technology corporation that specializes in developing and marketing hardware " +
								"systems and enterprise software products — particularly database management systems. " +
								"Headquartered in Redwood Shores, California, United States and employing 105,000 " +
								"people worldwide as of 1 July 2010 (2010 -07-01)[update],[3] it has enlarged its " +
								"share of the software market through organic growth and through a number of " +
								"high-profile acquisitions. By 2007 Oracle had the third-largest software revenue, " +
								"after Microsoft and IBM..."));
			} catch (ParseException e) {				
				e.printStackTrace();
			}			
		}
	}
	
	@Inject
	public CompanyController(CorpBaseService corpBaseService) {
		this.corpBaseService = corpBaseService;
		initialize();
	}
	
	public void setCorpBaseService(CorpBaseService corpBaseService) {
		this.corpBaseService = corpBaseService;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, ModelMap modelMap) {
		Company company = corpBaseService.findCompany(id);
		modelMap.addAttribute("company", company);
		return "company";
	}
	
	@RequestMapping(value = {"/", "all"}, method = RequestMethod.GET)
	public String showAll(ModelMap model) {
		List<Company> companies = corpBaseService.listCompanies();
		model.addAttribute("companies", companies);
		return "companies";
	}
	
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String companyForm() {
		return "form";
	}
	
	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String processCompanyForm(Model model, @ModelAttribute("company") @Valid Company company, BindingResult result, SessionStatus status) {
		model.addAttribute("company", company);
		if(result.hasErrors()) {
			return "form";
		}
		corpBaseService.createCompany(company);
		return "redirect:all";
	}
}
