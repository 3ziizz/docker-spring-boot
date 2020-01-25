/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.flairstechtask.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author maziz
 */
@Entity
@Table(catalog = "world-db", schema = "")
@XmlRootElement
//@NamedQueries({ @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
//		@NamedQuery(name = "Country.findByCode", query = "SELECT c FROM Country c WHERE c.code = :code"),
//		@NamedQuery(name = "Country.findByName", query = "SELECT c FROM Country c WHERE c.name = :name"),
//		@NamedQuery(name = "Country.findByContinent", query = "SELECT c FROM Country c WHERE c.continent = :continent"),
//		@NamedQuery(name = "Country.findByRegion", query = "SELECT c FROM Country c WHERE c.region = :region"),
//		@NamedQuery(name = "Country.findBySurfaceArea", query = "SELECT c FROM Country c WHERE c.surfaceArea = :surfaceArea"),
//		@NamedQuery(name = "Country.findByIndepYear", query = "SELECT c FROM Country c WHERE c.indepYear = :indepYear"),
//		@NamedQuery(name = "Country.findByPopulation", query = "SELECT c FROM Country c WHERE c.population = :population"),
//		@NamedQuery(name = "Country.findByLifeExpectancy", query = "SELECT c FROM Country c WHERE c.lifeExpectancy = :lifeExpectancy"),
//		@NamedQuery(name = "Country.findByGnp", query = "SELECT c FROM Country c WHERE c.gnp = :gnp"),
//		@NamedQuery(name = "Country.findByGNPOld", query = "SELECT c FROM Country c WHERE c.gnpOld = :gNPOld"),
//		@NamedQuery(name = "Country.findByLocalName", query = "SELECT c FROM Country c WHERE c.localName = :localName"),
//		@NamedQuery(name = "Country.findByGovernmentForm", query = "SELECT c FROM Country c WHERE c.governmentForm = :governmentForm"),
//		@NamedQuery(name = "Country.findByHeadOfState", query = "SELECT c FROM Country c WHERE c.headOfState = :headOfState"),
//		@NamedQuery(name = "Country.findByCapital", query = "SELECT c FROM Country c WHERE c.capital = :capital"),
//		@NamedQuery(name = "Country.findByCode2", query = "SELECT c FROM Country c WHERE c.code2 = :code2") })
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 3)
	@Column(nullable = false, length = 3)
	private String code;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 52)
	@Column(nullable = false, length = 52)
	private String name;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 13)
	@Column(nullable = false, length = 13)
	private String continent;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 26)
	@Column(nullable = false, length = 26)
	private String region;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal surfaceArea;
	private Short indepYear;
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false)
	private int population;
	@Column(precision = 3, scale = 1)
	private BigDecimal lifeExpectancy;
	@Column(precision = 10, scale = 2)
	private BigDecimal gnp;
	@Column(precision = 10, scale = 2)
	private BigDecimal gnpOld;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(nullable = false, length = 45)
	private String localName;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(nullable = false, length = 45)
	private String governmentForm;
	@Size(max = 60)
	@Column(length = 60)
	private String headOfState;
	private Integer capital;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2)
	@Column(nullable = false, length = 2)
	private String code2;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "countryCode")
	private Collection<City> cityCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
	private Collection<Countrylanguage> countrylanguageCollection;

	public Country() {
	}

	public Country(String code) {
		this.code = code;
	}

	public Country(String code, String name, String continent, String region, BigDecimal surfaceArea, int population,
			String localName, String governmentForm, String code2) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.surfaceArea = surfaceArea;
		this.population = population;
		this.localName = localName;
		this.governmentForm = governmentForm;
		this.code2 = code2;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public BigDecimal getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(BigDecimal surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public Short getIndepYear() {
		return indepYear;
	}

	public void setIndepYear(Short indepYear) {
		this.indepYear = indepYear;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public BigDecimal getLifeExpectancy() {
		return lifeExpectancy;
	}

	public void setLifeExpectancy(BigDecimal lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	public BigDecimal getGnp() {
		return gnp;
	}

	public void setGnp(BigDecimal gnp) {
		this.gnp = gnp;
	}

	public BigDecimal getGNPOld() {
		return gnpOld;
	}

	public void setGNPOld(BigDecimal gNPOld) {
		this.gnpOld = gNPOld;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getGovernmentForm() {
		return governmentForm;
	}

	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	@XmlTransient
	public Collection<City> getCityCollection() {
		return cityCollection;
	}

	public void setCityCollection(Collection<City> cityCollection) {
		this.cityCollection = cityCollection;
	}

	@XmlTransient
	public Collection<Countrylanguage> getCountrylanguageCollection() {
		return countrylanguageCollection;
	}

	public void setCountrylanguageCollection(Collection<Countrylanguage> countrylanguageCollection) {
		this.countrylanguageCollection = countrylanguageCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (code != null ? code.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Country)) {
			return false;
		}
		Country other = (Country) object;
		if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
			return false;
		}
		return true;
	}

	//	@Override
	//	public String toString() {
	//		return "Country [code=" + code + ", name=" + name + ", continent=" + continent + ", region=" + region
	//				+ ", surfaceArea=" + surfaceArea + ", indepYear=" + indepYear + ", population=" + population
	//				+ ", lifeExpectancy=" + lifeExpectancy + ", gnp=" + gnp + ", gnpOld=" + gnpOld + ", localName="
	//				+ localName + ", governmentForm=" + governmentForm + ", headOfState=" + headOfState + ", capital="
	//				+ capital + ", code2=" + code2 + ", cityCollection=" + cityCollection + ", countrylanguageCollection="
	//				+ countrylanguageCollection + "]";
	//	}

	@Override
	public String toString() {
		return "Country[ code=" + code + ", name=" + name + ", continent=" + continent + ", population=" + population
				+ ", lifeExpectancy=" + lifeExpectancy + "]";
	}

}
