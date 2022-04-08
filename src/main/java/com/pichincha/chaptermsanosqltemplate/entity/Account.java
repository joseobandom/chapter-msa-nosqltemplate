package com.pichincha.chaptermsanosqltemplate.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Document("accounts")
public class Account {
	
	@Id
	private String id;
	
	private Integer accountId;
	
	private Integer limit;
	
	private List<String> products ;
	
	

}
