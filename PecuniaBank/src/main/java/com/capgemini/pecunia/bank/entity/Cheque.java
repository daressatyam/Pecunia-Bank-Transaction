package com.capgemini.pecunia.bank.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pecunia_bank_cheque")
public class Cheque extends Transaction{
	
	@Column(name = "cheque_id")
	private Long chequeId;
	
	@Column(name = "ifsc_code")
	private String ifsc;
	
	@Column(name = "cheque_issue_date")
	private LocalDate chequeIssueDate;
	
	@Column(name = "benificiary_account_number")
	private String beneficiaryAccountNumber;
	

	public Cheque() {
		super();
	}

	/**
	 * @param transactionId
	 * @param transactionType
	 * @param transactionAmount
	 * @param transactionDate
	 * @param transactionStatus
	 * @param account
	 * @param chequeId
	 * @param ifsc
	 * @param chequeIssueDate
	 * @param beneficiaryAccountNumber
	 */
	public Cheque(Long transactionId, String transactionType, double transactionAmount, LocalDate transactionDate,
			String transactionStatus, Account account, Long chequeId, String ifsc, LocalDate chequeIssueDate,
			String beneficiaryAccountNumber) {
		super(transactionId, transactionType, transactionAmount, transactionDate, transactionStatus, account);
		this.chequeId = chequeId;
		this.ifsc = ifsc;
		this.chequeIssueDate = chequeIssueDate;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	
	/**
	 * @param chequeId
	 * @param ifsc
	 * @param chequeIssueDate
	 * @param beneficiaryAccountNumber
	 */
	public Cheque(Long chequeId, String ifsc, LocalDate chequeIssueDate, String beneficiaryAccountNumber) {
		super();
		this.chequeId = chequeId;
		this.ifsc = ifsc;
		this.chequeIssueDate = chequeIssueDate;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	/**
	 * @return the chequeId
	 */
	public Long getChequeId() {
		return chequeId;
	}

	/**
	 * @param chequeId the chequeId to set
	 */
	public void setChequeId(Long chequeId) {
		this.chequeId = chequeId;
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

	/**
	 * @return the chequeIssueDate
	 */
	public LocalDate getChequeIssueDate() {
		return chequeIssueDate;
	}

	/**
	 * @param chequeIssueDate the chequeIssueDate to set
	 */
	public void setChequeIssueDate(LocalDate chequeIssueDate) {
		this.chequeIssueDate = chequeIssueDate;
	}

	/**
	 * @return the beneficiaryAccountNumber
	 */
	public String getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	/**
	 * @param beneficiaryAccountNumber the beneficiaryAccountNumber to set
	 */
	public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	@Override
	public String toString() {
		return "Cheque [chequeId=" + chequeId + ", ifsc=" + ifsc + ", chequeIssueDate=" + chequeIssueDate
				+ ", beneficiaryAccountNumber=" + beneficiaryAccountNumber + "]";
	}
	
	
	
	

}