package dev.log2.tutorials.springmongodemo.dto;

import dev.log2.tutorials.springmongodemo.model.Student;

public interface StudentResponseFactory {

  static StudentResponse fromEntity(Student student) {
    return new StudentResponse(student.getId(), student.getFirstName(), student.getLastName(),
        student.getAge());
  }

}
