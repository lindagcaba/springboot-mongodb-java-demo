package dev.log2.tutorials.springmongodemo.controller;

import dev.log2.tutorials.springmongodemo.dto.StudentRequest;
import dev.log2.tutorials.springmongodemo.dto.StudentResponse;
import dev.log2.tutorials.springmongodemo.dto.StudentResponseFactory;
import dev.log2.tutorials.springmongodemo.model.Student;
import dev.log2.tutorials.springmongodemo.service.StudentService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }


  @PostMapping
  public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest studentRequest) {
    StudentResponse studentResponse = StudentResponseFactory.fromEntity(
        studentService.createStudent(studentRequest));
    return ResponseEntity.ok(studentResponse);
  }

  @GetMapping
  public ResponseEntity<List<StudentResponse>> getStudents() {
    List<StudentResponse> studentResponses = studentService.getStudents().stream()
        .map(StudentResponseFactory::fromEntity).collect(
            Collectors.toList());
    return ResponseEntity.ok(studentResponses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<StudentResponse> getStudent(@PathVariable String id){
    Student student = studentService.getStudent(id);
    return ResponseEntity.ok(StudentResponseFactory.fromEntity(student));
  }


}
