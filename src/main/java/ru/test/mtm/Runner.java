package ru.test.mtm;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.test.mtm.db.Author;
import ru.test.mtm.db.AuthorRepository;
import ru.test.mtm.db.Book;
import ru.test.mtm.db.BookRepository;
import ru.test.mtm.service.AuthorServiceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Runner {
	private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);
	@Autowired
	private AuthorRepository mAuthorRepository;
	@Autowired
	private BookRepository mBookRepository;
	@Autowired
	private AuthorServiceImpl mAuthorService;

	@Scheduled(initialDelay = 1,fixedRate = Integer.MAX_VALUE)
	private void run() {
		LOGGER.info("Start runner");
		List<Author> all = mAuthorRepository.findAll();
		Author author = all.get(0);
		Set<Book> selBooks = new HashSet<>();
		List<Book> books = mBookRepository.findAll();
		selBooks.add(books.get(0));
		mAuthorService.addBooks(author, selBooks);
		selBooks = new HashSet<>();
		selBooks.add(books.get(1));
		mAuthorService.addBooks(author, selBooks);

	}
}
