package com.pichincha.chaptermsanosqltemplate.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDetail {

	private LocalDateTime date;

	private Integer amount;

	private String transactionCode;

	private String symbol;

	private String price;

	private String total;
}
