package com.test.entity;

import lombok.Data;
import lombok.ToString;



@Data
@ToString
public class user{

    private int user_id;
    private String user_name;
    private String email;
    private String cellphone;
    private String password;
    private int state;
    String create_time;


}
