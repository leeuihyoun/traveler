package com.exampl.traveler.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MemberVO {
    private String userID;
    private String userPW;
    private String userBirth;
    private String userEmail;
    private String userName;
    private String userTell;
    private String userWish;
}
