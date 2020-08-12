package com.capgemini.pecunia.bank.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pecunia_bank_slip")
public class Slip extends Transaction{

	
	@Column(name = "slip_id")
	private Long slipId;

	public Slip() {
		super();
	}

	/**
	 * @param transactionId
	 * @param transactionType
	 * @param transactionAmount
	 * @param transactionDate
	 * @param transactionStatus
	 * @param account
	 * @param slipId
	 */
	public Slip(Long transactionId, String transactionType, double transactionAmount, LocalDate transactionDate,
			String transactionStatus, Account account, Long slipId) {
		super(transactionId, transactionType, transactionAmount, transactionDate, transactionStatus, account);
		this.slipId = slipId;
	}

	/**
	 * @param slipId
	 */
	public Slip(Long slipId) {
		super();
		this.slipId = slipId;
	}

	/**
	 * @return the slipId
	 */
	public Long getSlipId() {
		return slipId;
	}

	/**
	 * @param slipId the slipId to set
	 */
	public void setSlipId(Long slipId) {
		this.slipId = slipId;
	}

	@Override
	public String toString() {
		return "Slip [slipId=" + slipId + "]";
	}
	
	
	
	

	
	
}