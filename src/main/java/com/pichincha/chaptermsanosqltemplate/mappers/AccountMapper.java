package com.pichincha.chaptermsanosqltemplate.mappers;

import com.pichincha.chaptermsanosqltemplate.dto.AccountDto;
import com.pichincha.chaptermsanosqltemplate.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    Account toAccount(AccountDto accountDto);

    AccountDto toAccountDto(Account account);
}
