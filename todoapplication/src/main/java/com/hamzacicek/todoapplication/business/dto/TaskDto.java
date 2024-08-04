package com.hamzacicek.todoapplication.business.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

// import com.hamzacicek.todoapplication.annotation.UniqueTitle;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
public class TaskDto implements Serializable {
    // id, title, description, status, due date, created at

    public static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "{task.title.validation.constraints.NotEmpty.message}")
    @Size(min = 1, max = 255, message = "{task.title.validation.constraints.Size.message}")
    // @UniqueTitle
    private String title;

    @Size(max = 1000, message = "{task.description.validation.constraints.Size.message}")
    private String description;

    @Builder.Default
    private Long status = 0L;

    @NotNull(message = "{task.dueDate.validation.constraints.NotNull.message}")
    @FutureOrPresent(message = "{task.dueDate.validation.constraints.FutureOrPresent.message}")
    private LocalDate dueDate;

    @Builder.Default
    private Date createdAt = new Date(System.currentTimeMillis());
}
