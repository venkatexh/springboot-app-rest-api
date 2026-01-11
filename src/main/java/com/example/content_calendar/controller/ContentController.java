package com.example.content_calendar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.content_calendar.model.Content;
import com.example.content_calendar.repository.ContentCollectionRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/content")
public class ContentController {

  private final ContentCollectionRepository repository;

  public ContentController(ContentCollectionRepository repository) {
    this.repository = repository;

  }


  @GetMapping
  public List<Content> findAll() {
      return repository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Content> findById(@PathVariable Integer id) {
      return Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found")));
  }
  
  
}
