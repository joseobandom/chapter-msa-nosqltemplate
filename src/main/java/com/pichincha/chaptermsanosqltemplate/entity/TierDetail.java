package com.pichincha.chaptermsanosqltemplate.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TierDetail {
	@Id
	private String id;

	private String tier;

	private Boolean active;

	private List<String> benefits;

}
