package com.pichincha.chaptermsanosqltemplate.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("accounts")
public class Account {
	
	@Id
	private String id;

	@Field("account_id")
	private Integer accountId;
	
	private Integer limit;
	
	private List<String> products ;
	
	

}
