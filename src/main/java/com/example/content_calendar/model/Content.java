package com.example.content_calendar.model;

import java.time.LocalDateTime;

public record Content(
  Integer id,
  String title,
  String desc,
  Status status,
  Type contentType,
  LocalDateTime createdAt,
  LocalDateTime updatedAt, String url) {
}
