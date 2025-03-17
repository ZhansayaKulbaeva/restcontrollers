package kz.bitlab.spring.app.rest.mapper;

import kz.bitlab.spring.app.rest.dto.StudentChangeDto;
import kz.bitlab.spring.app.rest.dto.StudentChangeUpdateDto;
import kz.bitlab.spring.app.rest.dto.StudentDetailDto;
import kz.bitlab.spring.app.rest.dto.StudentDto;
import kz.bitlab.spring.app.rest.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "fullName",
            expression = "java(student.getName() + ' ' + student.getSurname())")
    StudentDto toDto(Student student);

    List<StudentDto> toDtoList(List<Student> student);

    @Mapping(target = "password", constant = "qwerty")
    @Mapping(source = "examPoint", target = "exam")
    Student toEntity(StudentChangeDto studentDto);

    @Mapping(target = "fullName",
            expression = "java(student.getName() + ' ' + student.getSurname())")
    StudentDetailDto toStudentDetailDto(Student student);

    Student toEntityUpdateChangeDto(@MappingTarget Student student,
                                    StudentChangeUpdateDto dto);
}
