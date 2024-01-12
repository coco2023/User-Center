package com.UmiUni.shop.userauthservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@DiscriminatorValue("EMPLOYEE")
public class Employee extends BasicUser {

    private String userType; //ADMIN, TESTER

    private LocalDateTime lastLoginTime;
}
