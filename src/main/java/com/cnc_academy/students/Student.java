package com.cnc_academy.students;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    public long admNo;
    public String firstName;
    public String parentName;
    public Date dateOfAdmission;
    public Date dateOfBirth;
    public String emergencyContact;


}
