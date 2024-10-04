package net.taehyeon.community.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Member {
    private int id;
    private String userid;
    private String userpass;
    private String username;
    private String useremail;
    private String usertel;
    private int zipcode;
    private String address;
    private String detail_address;
    private String extra_address;
    private String userimg;
    private String oruserimg;
    private String userprofile;
    private Date create_at;
    private Date edit_at;
    private String userip;
    private int grade;
}
