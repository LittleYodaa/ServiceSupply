package pl.patrykkawula.servicesupply.employee.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record EmployeeSaveDto(
        @Size(min = 2, message = "Imię musi mieć minimum 2 litery")
        String firstName,
        @Size(min = 2, message = "Nazwisko musi mieć minimum 2 litery")
        String lastName,
        @NotBlank(message = "Wprowadź adres email")
        @Email(message = "Nieprawidłowy format email")
        String email,
        @Size(min = 4, message = "Minimalna długość hasła to 4 znaki")
        String password,

        //todo
        //spróbować wykorzystać wzorzec pattern

        @NotBlank(message = "Wybierz jednostkę pracownika")
        String storeName,

        @NotBlank(message = "Wybierz rolę pracownika")
        String roleName) {
}
