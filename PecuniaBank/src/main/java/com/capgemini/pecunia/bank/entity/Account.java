package com.capgemini.pecunia.bank.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="pecunia_bank_account")
@DynamicInsert
@DynamicUpdate
public class Account {

	@Id
	@Column(name="account_id")
	private String accountId;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "aadhar_number", referencedColumnName = "aadhar_number")
	private Customer customer;
	
	@Column(name="balance")
	private double balance;
	
	@Column(name="account_type")
	private String accountType;
	
	
	@Column(name="branch_id")
	private String branchId;
	
	@Column(name="Ifsc")
	private String ifsc;
	
	
	public Account() {
		super();
	}

	/**
	 * @param accountId
	 * @param aadharNumber
	 * @param balance
	 * @param accountType
	 * @param branchId
	 * @param ifsc
	 */
	public Account(String accountId, Customer customer, double balance, String accountType, String branchId,
			String ifsc) {
		super();
		this.accountId = accountId;
		this.customer = customer;
		this.balance = balance;
		this.accountType = accountType;
		this.branchId = branchId;
		this.ifsc = ifsc;
	}

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the aadharNumber
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param aadharNumber the aadharNumber to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the branchId
	 */
	public String getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the ifsc
	 */
	public String getIfsc() {
		return ifsc;
	}

	/**
	 * @param ifsc the ifsc to set
	 */
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	/*
	 * @Override public String toString() { return "Account [accountId=" + accountId
	 * + ", customer=" + customer + ", balance=" + balance + ", accountType=" +
	 * accountType + ", branchId=" + branchId + ", ifsc=" + ifsc + "]"; }
	 */
	
	
}