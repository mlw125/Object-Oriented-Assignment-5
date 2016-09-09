package simpleAccount.test;
//
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import simpleAccount.model.AccountModel;
import simpleAccount.model.User;
 
public class AccountModelTest {
 AccountModel account;
 List<User> accountList;
 
 @Before
 public void setup() throws Exception {
	 account = new AccountModel();
	 //accountList = new ArrayList<User>();
	 account.load("input.txt");
	 //accountList = account.users;
	 account.returnList();
 }
 
 @SuppressWarnings("deprecation")
@Test
 public void testRun() {
		String title = "000xxx Nguyen,Daniel";
		
		// test the deposit
		account.deposit("U", title, "50");
		assertEquals("Deposit should result in $50 increase in balance.", 1550,
		  		account.users.get(0).getAmount(), 0.01);
		
		// test the withdraw
		account.withdraw("U", title, "100");
		assertEquals("The account balance should have been decreased by $100.", 1450.0, account.users.get(0).getAmount(), 0.01);
		
		// test NumberFormatException in withdraw
		NumberFormatException caught = null;
		try {
			account.withdraw("U", title, "AA.0");
		} catch (NumberFormatException t) {
		   caught = t;
		}
		System.out.println(caught);
		assertNotNull(caught);
 }
}
