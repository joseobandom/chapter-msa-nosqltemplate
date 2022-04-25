package com.pichincha.chaptermsanosqltemplate.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.chaptermsanosqltemplate.entity.Account;
import com.pichincha.chaptermsanosqltemplate.repository.IAccount;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	IAccount objIAccount;

	@GetMapping("accounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		objIAccount.findAll().forEach(accounts::add);
		return new ResponseEntity<>(accounts, HttpStatus.OK);
	}

	@GetMapping("/account/{id}")
	public ResponseEntity<Account> getAccountByAccountId(@PathVariable("id") Integer id) {
		Account account = (objIAccount.findAccountByAccountId(id));

		return new ResponseEntity<>(account, HttpStatus.OK);
	}

	@PostMapping("/account")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		try {

			Account _account = objIAccount.save(account);
			return new ResponseEntity<>(_account, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/account/{id}")
	public ResponseEntity<Account> editAccount(@RequestBody Account account, @PathVariable String id) {
		try {
			Optional<Account> acc = objIAccount.findById(id);
			if (acc.isPresent()) {
				Account _account = acc.get();
				_account.setAccountId(account.getAccountId());
				_account.setLimit(account.getLimit());
				_account.setProducts(account.getProducts());
				_account = objIAccount.save(account);
				return new ResponseEntity<>(_account, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/account/{id}")
	public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") String id) {
		try {
			objIAccount.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
