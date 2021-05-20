package com.renanmartins.bookstoremanager.users.builder;

import com.renanmartins.bookstoremanager.users.dto.UserDTO;
import com.renanmartins.bookstoremanager.users.enums.Gender;
import com.renanmartins.bookstoremanager.users.enums.Role;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public class UserDTOBuilder {

    @Builder.Default
    private Long id = 1L;

    @Builder.Default
    private String name = "Renan Martins";

    @Builder.Default
    private int age = 32;

    @Builder.Default
    private Gender gender = Gender.MALE;

    @Builder.Default
    private String email = "renan@teste.com";

    @Builder.Default
    private String username = "renanmartins";

    @Builder.Default
    private String password = "123456";

    @Builder.Default
    private LocalDate birthDate = LocalDate.of(1989,04,14);

    @Builder.Default
    private Role role = Role.USER;

    public UserDTO buildUserDTO(){
        return new UserDTO(
                id,
                name,
                age,
                gender,
                email,
                username,
                password,
                birthDate,
                role
        );
    }
}
