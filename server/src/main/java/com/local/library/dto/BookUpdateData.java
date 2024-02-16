package com.local.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
public record BookUpdateData(@Size(max = 100) String title,

                             Long authorid,

                             @Size(max = 500) String summary,

                             @Size(max = 150) String isbn,

                             Long genreid) {
}
