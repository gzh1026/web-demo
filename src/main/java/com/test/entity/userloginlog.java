package com.test.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class userloginlog {
    private int login_id;
    private int user_id;
    private String login_time;
    private String login_ip;
}
