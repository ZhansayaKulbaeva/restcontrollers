package kz.bitlab.spring.app.rest.repository;

import kz.bitlab.spring.app.rest.model.Student;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {

    public static Specification<Student> searchStudents(String name){
        return (root, query, criteriaBuilder) -> criteriaBuilder.or(
                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("name")), name),
                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("surname")), name)
        );
    }
}
