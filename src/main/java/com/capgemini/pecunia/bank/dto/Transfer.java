package com.capgemini.pecunia.bank.dto;

public class Transfer {

	private String fromAccId;
	private String toAccId;
	private double amount;

	public String getFromAccId() {
		return fromAccId;
	}

	public void setFromAccId(String fromAccId) {
		this.fromAccId = fromAccId;
	}

	public String getToAccId() {
		return toAccId;
	}

	public void setToAccId(String toAccId) {
		this.toAccId = toAccId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
