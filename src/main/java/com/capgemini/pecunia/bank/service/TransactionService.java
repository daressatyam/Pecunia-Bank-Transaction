package com.capgemini.pecunia.bank.service;

import com.capgemini.pecunia.bank.dto.Transfer;
import com.capgemini.pecunia.bank.dto.TxnForm;
import com.capgemini.pecunia.bank.entity.Account;
import com.capgemini.pecunia.bank.entity.Cheque;
import com.capgemini.pecunia.bank.entity.Customer;
import com.capgemini.pecunia.bank.entity.Slip;
import com.capgemini.pecunia.bank.exceptions.AccountNotFoundException;
import com.capgemini.pecunia.bank.exceptions.TransactionException;

public interface TransactionService {
	
	public Boolean creditUsingSlip(TxnForm txnform) throws AccountNotFoundException;

	public Boolean debitUsingSlip(TxnForm txnform) throws AccountNotFoundException,TransactionException;

	public Boolean creditUsingCheque(Transfer transfer) throws AccountNotFoundException,TransactionException;

	public Boolean debitUsingCheque(TxnForm txnform) throws AccountNotFoundException,TransactionException;

	public Boolean addSlip(Slip slip);

	public boolean addCust(Customer customer);

	public boolean addCheque(Cheque cheque);
	
	public boolean addAccount(Account account);

}
