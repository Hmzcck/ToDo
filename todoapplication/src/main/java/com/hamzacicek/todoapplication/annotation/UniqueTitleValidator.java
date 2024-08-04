package com.hamzacicek.todoapplication.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.hamzacicek.todoapplication.data.repository.TaskRepository;

@Component
@RequiredArgsConstructor
public class UniqueTitleValidator implements ConstraintValidator<UniqueTitle, String> {

    private final TaskRepository taskRepository;

    @Override
    public boolean isValid(String title, ConstraintValidatorContext context) {
        if (title == null || title.isEmpty()) {
            return true; // @NotEmpty will handle this case
        }

        return !taskRepository.existsByTitle(title);
    }
}
