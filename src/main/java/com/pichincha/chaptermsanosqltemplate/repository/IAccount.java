package com.pichincha.chaptermsanosqltemplate.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pichincha.chaptermsanosqltemplate.entity.Account;

public interface IAccount extends MongoRepository<Account, String>{
	
	@Query("{accountId:?0}")
    Account findAccountByAccountId(Integer accountId);
    
    //@Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<Account> findAll();
    

}
