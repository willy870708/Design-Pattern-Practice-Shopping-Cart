package Iterator;

import model.Account;

public class AccountAggregate implements Aggregate {

	private Account[] account;
	private int last = 0;

	public AccountAggregate(int maxsize) {
		this.account = new Account[maxsize];
	}

	public Account getAccountAt(int index) {
		return account[index];
	}

	public void appendAccount(Account account) {
		this.account[last] = account;
		last++;
	}

	public int getLength() {
		return last;
	}

	public ITerator iterator() {
		return new ConcreteIterator(this);
	}

public void remove(Account account){
	for(int i = 0;i< this.getLength();i++){
		if(this.account[i]==account){
			this.account[i]=this.account[i+1];
			last-=1;
		}
	}
}
}
