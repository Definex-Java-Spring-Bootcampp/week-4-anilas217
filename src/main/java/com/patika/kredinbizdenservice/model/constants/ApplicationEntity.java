package com.patika.kredinbizdenservice.model.constants;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationEntity {
    public static final String application_status = "application_status";
    public static final String localDateTime = "localDateTime";
    public static final String create_date = "create_date";
    public static final String update_date = "update_date";

}
