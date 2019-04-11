/**
 * 
 */
package lab06;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import lab06.AccountService;
import lab06.Account;
import lab06.AccountManager;
/**
  @author zeng
  @date 2019年4月11日 上午9:06:00
  @Descripton
 */
public class AccountServiceTest {
	@Test
	public void testTransfer(){
		MockAccountManager mo=new MockAccountManager();

		Account  a1=new Account("1",200);
		Account  a2=new Account("2",100);
		mo.addAccount("1", a1);
		mo.addAccount("2", a2);
		
		
		AccountService as=new AccountService();
		as.setAccountManager(mo);
		as.transfer("1", "2",50);
		
		Assert.assertEquals(150, a1.getBalance());
		Assert.assertEquals(150, a1.getBalance());
		
	}
	private class MockAccountManager implements AccountManager {

		/* (non-Javadoc)
		 * @see lab06.AccountManager#findAccountForUser(java.lang.String)
		 */
		public Map<String,Account> accounts=new HashMap<String, Account>();
		//
		public void addAccount(String userid,Account account){
			this.accounts.put(userid, account);
		}
		
		@Override
		public Account findAccountForUser(String userId) {
			// TODO Auto-generated method stub
			return this.accounts.get(userId);
		}

		/* (non-Javadoc)
		 * @see lab06.AccountManager#updateAccount(lab06.Account)
		 */
		@Override
		public void updateAccount(Account account) {
			//执行数据库中的操作，可省略
			
		}
		
		
	}
}
