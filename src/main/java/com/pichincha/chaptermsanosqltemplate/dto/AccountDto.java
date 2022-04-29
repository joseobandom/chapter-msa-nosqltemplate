package com.pichincha.chaptermsanosqltemplate.dto;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public class AccountDto {
    private String id;

    private Integer accountId;

    private Integer limit;

    private List<String> products ;
}
