// package com.hamzacicek.todoapplication.annotation;

// import jakarta.validation.Constraint;
// import jakarta.validation.Payload;
// import java.lang.annotation.ElementType;
// import java.lang.annotation.Retention;
// import java.lang.annotation.RetentionPolicy;
// import java.lang.annotation.Target;

// @Constraint(validatedBy = UniqueTitleValidator.class)
// @Target({ ElementType.FIELD })
// @Retention(RetentionPolicy.RUNTIME)
// public @interface UniqueTitle {
//     String message() default "{task.title.validation.constraints.Unique.message}";

//     Class<?>[] groups() default {};

//     Class<? extends Payload>[] payload() default {};
// }
