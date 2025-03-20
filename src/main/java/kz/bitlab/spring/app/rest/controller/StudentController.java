package kz.bitlab.spring.app.rest.controller;

import jakarta.validation.Valid;
import kz.bitlab.spring.app.rest.dto.StudentChangeDto;
import kz.bitlab.spring.app.rest.dto.StudentChangeUpdateDto;
import kz.bitlab.spring.app.rest.dto.StudentDetailDto;
import kz.bitlab.spring.app.rest.dto.StudentDto;
import kz.bitlab.spring.app.rest.model.Student;
import kz.bitlab.spring.app.rest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentService service;

    // Два параметра page - номер страницы, size - количество записей
    @GetMapping("/all")
    public Page<StudentDto> getStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        return service.getStudents(pageable);
    }

    @GetMapping("{id}")
    public StudentDetailDto getStudent(@PathVariable Long id) {
        return service.getStudent(id);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @PostMapping("/create")
    public Student createStudent(@Valid @RequestBody StudentChangeDto dto) {
        return service.createStudent(dto);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody StudentChangeUpdateDto dto) {
        return service.updateStudent(id, dto);
    }

    @GetMapping("/search")
    public Page<StudentDto> search(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page,size);
        return service.searchStudents(name, pageable);
    }
}
