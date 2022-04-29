package com.pichincha.chaptermsanosqltemplate.service;

import java.util.List;

import com.pichincha.chaptermsanosqltemplate.entity.Account;

public interface IAccountService {
	

	public List<Account> getAllAccounts();

	public Account getAccountByAccountId(Integer id);

	public Account createAccount(Account account);

	public Account editAccount(Account account, String id);

	public void deleteAccount(String id);
}
