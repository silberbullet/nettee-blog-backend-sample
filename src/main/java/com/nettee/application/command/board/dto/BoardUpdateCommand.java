package com.nettee.application.command.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BoardUpdateCommand(
        @NotNull Long id,
        @NotBlank String title,
        @NotBlank String content
) {
}
