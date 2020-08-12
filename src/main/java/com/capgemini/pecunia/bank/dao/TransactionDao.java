package com.capgemini.pecunia.bank.dao;


import com.capgemini.pecunia.bank.entity.Account;
import com.capgemini.pecunia.bank.entity.Cheque;
import com.capgemini.pecunia.bank.entity.Customer;
import com.capgemini.pecunia.bank.entity.Slip;
import com.capgemini.pecunia.bank.entity.Transaction;




public interface TransactionDao {

	public Account getAccount(String acc_id);

	/* public int getBalance(Account account); */

	/*
	 * public Boolean updateBalance(Account account);
	 */
	public int generateChequeId(Cheque cheque);

	public int generateTransactionId(Transaction transaction);

	public Boolean addTransaction(Transaction transaction);

	public boolean addCustomer(Customer customer);

	public boolean addSlip(Slip slip);

	public boolean addCheque(Cheque cheque);
	
	public boolean addAccount(Account account);
}
