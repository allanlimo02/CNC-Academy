package com.cnc_academy.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Student createStudent(Student student) {
        // You can perform validation and business logic here
        return studentRepository.save(student);
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Student getStudentById(Long admNo) {
        return studentRepository.findById(admNo).orElse(null);
    }

    @Transactional
    public Student updateStudent(Long admNo, Student updatedStudent) {
        // You can perform validation and business logic here
        Student existingStudent = getStudentById(admNo);
        if (existingStudent != null) {
            // Update the existing student with the new data
            existingStudent.setFirstName(updatedStudent.getFirstName());
            existingStudent.setParentName(updatedStudent.getParentName());
            existingStudent.setDateOfAdmission(updatedStudent.getDateOfAdmission());
            existingStudent.setDateOfBirth(updatedStudent.getDateOfBirth());
            existingStudent.setEmergencyContact(updatedStudent.getEmergencyContact());
            return studentRepository.save(existingStudent);
        }
        return null; // Handle the case where the student with the given ID does not exist
    }

    @Transactional
    public void deleteStudent(Long admNo) {
        studentRepository.deleteById(admNo);
    }
}
