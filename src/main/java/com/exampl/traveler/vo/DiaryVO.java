package com.exampl.traveler.vo;

import lombok.Data;

import java.util.Date;
@Data
public class DiaryVO {
    private Integer diaryNO;
    private Integer orderID;
    private String userId;
    private Date GoDay;
    private Date BackDay;
    private Date AllDay;
    private String DiaryTitle;
    private String DiaryColor;

}
