package org.springframework.issues;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;

/**
 * @author Rod Johnson
 * @author Juergen Hoeller
 */
@SuppressWarnings("serial")
public class CallCountingTransactionManager extends AbstractPlatformTransactionManager {

	public TransactionDefinition lastDefinition;
	public int begun;
	public int commits;
	public int rollbacks;
	public int inflight;

	protected Object doGetTransaction() {
		return new Object();
	}

	protected void doBegin(Object transaction, TransactionDefinition definition) {
		this.lastDefinition = definition;
		++begun;
		++inflight;
	}

	protected void doCommit(DefaultTransactionStatus status) {
		++commits;
		--inflight;
	}

	protected void doRollback(DefaultTransactionStatus status) {
		++rollbacks;
		--inflight;
	}

	public void clear() {
		begun = commits = rollbacks = inflight = 0;
	}

}