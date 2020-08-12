package com.capgemini.pecunia.bank.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="pecunia_bank_transaction")
@DynamicInsert
@DynamicUpdate
@Inheritance(strategy=InheritanceType.JOINED)
public class Transaction {

	@Id
	@Column(name="transaction_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	
	@Column(name="transaction_type")
	private String transactionType;
	
	@Column(name="transaction_amount")
	private double transactionAmount;
	
	@Column(name="transaction_date")
	private LocalDate transactionDate;
	
	@Column(name="transaction_status")
	private String transactionStatus;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="account_id" , referencedColumnName = "account_id")
	private Account account;

	public Transaction() {
		
	}
	
	public Transaction(Long transactionId, String transactionType, double transactionAmount, LocalDate transactionDate,
			String transactionStatus, Account account) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionStatus = transactionStatus;
		this.account = account;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
}