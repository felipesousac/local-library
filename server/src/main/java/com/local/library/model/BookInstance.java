package com.local.library.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;


// PODE SER NECESSARIO INCLUIR A ANOTACAO DE ENTITY
@Table(name = "bookinstances")
@Entity(name = "Bookinstance")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class BookInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long bookid;

    @NotBlank
    private String imprint;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate dueback;
}
