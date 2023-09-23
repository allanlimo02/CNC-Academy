package com.cnc_academy.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        if (createdStudent != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{admNo}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long admNo) {
        Student student = studentService.getStudentById(admNo);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{admNo}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long admNo,
            @RequestBody Student updatedStudent
    ) {
        Student updated = studentService.updateStudent(admNo, updatedStudent);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{admNo}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long admNo) {
        studentService.deleteStudent(admNo);
        return ResponseEntity.noContent().build();
    }
}
