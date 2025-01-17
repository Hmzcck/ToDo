package com.hamzacicek.todoapplication.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
// Entity
@Entity
@Table(name = "task")
public class TaskEntity implements Serializable {

    // Serializable
    public static final long serialVersionUID = 1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", unique = true, nullable = false, updatable = false)
    private Long id;

    // Title
    @Column(nullable = false, length = 255, unique = true)
    private String title;

    // Description
    @Column(length = 1000)
    private String description;

    // Status
    @Builder.Default
    @Column(nullable = false)
    private Long status = 0L;

    // Due Date
    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    // Created At
    @Builder.Default
    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date(System.currentTimeMillis());
}//end class
