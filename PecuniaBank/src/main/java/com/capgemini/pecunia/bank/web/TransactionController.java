package com.capgemini.pecunia.bank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecunia.bank.dto.BankMessage;
import com.capgemini.pecunia.bank.dto.Transfer;
import com.capgemini.pecunia.bank.dto.TxnForm;
import com.capgemini.pecunia.bank.entity.Account;
import com.capgemini.pecunia.bank.entity.Customer;
import com.capgemini.pecunia.bank.exceptions.AccountNotFoundException;
import com.capgemini.pecunia.bank.exceptions.TransactionException;
import com.capgemini.pecunia.bank.service.TransactionService;
import com.capgemini.pecunia.bank.util.walletConstants;


/****************************
 *          Description      It is a Rest full service class that provides the services for Transaction
  *         Version             1.0

 ****************************/


@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	

	/**********************************************************************************
     * Method              - creditUsingSlip
     *Description          - To credit balance using slip
     ** parameter- TxnForm - Txnform object to add a credit using slip
	 *@RequestBody -Txnform   -Request body that to credit using slip via txnform
     *Created By            - Satyam Singh                        
 
    *********************************************************************************/
	
	@PostMapping("/creditBySlip")
	public BankMessage creditUsingSlip(@RequestBody TxnForm txnform) throws AccountNotFoundException {

		transactionService.creditUsingSlip(txnform);
		BankMessage bankmessage=new BankMessage(walletConstants.TRANSACTION_SUCCESS);
		return bankmessage;
	}

	
	/**********************************************************************************
     * Method              - creditUsingCheque
     *Description          - To credit balance using Cheque
     ** parameter- Transfer - Transfer object to add a credit using Cheque
	 *@RequestBody -Transfer   -Request body that to credit using Cheque via Transfer 
     *Created By            - Satyam Singh                        
 
    *********************************************************************************/
	
	@PostMapping("/creditByCheque")
	public BankMessage creditByCheque(@RequestBody Transfer transfer) throws AccountNotFoundException, TransactionException {

		transactionService.creditUsingCheque(transfer);
		BankMessage bankmessage=new BankMessage(walletConstants.TRANSACTION_SUCCESS);

		return bankmessage;
	}
	
	
	
	
	/**********************************************************************************
     * Method              - Add Account
     *Description          - To add Account
     ** parameter- Account - Account object to add a Account
	 *@RequestBody -Account   -Request body to add acount 
     *Created By            - Satyam Singh                        
 
    *********************************************************************************/
	
	
	@PostMapping("/add_account")
	public BankMessage addAccount(@RequestBody Account account) {
		transactionService.addAccount(account);
		BankMessage bankmessage=new BankMessage(walletConstants.ACCOUNT_CREATED);

		return bankmessage;
	}

	
	
	
	/**********************************************************************************
     * Method              - DebitUsingSlip
     *Description          - To debit balance using slip
     ** parameter- TxnForm - Txnform object to  debit using slip
	 *@RequestBody -Txnform   -Request body that to debit using slip via txnform
     *Created By            - Kandala Lovaraju                      
 
    *********************************************************************************/
	@PostMapping("/debitBySlip")
	public BankMessage debitUsingSlip(@RequestBody TxnForm txnform) throws AccountNotFoundException, TransactionException {

		transactionService.debitUsingSlip(txnform);
		BankMessage bankmessage=new BankMessage(walletConstants.TRANSACTION_SUCCESS);

		return bankmessage;
	}
	

	

	
	/**********************************************************************************
     * Method              - debitUsingCheque
     *Description          - To debit balance using Cheque
     ** parameter- TxnForm - Txnform object to  debit using Cheque
	 *@RequestBody -Txnform   -Request body that to debit using Cheque via txnform
     *Created By            - Kandala Lovaraju                     
 
    *********************************************************************************/
	
	@PostMapping("/debitByCheque")
	public BankMessage debitByCheque(@RequestBody TxnForm txnform) throws AccountNotFoundException, TransactionException {

		transactionService.debitUsingCheque(txnform);
		BankMessage bankmessage=new BankMessage(walletConstants.TRANSACTION_SUCCESS);

		return bankmessage;
	}


	
	/**********************************************************************************
     * Method              - Add Customer
     *Description          - To add Customer
     ** parameter- Customer - Customer object to add Customer 
	 *@RequestBody -customer   -Request body to add Customer 
     *Created By            - Kandala Lovaraju                       
 
    *********************************************************************************/
	@PostMapping("/add_customer")
	public BankMessage addCustomer(@RequestBody Customer customer) {
		transactionService.addCust(customer);
		BankMessage bankmessage=new BankMessage(walletConstants.ACCOUNT_CREATED);

		return bankmessage;
	}

}