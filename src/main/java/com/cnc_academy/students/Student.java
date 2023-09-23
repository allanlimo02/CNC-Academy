package com.cnc_academy.students;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;

@Setter
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
