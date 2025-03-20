package kz.bitlab.spring.app.rest.repository;

import kz.bitlab.spring.app.rest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {
    List<Student> findAllByNameContainingIgnoreCase(String name);
}