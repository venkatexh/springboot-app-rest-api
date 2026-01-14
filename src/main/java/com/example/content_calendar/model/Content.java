package com.example.content_calendar.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record Content(
  Integer id,
  @NotEmpty
  @NotBlank
  String title,
  String desc,
  Status status,
  Type contentType,
  LocalDateTime createdAt,
  LocalDateTime updatedAt, 
  String url) {
}
