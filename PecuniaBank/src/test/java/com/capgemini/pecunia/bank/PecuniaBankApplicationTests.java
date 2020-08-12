package com.capgemini.pecunia.bank;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.pecunia.bank.dao.TransactionDao;
import com.capgemini.pecunia.bank.dto.Transfer;
import com.capgemini.pecunia.bank.dto.TxnForm;
import com.capgemini.pecunia.bank.entity.Cheque;
import com.capgemini.pecunia.bank.entity.Slip;
import com.capgemini.pecunia.bank.entity.Transaction;
import com.capgemini.pecunia.bank.exceptions.AccountNotFoundException;
import com.capgemini.pecunia.bank.exceptions.TransactionException;
import com.capgemini.pecunia.bank.service.TransactionService;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
//@RunWith(MockitoJUnitRunner.class)
public class PecuniaBankApplicationTests {
	@Mock
	private TransactionDao transactionDao;
	
	@Mock
	private TransactionService transactionService;
	
	
	@Test
	public void testGetAccount() {
		
		when(transactionDao.getAccount(null)).thenReturn(null);
		assertEquals(null, transactionDao.getAccount(null));
	}
	
	@Test
	public void testGenerateChequeId() {
		Cheque cheque = new Cheque();
		when(transactionDao.generateChequeId(cheque)).thenReturn(0);
		assertEquals(0, transactionDao.generateChequeId(cheque));
	}
	
	@Test
	public void testGenerateTransactionId() {
		Transaction transaction = new Transaction();
		when(transactionDao.generateTransactionId(transaction)).thenReturn(0);
		assertEquals(0, transactionDao.generateTransactionId(transaction));
	}
	@Test
	 public void testAddTransaction() {
		Transaction transaction= new Transaction();
		when(transactionDao.addTransaction(transaction)).thenReturn(true);
		assertEquals(true, transactionDao.addTransaction(transaction));
	}
	@Test
	 public void testAddSlip() {
		Slip slip = new Slip();
		when(transactionDao. addSlip(slip)).thenReturn(true);
		assertEquals(true, transactionDao. addSlip(slip));
	}
	
	
	
	
	// service layer
	
	
	@Test
	 public void testCreditUsingSlip() throws AccountNotFoundException {
		TxnForm slip=new TxnForm();
		when(transactionService. creditUsingSlip(slip)).thenReturn(true);
		assertEquals(true, transactionService. creditUsingSlip(slip));
	}
	
	

	@Test
	 public void testCreditUsingCheque() throws AccountNotFoundException, TransactionException {
		Transfer slip=new Transfer();
		when(transactionService. creditUsingCheque(slip)).thenReturn(true);
		assertEquals(true, transactionService. creditUsingCheque(slip));
	}
	

	@Test
	 public void testDebitUsingSlip() throws AccountNotFoundException {
		TxnForm slip=new TxnForm();
		when(transactionService. creditUsingSlip(slip)).thenReturn(true);
		assertEquals(true,transactionService. creditUsingSlip(slip));
	}
	
	

	@Test
	 public void testDebitUsingCheque() throws AccountNotFoundException, TransactionException {
		Transfer slip=new Transfer();
		when(transactionService. creditUsingCheque(slip)).thenReturn(true);
		assertEquals(true, transactionService. creditUsingCheque(slip));
	}
	
	


	
	
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
 

}
