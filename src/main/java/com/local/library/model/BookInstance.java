package com.local.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "bookinstances")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookInstance {

    @NotNull
    private Long bookid;

    @NotBlank
    private String imprint;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate dueback;
}
