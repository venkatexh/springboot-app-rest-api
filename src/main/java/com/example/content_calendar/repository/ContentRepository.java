package com.example.content_calendar.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.example.content_calendar.model.Content;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
  List<Content> findAllByContentType(String type);
}