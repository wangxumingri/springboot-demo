package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * Author:Created by wx on 2019/12/31
 * Desc:
 */
@Data
public class User {
    private String oid;
    private String name; //姓名
    private String cardType; // 证件类型
    private String cardNumber; //证件号
    private String medicareCardNumber; //社保卡号
    private String cardImageUrl; //证件照片
    private Date birthDay; // 生日
    private Integer gender; // 性别，1男0女
    private Integer age;
    private String mobile;
    private String position; // 职位
    private String userType; // 用户类型 Admin管理员，Doctor医生，Guest普通用户
    private Date createdOn;
    private Date updatedOn;
    private String hospitalCode; // 医院code
    private String jobNumber;
    private String maritalStatus; // 婚姻状况
    private String nation; // 民族
    private String unionId;
    private Boolean testRole;//是否是测试人员
    private String roleType;//人员角色类型 UserRoleTypeEnum 胸痛中心医师，绿色通道主刀医师，绿色通道护士
    private String openId;
//    private String email;
//    private String patientNation;//民族

}
