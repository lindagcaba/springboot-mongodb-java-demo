package dev.log2.tutorials.springmongodemo.dto;

import dev.log2.tutorials.springmongodemo.model.Student;

public interface StudentRequestFactory {

  static Student toEntity(StudentRequest request){
    Student student = new Student();
    student.setFirstName(request.firstName());
    student.setLastName(request.lastName());
    student.setAge(request.age());
    return student;
  }
}
