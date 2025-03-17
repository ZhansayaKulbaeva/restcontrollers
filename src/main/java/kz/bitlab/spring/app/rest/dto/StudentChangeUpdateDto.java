package kz.bitlab.spring.app.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentChangeUpdateDto {
    @NotBlank(message = "name must be not empty")
    @Size(min = 5, max = 10, message = "min must be 5 and max must be 10")
    private String name;
}
