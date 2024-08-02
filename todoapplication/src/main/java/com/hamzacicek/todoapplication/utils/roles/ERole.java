package com.hamzacicek.todoapplication.utils.roles;

/**
 * Enum representing different user roles.
 */
public enum ERole {
    ADMIN(1L, "admin"),
    USER(2L, "user");

    // Variables
    private final Long key;
    private final String value;

    // Constructor
    ERole(Long key, String value) {
        this.key = key;
        this.value = value;
    }

    // Getters
    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
} // end Enum ERole
