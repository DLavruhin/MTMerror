package ru.test.mtm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.test.mtm.db.Author;
import ru.test.mtm.db.AuthorRepository;
import ru.test.mtm.db.Book;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class AuthorServiceImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorServiceImpl.class);
	@Autowired
	private AuthorRepository mAuthorRepository;


	@Transactional
	public void addBooks(Author pAuthor, Set<Book> pBooks) {
		LOGGER.info("Start add book");
		pAuthor.getBooks().addAll(pBooks);
		mAuthorRepository.save(pAuthor);
	}

	@Transactional
	public void deleteBooks(Author pAuthor, Set<Book> pBooks) {
		LOGGER.info("Delete book");
		pAuthor.getBooks().removeAll(pBooks);
	}
}
