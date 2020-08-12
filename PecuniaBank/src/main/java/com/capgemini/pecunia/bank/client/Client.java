
package com.capgemini.pecunia.bank.client;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.pecunia.bank.dto.Transfer;
import com.capgemini.pecunia.bank.dto.TxnForm;
import com.capgemini.pecunia.bank.entity.Account;
import com.capgemini.pecunia.bank.entity.Customer;
import com.capgemini.pecunia.bank.exceptions.AccountNotFoundException;
import com.capgemini.pecunia.bank.exceptions.TransactionException;
import com.capgemini.pecunia.bank.service.TransactionService;

public class Client {
	public static void main(String[] args) throws AccountNotFoundException, TransactionException {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfiguration.class);
		
//		Customer custom = new Customer();
//		custom.setAadharNumber("6226442");
//		custom.setAddress("raipur");
//		custom.setCity("raipur");
//		custom.setName("pritam");
//		custom.setPhoneNumber("708752445343");
//		custom.setCountry("india");
//		custom.setDateOfBirth(LocalDate.of(2020, 9, 26));
//		custom.setGender("male");
//		custom.setPanNumber("hsdhs");
//		custom.setState("chattisgarh");
//		custom.setZipcode("bhshsdh");
////
//		Account acco= new Account();
//		acco.setAccountId("73228665");
//		acco.setAccountType("saving");
//		acco.setBranchId("ghsvg");
//		acco.setBalance(15000.0);
//		acco.setCustomer(custom);
//		acco.setIfsc("83583");

//		TxnForm txnform=new TxnForm();
//		txnform.setAccId("7322866");
//		txnform.setAmount(100.0);

//		Transfer transfer = new Transfer();
//	transfer.setAmount(100.0);
//	transfer.setFromAccId("73228665");
//	transfer.setToAccId("7322866");
		// Account account = null; //account.setAccount_id(4596);

//		 Slip slip=new Slip(64735373L, "Credit", 5000, LocalDate.now(), "Completed",
//		 acc, 4635363L);

		// Cheque(int transaction_id, String transaction_type, double
		/*
		 * transaction_amount, LocalDate transaction_date,String transaction_status,
		 * Account account, int cheque_id, String ifsc_code, LocalDate
		 * cheque_issue_date, int beneficiary_account_number) //Cheque cheque = new
		 * Cheque("42", "Debit", 2500, LocalDate.now(), "Completed", account, "7914",
		 * "SBIN00856", LocalDate.of(2020, 04, 15), "985");
		 */

		TransactionService service = ctx.getBean(TransactionService.class);

	//	service.addAccount(acco);
//		 service.addCust(custom);
		// service.addCheque(cheque);
//		 service.creditUsingSlip(txnform);
		//service.creditUsingCheque(transfer);
		System.out.println("Insert Complete");

	}
}
