package com.pichincha.chaptermsanosqltemplate.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.chaptermsanosqltemplate.entity.Account;
import com.pichincha.chaptermsanosqltemplate.repository.IAccount;
import com.pichincha.chaptermsanosqltemplate.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	IAccount objIAccount;

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		objIAccount.findAll().forEach(accounts::add);
		return accounts;
	}

	@Override
	public Account getAccountByAccountId(Integer id) {
		Account account = (objIAccount.findAccountByAccountId(id));
		return account;
	}

	@Override
	public Account createAccount(Account account) {
		Account _account = objIAccount.save(account);
		return _account;
	}

	@Override
	public Account editAccount(Account account, String id) {
		Optional<Account> acc = objIAccount.findById(id);
		if (acc.isPresent()) {
			Account _account = acc.get();
			_account.setAccountId(account.getAccountId());
			_account.setLimit(account.getLimit());
			_account.setProducts(account.getProducts());
			_account = objIAccount.save(account);
			return _account;
		}
		return null;
	}

	@Override
	public void deleteAccount(String id) {
		objIAccount.deleteById(id);
	}
}
