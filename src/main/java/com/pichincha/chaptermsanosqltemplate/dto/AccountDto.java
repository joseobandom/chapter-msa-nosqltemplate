package com.pichincha.chaptermsanosqltemplate.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
@Data
public class AccountDto {
    private String id;

    private Integer accountId;

    private Integer limit;

    private List<String> products ;
}
