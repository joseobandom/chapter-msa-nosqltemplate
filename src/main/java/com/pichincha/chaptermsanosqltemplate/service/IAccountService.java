package com.pichincha.chaptermsanosqltemplate.service;

import java.util.List;

import com.pichincha.chaptermsanosqltemplate.dto.AccountDto;
import com.pichincha.chaptermsanosqltemplate.entity.Account;

public interface IAccountService {
	

	public List<AccountDto> getAllAccounts();

	public AccountDto getAccountByAccountId(Integer id);

	public AccountDto createAccount(AccountDto account);

	public AccountDto editAccount(AccountDto account, String id);

	public void deleteAccount(String id);
}
