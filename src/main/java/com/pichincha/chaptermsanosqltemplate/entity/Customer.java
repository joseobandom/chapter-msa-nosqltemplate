package com.pichincha.chaptermsanosqltemplate.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Document("customers")
public class Customer {

	@Id
	private String id;

	private String username;

	private String name;

	private String address;

	private LocalDateTime birthdate;

	private String email;

	private Boolean active;

	private List<BigInteger> accounts;

	private List<TierDetail> tierAndDetails;

}
