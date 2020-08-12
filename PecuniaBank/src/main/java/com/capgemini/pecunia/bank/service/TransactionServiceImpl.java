
package com.capgemini.pecunia.bank.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.pecunia.bank.util.walletConstants;
import com.capgemini.pecunia.bank.dao.TransactionDao;
import com.capgemini.pecunia.bank.dto.Transfer;
import com.capgemini.pecunia.bank.dto.TxnForm;
import com.capgemini.pecunia.bank.entity.Account;
import com.capgemini.pecunia.bank.entity.Cheque;
import com.capgemini.pecunia.bank.entity.Customer;
import com.capgemini.pecunia.bank.entity.Slip;
import com.capgemini.pecunia.bank.exceptions.AccountNotFoundException;
import com.capgemini.pecunia.bank.exceptions.TransactionException;

@javax.transaction.Transactional
@Service("TransactionSer")
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	
	
	

	/****************************
	 * Method: Credit Money through Cheque
                *Description: To Deposit money to an account
	 * Slip Details       -Account Number,Amount, IFSC  
	 
	 * @throws AccountNotFoundException, TransactionException - It is raised due to insufficient balance or invalid account Id or  
                                                                         server side validation
                *Created By                                - Satyam Singh                          
	 
	 ****************************/
	
	
	@Override
	public Boolean creditUsingCheque(Transfer transfer) throws AccountNotFoundException, TransactionException {
		// creating fromAcc instance
		Account fromAccount = transactionDao.getAccount(transfer.getFromAccId());
		if (fromAccount == null)
			throw new AccountNotFoundException(walletConstants.INVALID_ACCOUNT);
		if (fromAccount.getBalance() < transfer.getAmount())
			throw new TransactionException(walletConstants.INSUFFICIENT_BALANCE);
		fromAccount.setBalance(fromAccount.getBalance() - transfer.getAmount());

		TxnWithCheque(walletConstants.DEBIT, transfer.getAmount(), LocalDate.of(2020, 04, 12),
				walletConstants.transcation_status, fromAccount, 9844L, "SBI72825", LocalDate.of(2020, 03, 20),
				transfer.getFromAccId());

		// creating toAccount instance
		Account toAccount = transactionDao.getAccount(transfer.getToAccId());
		if (toAccount == null)
			throw new AccountNotFoundException(walletConstants.INVALID_ACCOUNT);
		toAccount.setBalance(toAccount.getBalance() + transfer.getAmount());

		TxnWithCheque( walletConstants.CREDIT, transfer.getAmount(), LocalDate.of(2020, 04, 18),
				walletConstants.transcation_status, fromAccount, 4647L, "SBI72825", LocalDate.of(2020, 03, 14),
				transfer.getToAccId());
		return true;
	}

	
	

	/****************************
	 * Method: Credit Money through Slip
                *Description: To Deposit money to an account
	 * Slip Details       -Account Number,Amount 
	 
	 * @throws AccountNotFoundException, TransactionException - It is raised due to insufficient balance or invalid account Id or  
                                                                         server side validation
                *Created By                                - Satyam Singh                         
	 
	 ****************************/
	
	
	
	
	@Override
	public Boolean creditUsingSlip(TxnForm txnform) throws AccountNotFoundException {
		Account toAccount =transactionDao.getAccount(txnform.getAccId());
		if (toAccount == null)
			throw new AccountNotFoundException(walletConstants.INVALID_ACCOUNT);
		toAccount.setBalance(txnform.getAmount() + toAccount.getBalance());

		// CALLING TRANSACTION METHOD
		TxnWithSlip( walletConstants.CREDIT, txnform.getAmount(), LocalDate.of(2020, 04, 15),
				walletConstants.transcation_status, toAccount, 456L);

		return true;

	}

	
	
	
	
	

	/****************************
	 * Method:Transfer with Slip
                *Description: To withdrawal & Add money from an account  and adding details to slip class to store in database
	 * Slip Details       -transactionType, transactionAmount,transactionDate, transactionStatus, Account,slipId 
	 
	 *         Version             1.0                      
	 
	 ****************************/	
	

	public Boolean TxnWithSlip(String transactionType, double transactionAmount,
			LocalDate transactionDate, String transactionStatus, Account account, Long slipId) {
		Slip slip = new Slip();
		//slip.setTransactionId(transactionId);
		slip.setTransactionType(transactionType);
		slip.setTransactionAmount(transactionAmount);
		slip.setTransactionDate(LocalDate.now());
		slip.setTransactionStatus(transactionStatus);
		slip.setAccount(account);
		slip.setSlipId(slipId);

		transactionDao.addSlip(slip);
		return true;
	}
	
	/****************************
	 * Method:Transfer with Cheque
                *Description: To withdrawal & Add money from an account  and adding details to Cheque class to store in database
	 * Slip Details       -transactionType,transactionAmount,transactionDate,transactionStatus, Account,chequeId,ifsc,chequeIssueDate,beneficiaryAccountNumber
	 
	 *         Version             1.0                      
	 
	 ****************************/	

	public Boolean TxnWithCheque( String transactionType, double transactionAmount,
			LocalDate transactionDate, String transactionStatus, Account account, Long chequeId, String ifsc,
			LocalDate chequeIssueDate, String beneficiaryAccountNumber) {
		Cheque cheque = new Cheque();
		
		cheque.setTransactionType(transactionType);
		cheque.setTransactionAmount(transactionAmount);
		cheque.setTransactionDate(transactionDate);
		cheque.setTransactionStatus(transactionStatus);
		cheque.setAccount(account);
		cheque.setChequeId(chequeId);
		cheque.setIfsc(ifsc);
		cheque.setChequeIssueDate(chequeIssueDate);
		cheque.setBeneficiaryAccountNumber(beneficiaryAccountNumber);

		transactionDao.addCheque(cheque);

		return true;
	}
	/****************************
	 * Method:Add Slip To Database
                *Description: Adding the slip detail in database for furture records
	 *         Version             1.0                      
	 
	 ****************************/	
	
	@Override
	public Boolean addSlip(Slip slip) {
		transactionDao.addSlip(slip);
		return true;
	}
	
	
	/****************************
	 * Method:Add Cheque To Database
                *Description: Adding the Cheque detail in database for furture records
	 *         Version             1.0                      
	 
	 ****************************/	
	public boolean addCheque(Cheque cheque) {
		transactionDao.addCheque(cheque);
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	/****************************
	 * Method: Debit Money through Cheque
                *Description: To withdrawal money from an account
	 * Slip Details       -Account Number,Amount,IFSC 
	 
	 * @throws AccountNotFoundException, TransactionException - It is raised due to insufficient balance or invalid account Id or  
                                                                         server side validation
                *Created By                                - LovaRaju                         
	 
	 ****************************/
	
	
	
	
	
	@Override
	public Boolean debitUsingCheque(TxnForm txnform) throws AccountNotFoundException, TransactionException {
		Account fromAccount = transactionDao.getAccount(txnform.getAccId());
		if (fromAccount == null)
			throw new AccountNotFoundException(walletConstants.INVALID_ACCOUNT);
		if (fromAccount.getBalance() < txnform.getAmount())
			throw new TransactionException(walletConstants.INSUFFICIENT_BALANCE);

		fromAccount.setBalance(fromAccount.getBalance() - txnform.getAmount());

		TxnWithCheque( walletConstants.DEBIT, txnform.getAmount(), LocalDate.of(2020, 04, 16),
				walletConstants.transcation_status, fromAccount, 14561L, "SBI72827", LocalDate.of(2020, 03, 26),
				txnform.getAccId());

		return true;
	}
	
	
	/****************************
	 * Method: Debit Money through Slip
                *Description: To withdrawal money from an account
	 * Slip Details       -Account Number,Amount 
	 
	 * @throws AccountNotFoundException, TransactionException - It is raised due to insufficient balance or invalid account Id or  
                                                                         server side validation
                *Created By                                - Lovaraju                          
	 
	 ****************************/
	
	
	
	
	@Override
	public Boolean debitUsingSlip(TxnForm txnform) throws AccountNotFoundException, TransactionException {
		Account fromAccount = transactionDao.getAccount(txnform.getAccId());
		if (fromAccount == null)
			throw new AccountNotFoundException(walletConstants.INVALID_ACCOUNT);

		if (fromAccount.getBalance() < txnform.getAmount())
			throw new TransactionException(walletConstants.INSUFFICIENT_BALANCE);
		fromAccount.setBalance(fromAccount.getBalance() - txnform.getAmount());

		// CALLING TRANSACTION METHOD
		TxnWithSlip(walletConstants.DEBIT, txnform.getAmount(), LocalDate.of(2020, 04, 15),
				walletConstants.transcation_status, fromAccount, 7484L);

		return true;
	}

	
	
	
	

	@Override
	public boolean addAccount(Account account) {
		transactionDao.addAccount(account);
		return true;
	}

	public boolean addCust(Customer customer) {
		transactionDao.addCustomer(customer);
		return true;
	}

	

	

}
