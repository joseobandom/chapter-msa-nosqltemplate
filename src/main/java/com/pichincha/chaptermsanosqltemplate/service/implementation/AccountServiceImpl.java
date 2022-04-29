package com.pichincha.chaptermsanosqltemplate.service.implementation;

import com.pichincha.chaptermsanosqltemplate.dto.AccountDto;
import com.pichincha.chaptermsanosqltemplate.entity.Account;
import com.pichincha.chaptermsanosqltemplate.mappers.AccountMapper;
import com.pichincha.chaptermsanosqltemplate.repository.IAccount;
import com.pichincha.chaptermsanosqltemplate.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {


    private final IAccount objIAccount;
    private final AccountMapper accountMapper;

    @Override
    public List<AccountDto> getAllAccounts() {
        return objIAccount.findAll()
                .stream()
                .map(accountMapper::toAccountDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto getAccountByAccountId(Integer id) {
        return accountMapper.toAccountDto(objIAccount.findAccountByAccountId(id));

    }

    @Override
    public AccountDto createAccount(AccountDto account) {
        return accountMapper.toAccountDto(objIAccount.save(accountMapper.toAccount(account)));
    }

    @Override
    public AccountDto editAccount(AccountDto account, String id) {
        Optional<Account> acc = objIAccount.findById(id);
        return acc.map(accountMapper::toAccountDto).orElse(null);
    }

    @Override
    public void deleteAccount(String id) {
        objIAccount.deleteById(id);
    }
}
