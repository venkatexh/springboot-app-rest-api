package com.example.content_calendar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.http.HttpStatus;

import com.example.content_calendar.model.Content;
import com.example.content_calendar.repository.ContentRepository;

import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/content")
public class ContentController {

  private final ContentRepository repository;

  public ContentController(ContentRepository repository) {
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


  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  public void create(@Valid @RequestBody Content content) {
      content = new Content(null, content.title(), content.desc(), content.status(), content.contentType(), LocalDateTime.now(), null, content.url());
      repository.save(content);
  }
  

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PutMapping("/{id}")
  public void update(@RequestBody Content content, @PathVariable Integer id) {
      Content existingContent = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));

      Content updatedContent = new Content(id, content.title(), content.desc(), content.status(), content.contentType(), existingContent.createdAt(), null, content.url());
      repository.save(updatedContent);
  }


  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    repository.deleteById(id);
  }
  

  @GetMapping("/filter/type/{type}")
    public List<Content> filterByType(@PathVariable String type) {
        return repository.findAllByContentType(type.toUpperCase());
    }
}
