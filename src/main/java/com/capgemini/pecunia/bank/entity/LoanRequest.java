package com.capgemini.pecunia.bank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pecunia_bank_loan_request")
public class LoanRequest {
	@Id
	@Column(name="loan_request_id")
	private String loanRequestId;
	
	@Column(name="loan_amount")
	private double loanAmount;
	
	@Column(name="loan_tenure")
	private int loanTenure;
	
	@Column(name="loan_request_status")
	private String loanRequestStatus;
	
	@Column(name="loan_type")
	private String loanType;
	
	@Column(name="rate_of_interest")
	private double rateOfInterest;
	
	@Column(name="credit_score")
	private int creditScore;
	
	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "account_id")
	private Account account;

	/**
	 * @param loanRequestId
	 * @param loanAmount
	 * @param loanTenure
	 * @param loanRequestStatus
	 * @param loanType
	 * @param rateOfInterest
	 * @param creditScore
	 * @param account
	 */
	public LoanRequest(String loanRequestId, double loanAmount, int loanTenure, String loanRequestStatus,
			String loanType, double rateOfInterest, int creditScore, Account account) {
		super();
		this.loanRequestId = loanRequestId;
		this.loanAmount = loanAmount;
		this.loanTenure = loanTenure;
		this.loanRequestStatus = loanRequestStatus;
		this.loanType = loanType;
		this.rateOfInterest = rateOfInterest;
		this.creditScore = creditScore;
		this.account = account;
	}

	public LoanRequest() {
		super();
	}

	/**
	 * @return the loanRequestId
	 */
	public String getLoanRequestId() {
		return loanRequestId;
	}

	/**
	 * @param loanRequestId the loanRequestId to set
	 */
	public void setLoanRequestId(String loanRequestId) {
		this.loanRequestId = loanRequestId;
	}

	/**
	 * @return the loanAmount
	 */
	public double getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * @return the loanTenure
	 */
	public int getLoanTenure() {
		return loanTenure;
	}

	/**
	 * @param loanTenure the loanTenure to set
	 */
	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}

	/**
	 * @return the loanRequestStatus
	 */
	public String getLoanRequestStatus() {
		return loanRequestStatus;
	}

	/**
	 * @param loanRequestStatus the loanRequestStatus to set
	 */
	public void setLoanRequestStatus(String loanRequestStatus) {
		this.loanRequestStatus = loanRequestStatus;
	}

	/**
	 * @return the loanType
	 */
	public String getLoanType() {
		return loanType;
	}

	/**
	 * @param loanType the loanType to set
	 */
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	/**
	 * @return the rateOfInterest
	 */
	public double getRateOfInterest() {
		return rateOfInterest;
	}

	/**
	 * @param rateOfInterest the rateOfInterest to set
	 */
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	/**
	 * @return the creditScore
	 */
	public int getCreditScore() {
		return creditScore;
	}

	/**
	 * @param creditScore the creditScore to set
	 */
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
	
	
	
	

}