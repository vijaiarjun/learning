package com.example.datastore.domain;

import org.springframework.data.annotation.Id;

public class Book {
  @Id
  Long id;
  String title;
  String author;
  String category;
  int year;

  public Book(String title, String author, int year, String category) {
    this.title = title;
    this.author = author;
    this.year = year;
    this.category = category;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getYear() {
    return year;
  }

  public String getCategory() {
    return category;
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", category='" + category + '\'' +
        ", year=" + year +
        '}';
  }
}
