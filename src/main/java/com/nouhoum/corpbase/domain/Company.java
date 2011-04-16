package com.nouhoum.corpbase.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Represent a company. Each company has a unique identifier
 * a.k.a SIRET. which is 14-digit number.
 * 
 * @author nouhoum
 */
@Entity
public class Company implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 50)
	private String name;
	
	@Pattern(regexp="[0-9]{14}", message = "{siret.error.messageKey}")
	private String siret;
	
	@Size(min = 2, max = 50)
	private String domain;
	
	@Type(type = "java.util.Date")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date creationDate;
	
	@NotNull
	@Size(min = 10, max = 1000)
	private String description;
	
	private static final long serialVersionUID = 1L;
	
	public Company() {}
	
	public Company(String name, String siret, String domain, Date creationDate, String description) {
		this.name = name;
		this.siret = siret;
		this.domain = domain;
		this.description = description;
		this.creationDate = creationDate;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return name;
	}
}
