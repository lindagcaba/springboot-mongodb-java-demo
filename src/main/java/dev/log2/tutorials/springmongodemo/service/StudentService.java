package dev.log2.tutorials.springmongodemo.service;

import dev.log2.tutorials.springmongodemo.dto.StudentRequest;
import dev.log2.tutorials.springmongodemo.dto.StudentRequestFactory;
import dev.log2.tutorials.springmongodemo.model.Student;
import dev.log2.tutorials.springmongodemo.repository.StudentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public Student  createStudent(StudentRequest studentRequest){
     Student student = StudentRequestFactory.toEntity(studentRequest);
    return studentRepository.save(student);
  }

  public List<Student> getStudents(){
      return studentRepository.findAll();
  }

  public Student getStudent(String id){
    return studentRepository.findById(id).orElseThrow();
  }

}
