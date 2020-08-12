package com.capgemini.pecunia.bank;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
//import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.pecunia.bank.dao.TransactionDao;
import com.capgemini.pecunia.bank.dao.TransactionDaoImpl;
import com.capgemini.pecunia.bank.dto.Transfer;
import com.capgemini.pecunia.bank.dto.TxnForm;
import com.capgemini.pecunia.bank.entity.Account;
import com.capgemini.pecunia.bank.entity.Cheque;
import com.capgemini.pecunia.bank.entity.Customer;
import com.capgemini.pecunia.bank.entity.Slip;
import com.capgemini.pecunia.bank.entity.Transaction;
import com.capgemini.pecunia.bank.exceptions.AccountNotFoundException;
import com.capgemini.pecunia.bank.exceptions.TransactionException;
import com.capgemini.pecunia.bank.service.TransactionService;
import com.capgemini.pecunia.bank.web.TransactionController;



@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
//@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
public class TransactionTestTesting {

	@Mock
	TransactionService transactionService;
	
	/*
	 * Logger used to Record unusual circumstances or error that may be happening in the program.
	 * also use to get info what is going in the application.
	 */
	
	
	Logger logger = LoggerFactory.getLogger(TransactionController.class);
	

	/*
	 * @Autowired is used to
	 * Inject the dependency of walletService class into WalletApplicationProjectBackendApplicationTests class.
	 * It internally uses setter or constructor to inject dependency.  
	 */
	
	@Autowired 
	TransactionService transactionServiceObject;
	
	private TransactionDao transactionDao = new TransactionDaoImpl();
	
	TxnForm txnform  = new TxnForm();
	Transfer transfer = new Transfer();
    boolean message = false;
	
	
	
	
	
	@Test
	public void depositMoney() throws AccountNotFoundException
	{
		TxnForm slip=new TxnForm();
		transactionService.creditUsingSlip(slip);
			
	}

	

	
	@Test
	public void withdrawalMoney() throws AccountNotFoundException, TransactionException 
	{
		Transfer transfer=new Transfer();
		transactionService.creditUsingCheque(transfer);
			
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	@BeforeAll
	static void setUpBeforeClass() {
		System.out.println("Feating resouce Fetching resources for testing ...");
	}
	
	/*
	 *  @BeforeEach annotation is used to signal that this method should be executed before all test cases.
	 */
	@BeforeEach
	void setup() {
		System.out.println("Test Case Started");
	}
	
	
	/*
	 *  @AfterEach annotation is used to signal that this method should be executed after all test cases.
	 */
	@AfterEach
	void tearDown() {
		System.out.println("Test Case Over");
	}
	
//	public Boolean creditUsingSlip(TxnForm txnform) throws AccountNotFoundException;
//
//	public Boolean debitUsingSlip(TxnForm txnform) throws AccountNotFoundException,TransactionException;
//
//	public Boolean creditUsingCheque(Transfer transfer) throws AccountNotFoundException,TransactionException;
//
//	public Boolean debitUsingCheque(TxnForm txnform) throws AccountNotFoundException,TransactionException;
//
//	public Boolean addSlip(Slip slip);
//
//	public boolean addCust(Customer cust);
//
//	public boolean addCheque(Cheque cheque);
//	
//	public boolean addAccount(Account account);
	
	/*
	 * Test will do testing for creditUsingSlip() method which fetches credit through slip from database
	 */
	
	//--------------------- TEST CASE 1 -----------------------------//
			/*
			 * In this test case we are passing a invalid Account Number
			 * that function throws  AccountNotFoundException ".
			 */
				
//	@Test
//	@DisplayName("creditUsingSlip")
//	public void testCreditUsingSlips() throws Exception{
//		logger.info("Validation for creditUsingSlip From Database");
//		txnform.setAccId("123456");
//		txnform.setAmount(2500.00);
//		 assertThrows(AccountNotFoundException.class,()->{
//			transactionService.creditUsingSlip(txnform);
//			
//		});
//		
//	}
		
		
		//--------------------- TEST CASE 2 -----------------------------//
		/*
		 * In this test case we are passing a valid Account Number
		 * that function throws  Exception ".
		 */
		
		@Test
		@DisplayName("creditUsingSlip")
		public void testCreditUsingSlipss() throws Exception{
			
			logger.info("Validation for creditUsingSlip From Database");
			txnform.setAccId("73228665");
			txnform.setAmount(2500.00);
			boolean result = transactionService.creditUsingSlip(txnform);
			
			assertEquals(result, message);		
			
	}

		/*
		 * Test will do testing for debitUsingSlip() method which fetches credit through slip from database
		 */

		@Test
		@DisplayName("DebitUsingSlip")
		public void testDebitUsingSlipss() throws Exception{
			
			logger.info("Validation for DebitUsingSlip From Database");
			txnform.setAccId("73228665");
			txnform.setAmount(500.00);
			boolean result = transactionService.debitUsingSlip(txnform);
			
			assertEquals(result, message);		
			
	}
		
		/*
		 * Test will do testing for debitUsingSlip() method which fetches debit through Slip from database
		 */

		@Test
		@DisplayName("creditUsingCheque")
		public void testCreditUsingCheque() throws Exception{
			
			logger.info("Validation for creditUsingCheque From Database");
			transfer.setFromAccId("73228665");
			transfer.setToAccId("7322866");
			transfer.setAmount(5000.00);

			boolean result = transactionService.creditUsingCheque(transfer);
			
			assertEquals(result, message);		
			
	}
		
		/*
		 * Test will do testing for debitUsingSlip() method which fetches debit through cheque from database
		 */

		@Test
		@DisplayName("DebitUsingCheque")
		public void testDebitUsingChequee() throws Exception{
			
			logger.info("Validation for DebitUsingCheque From Database");
			txnform.setAccId("73228665");
			txnform.setAmount(500.00);

			boolean result = transactionService.debitUsingCheque(txnform);
			
			assertEquals(result, message);		
			
	}
		
		/*
		 * Test will do testing for addslip() method which fetches  slip from database
		 */

		@Test
		@DisplayName("AddSlip")
		public void testAddSlip() throws Exception{
			
			logger.info("Validation for AddSlip From Database");
			Slip slip = new Slip();
			slip.setSlipId(1231L);

			boolean result = transactionService.addSlip(slip);
			
			assertEquals(result, message);		
			
	}
		
		/*
		 * Test will do testing for addCheque() method which fetches  cheque from database
		 */

		@Test
		@DisplayName("Add Cheque")
		public void testAddCheque() throws Exception{
			
			logger.info("Validation for Add Cheque From Database");
			Cheque cheque = new Cheque();
			cheque.setChequeId(9844L);
			cheque.setIfsc("SBI72825");
			cheque.getChequeIssueDate();

			boolean result = transactionService.addCheque(cheque);
			
			assertEquals(result, message);		
			
	}

		
	}
	

	
	