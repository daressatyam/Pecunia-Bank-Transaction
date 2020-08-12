package com.capgemini.pecunia.bank.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.bank.entity.Account;
import com.capgemini.pecunia.bank.entity.Cheque;
import com.capgemini.pecunia.bank.entity.Customer;
import com.capgemini.pecunia.bank.entity.Slip;
import com.capgemini.pecunia.bank.entity.Transaction;

@Repository
public class TransactionDaoImpl implements TransactionDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Account getAccount(String account_id) {
		return entityManager.find(Account.class, account_id);
		
	}

	/*
	 * @Override public int getBalance(Account account) { return 0; }
	 */

	/*
	 * @Override public Boolean updateBalance(Account account) { // TODO
	 * Auto-generated method stub return null; }
	 */

	@Override
	public int generateChequeId(Cheque cheque) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int generateTransactionId(Transaction transaction) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public Boolean addTransaction(Transaction transaction) {
		
		entityManager.persist(transaction);
		return true;
		
	}
	
	
	
	public boolean addSlip(Slip slip) {
		entityManager.merge(slip);
		return true;
	}
	
	public boolean addCustomer(Customer customer) {
		entityManager.persist(customer);
		return true;
	}
	
	public boolean addCheque(Cheque cheque) {
		entityManager.persist(cheque);
		return true;
	}

	@Override
	public boolean addAccount(Account account) {
		entityManager.persist(account);
		return true;
	}
	
	
}
