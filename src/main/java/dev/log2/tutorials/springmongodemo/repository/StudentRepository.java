package dev.log2.tutorials.springmongodemo.repository;

import dev.log2.tutorials.springmongodemo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

}