package org.springframework.issues.validation;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.mycompany.spring.aop.aspect.annotation.Protect;
import com.mycompany.spring.aop.aspect.annotation.Trace;

@Service
@Validated
public class CustomerService {

    @Length(min = 3, max = 5)
    @Trace
    @Protect
    public String createUser(@NotBlank @Email final String email, @NotBlank final String username, @NotBlank final String password) {
        return username;
    }

    @Length(min = 3, max = 5)
    @Trace
    @Protect
    public String readUser(@NotBlank final String custmerNumber) {
        return custmerNumber;
    }

}