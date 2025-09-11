package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Long createStudent(Student student) {
        return studentRepository.create(student);
    }

    public boolean updateStudent(Student student) {
        return studentRepository.update(student) > 0;
    }

    public boolean deleteStudent(Long id) {
        return studentRepository.deleteById(id) > 0;
    }
}


