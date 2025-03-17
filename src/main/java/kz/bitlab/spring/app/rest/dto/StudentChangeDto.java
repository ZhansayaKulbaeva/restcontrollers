package kz.bitlab.spring.app.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentChangeDto {

    @NotBlank(message = "name must be not empty")
    @Size(min = 5, max = 10, message = "min must be 5 and max must be 10")
    private String name;

    @NotEmpty
    private String surname;

    @Email(message = "Email bolu kerek")
    @NotNull(message = "email must be not null")
    private String email;

//    @Pattern(regexp = "qwertasdf", message = "")
    private int examPoint;
}
