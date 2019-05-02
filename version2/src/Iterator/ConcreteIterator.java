package Iterator;

import model.Account;

public class ConcreteIterator implements ITerator {
	private AccountAggregate aa;
    private int index;
    public ConcreteIterator(AccountAggregate aa ) {
        this.aa = aa;
        this.index = 0;
    }
    public boolean hasNext() {
        if (index < aa.getLength()) {
            return true;
        } else {
            return false;
        }
    }
    public Object next() {
        Account account = aa.getAccountAt(index);
        index++;
        return account;
    }
}
