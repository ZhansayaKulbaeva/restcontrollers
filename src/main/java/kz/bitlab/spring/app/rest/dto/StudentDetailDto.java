package kz.bitlab.spring.app.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDetailDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private int exam;
}
