package com.capgemini.pecunia.bank.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="pecunia_bank_customer")
@DynamicInsert
@DynamicUpdate
public class Customer {

	@Id
	@Column(name="aadhar_number")
	private String aadharNumber;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="pan_number")
	private String panNumber;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name="address")
	private String address;
	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	
	@Column(name="country")
	private String country;
	
	@Column(name="zipcode")
	private String zipcode;
	
	@Column(name="gender")
	private String gender;

	
	public Customer() {
		super();
	}

	/**
	 * @param aadharNumber
	 * @param name
	 * @param phoneNumber
	 * @param panNumber
	 * @param dateOfBirth
	 * @param address
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param gender
	 */
	public Customer(String aadharNumber, String name, String phoneNumber, String panNumber, LocalDate dateOfBirth,
			String address, String state, String city, String country, String zipcode, String gender) {
		super();
		this.aadharNumber = aadharNumber;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.panNumber = panNumber;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.state = state;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
		this.gender = gender;
	}

	/**
	 * @return the aadharNumber
	 */
	public String getAadharNumber() {
		return aadharNumber;
	}

	/**
	 * @param aadharNumber the aadharNumber to set
	 */
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the panNumber
	 */
	public String getPanNumber() {
		return panNumber;
	}

	/**
	 * @param panNumber the panNumber to set
	 */
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Customer [aadharNumber=" + aadharNumber + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", panNumber=" + panNumber + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", state="
				+ state + ", city=" + city + ", country=" + country + ", zipcode=" + zipcode + ", gender=" + gender
				+ "]";
	}
	
	
	


	
	
	
	
	
	
	
	
}
