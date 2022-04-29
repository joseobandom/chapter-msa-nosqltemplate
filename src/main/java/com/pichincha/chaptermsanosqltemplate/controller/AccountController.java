package com.pichincha.chaptermsanosqltemplate.controller;

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
import com.pichincha.chaptermsanosqltemplate.service.IAccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	IAccountService objIAccount;

	@GetMapping("accounts")
	public ResponseEntity<?> getAllAccounts() {
		try {
			return new ResponseEntity<>(objIAccount.getAllAccounts(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/account/{id}")
	public ResponseEntity<?> getAccountByAccountId(@PathVariable("id") Integer id) {

		try {
			return new ResponseEntity<>(objIAccount.getAccountByAccountId(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/account")
	public ResponseEntity<?> createAccount(@RequestBody Account account) {
		try {
			return new ResponseEntity<>(objIAccount.createAccount(account), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/account/{id}")
	public ResponseEntity<?> editAccount(@RequestBody Account account, @PathVariable String id) {
		try {

			return new ResponseEntity<>(objIAccount.editAccount(account, id), HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/account/{id}")
	public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("id") String id) {
		try {
			objIAccount.deleteAccount(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
