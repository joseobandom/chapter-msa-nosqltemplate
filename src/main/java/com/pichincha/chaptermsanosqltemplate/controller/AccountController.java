package com.pichincha.chaptermsanosqltemplate.controller;

import com.pichincha.chaptermsanosqltemplate.dto.AccountDto;
import com.pichincha.chaptermsanosqltemplate.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AccountController {

    private final IAccountService objIAccount;

    @GetMapping("accounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        return new ResponseEntity<>(objIAccount.getAllAccounts(), HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDto> getAccountByAccountId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(objIAccount.getAccountByAccountId(id), HttpStatus.OK);

    }

    @PostMapping("/account")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto account) {
        return new ResponseEntity<>(objIAccount.createAccount(account), HttpStatus.OK);
    }

    @PutMapping("/account/{id}")
    public ResponseEntity<?> editAccount(@RequestBody AccountDto account, @PathVariable String id) {
        return new ResponseEntity<>(objIAccount.editAccount(account, id), HttpStatus.OK);
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") String id) {
        objIAccount.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
