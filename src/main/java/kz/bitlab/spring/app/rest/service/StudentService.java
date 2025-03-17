package kz.bitlab.spring.app.rest.service;

import kz.bitlab.spring.app.rest.dto.StudentChangeDto;
import kz.bitlab.spring.app.rest.dto.StudentChangeUpdateDto;
import kz.bitlab.spring.app.rest.dto.StudentDetailDto;
import kz.bitlab.spring.app.rest.dto.StudentDto;
import kz.bitlab.spring.app.rest.model.Student;
import kz.bitlab.spring.app.rest.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public List<StudentDto> getStudents() {
        List<StudentDto> students = new ArrayList<>();
        for (Student student : repository.findAll()) {
            students.add(toDto(student));
        }
        return students;
    }

    public StudentDetailDto getStudent(Long id) {
        Student student = repository.findById(id).orElse(null);
        return toStudentDetailDto(student);
    }

    public Student createStudent(StudentChangeDto dto) {
        return repository.save(toEntity(dto));
    }

    public Student updateStudent(Long id, StudentChangeUpdateDto stud) {
        Student student = repository.findById(id).orElse(null);

        if (Objects.nonNull(student)) {
            return repository.save(toEntityUpdateChangeDto(student, stud));
        }

        return null;
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    public StudentDto toDto(Student student) {

        if (Objects.isNull(student)) {
            return null;
        }

        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setSurname(student.getSurname());
        return studentDto;
    }

    public Student toEntity(StudentChangeDto studentDto) {
        if (Objects.isNull(studentDto)) {
            return null;
        }
        Student student = new Student();
        student.setEmail(studentDto.getEmail());
        student.setSurname(studentDto.getSurname());
        student.setName(studentDto.getName());
        student.setExam(studentDto.getExam());
        student.setPassword("qwerty");
        return student;
    }

    public StudentDetailDto toStudentDetailDto(Student student) {

        if (Objects.isNull(student)) {
            return null;
        }

        StudentDetailDto studentDto = new StudentDetailDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setSurname(student.getSurname());
        studentDto.setExam(student.getExam());
        studentDto.setEmail(student.getEmail());
        return studentDto;
    }

    public Student toEntityUpdateChangeDto(Student student, StudentChangeUpdateDto dto) {
        if (Objects.isNull(dto)) {
            return null;
        }

        student.setName(dto.getName());
        return student;
    }
}
