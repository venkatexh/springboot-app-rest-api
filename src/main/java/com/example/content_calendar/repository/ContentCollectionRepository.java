package com.example.content_calendar.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.content_calendar.model.Content;
import com.example.content_calendar.model.Status;
import com.example.content_calendar.model.Type;

import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {
  private final List<Content> contentList = new ArrayList<>();

  public ContentCollectionRepository() {
  }

  public List<Content> findAll() {
    return contentList;
  }

  public Optional<Content> findById(Integer id) {
    return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
  }

  public void save(Content content){
    contentList.add(content);
  }

  public void delete(Integer id) {
    contentList.removeIf(c -> c.id().equals(id));
  }

  @PostConstruct
  private void init() {
    Content content = new Content(1, "first content", "this is a planned content", Status.IDEA, Type.ARTICLE, LocalDateTime.now(), null, "");
    contentList.add(content);
  }

  public boolean existsById(Integer id) {
    return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
  }
}
