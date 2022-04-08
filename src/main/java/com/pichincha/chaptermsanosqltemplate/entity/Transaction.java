package com.pichincha.chaptermsanosqltemplate.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document("transactions")
public class Transaction {
	
	@Id
	private String id;
	
	private int accountId;
	
	private int transactionCount;
	
	private LocalDateTime bucketStartDate;
	
	private LocalDateTime bucketEndDate;
	
	private List<TransactionDetail> transactions;

}
