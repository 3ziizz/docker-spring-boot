/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.flairstechtask.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maziz
 */
@Entity
@Table(catalog = "world-db", schema = "",name="country_language")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Countrylanguage.findAll", query = "SELECT c FROM Countrylanguage c"),
//    @NamedQuery(name = "Countrylanguage.findByCountryCode", query = "SELECT c FROM Countrylanguage c WHERE c.countrylanguagePK.countryCode = :countryCode"),
//    @NamedQuery(name = "Countrylanguage.findByLanguage", query = "SELECT c FROM Countrylanguage c WHERE c.countrylanguagePK.language = :language"),
//    @NamedQuery(name = "Countrylanguage.findByIsOfficial", query = "SELECT c FROM Countrylanguage c WHERE c.isOfficial = :isOfficial"),
//    @NamedQuery(name = "Countrylanguage.findByPercentage", query = "SELECT c FROM Countrylanguage c WHERE c.percentage = :percentage")})

public class Countrylanguage implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected CountrylanguagePK countrylanguagePK;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 2)
	@Column(nullable = false, length = 2)
	private String isOfficial;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Basic(optional = false)
	@NotNull
	@Column(nullable = false, precision = 4, scale = 1)
	private BigDecimal percentage;
	@JoinColumn(name = "CountryCode", referencedColumnName = "Code", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Country country;

	public Countrylanguage() {
	}

	public Countrylanguage(CountrylanguagePK countrylanguagePK) {
		this.countrylanguagePK = countrylanguagePK;
	}

	public Countrylanguage(CountrylanguagePK countrylanguagePK, String isOfficial, BigDecimal percentage) {
		this.countrylanguagePK = countrylanguagePK;
		this.isOfficial = isOfficial;
		this.percentage = percentage;
	}

	public Countrylanguage(String countryCode, String language) {
		this.countrylanguagePK = new CountrylanguagePK(countryCode, language);
	}

	public CountrylanguagePK getCountrylanguagePK() {
		return countrylanguagePK;
	}

	public void setCountrylanguagePK(CountrylanguagePK countrylanguagePK) {
		this.countrylanguagePK = countrylanguagePK;
	}

	public String getIsOfficial() {
		return isOfficial;
	}

	public void setIsOfficial(String isOfficial) {
		this.isOfficial = isOfficial;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (countrylanguagePK != null ? countrylanguagePK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Countrylanguage)) {
			return false;
		}
		Countrylanguage other = (Countrylanguage) object;
		if ((this.countrylanguagePK == null && other.countrylanguagePK != null)
				|| (this.countrylanguagePK != null && !this.countrylanguagePK.equals(other.countrylanguagePK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Countrylanguage [countrylanguagePK=" + countrylanguagePK + ", isOfficial=" + isOfficial
				+ ", percentage=" + percentage + ", country=" + country + "]";
	}

//	    @Override
//	    public String toString() {
//	        return "com.springboot.flairstechtask.Countrylanguage[ countrylanguagePK=" + countrylanguagePK + " ]";
//	    }

}
