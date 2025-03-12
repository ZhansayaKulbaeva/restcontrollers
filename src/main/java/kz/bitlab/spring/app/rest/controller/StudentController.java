package kz.bitlab.spring.app.rest.controller;

import kz.bitlab.spring.app.rest.model.Student;
import kz.bitlab.spring.app.rest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentService service;

    @GetMapping("/all")
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable Long id) {
        return service.getStudent(id);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody Student student) {
        return service.updateStudent(id, student);
    }
}
