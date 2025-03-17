package kz.bitlab.spring.app.rest.service;

import kz.bitlab.spring.app.rest.dto.StudentChangeDto;
import kz.bitlab.spring.app.rest.dto.StudentChangeUpdateDto;
import kz.bitlab.spring.app.rest.dto.StudentDetailDto;
import kz.bitlab.spring.app.rest.dto.StudentDto;
import kz.bitlab.spring.app.rest.mapper.StudentMapper;
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
    private final StudentMapper mapper;

    public List<StudentDto> getStudents() {
        List<Student> students = repository.findAll();
        return mapper.toDtoList(students);
    }

    public StudentDetailDto getStudent(Long id) {
        Student student = repository.findById(id).orElse(null);
        return mapper.toStudentDetailDto(student);
    }

    public Student createStudent(StudentChangeDto dto) {
        return repository.save(mapper.toEntity(dto));
    }

    public Student updateStudent(Long id, StudentChangeUpdateDto stud) {
        Student student = repository.findById(id).orElse(null);

        if (Objects.nonNull(student)) {
            return repository.save(mapper.toEntityUpdateChangeDto(student, stud));
        }

        return null;
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
