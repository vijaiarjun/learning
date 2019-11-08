package com.example.datastore;

import com.example.datastore.domain.Book;
import com.example.datastore.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
  @Autowired
  BookRepository bookRepository;

  @PostMapping(path = "/book", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity saveBook(@RequestBody Book book) {
    bookRepository.save(book);
    return new ResponseEntity(HttpStatus.OK);
  }

  @GetMapping(path = "/book")
  public ResponseEntity<List<Book>> findAllBooks() {
    return new ResponseEntity<List<Book>>((List<Book>) bookRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping(path = "/book/{id}")
  public ResponseEntity<Optional<Book>> findBooksById(@PathVariable("id") Long id) {
    return new ResponseEntity<Optional<Book>>((Optional<Book>) bookRepository.findById(id), HttpStatus.OK);
  }

  @PutMapping(path = "book/{id}")
  public ResponseEntity updateBook(@RequestBody Book book, @PathVariable("id") Long id) {
    bookRepository.findById(id).ifPresent(
        existingBook -> {
          bookRepository.deleteById(existingBook.getId());
          bookRepository.save(book);
        }
    );
    return new ResponseEntity(HttpStatus.OK);
}
}
