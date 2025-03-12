package kz.bitlab.spring.app.rest.service;

import kz.bitlab.spring.app.rest.model.Student;
import kz.bitlab.spring.app.rest.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public Student getStudent(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Long id, Student stud) {
        Student student = repository.findById(id).orElse(null);

        if (Objects.nonNull(student)) {
            return repository.save(stud);
        }

        return null;
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
