package ru.test.mtm.db;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {
	@Column(name = "id", unique = true)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENT_ID_GENERATOR")
	@SequenceGenerator(name = "SEQ_CLIENT_ID_GENERATOR", sequenceName = "id_gen", allocationSize = 1)
	private Integer id;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "mtm_author_book",
			joinColumns = {@JoinColumn(name = "author_id", nullable = false, referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "book_id", nullable = false, referencedColumnName = "id")})
	private Set<Book> books = new HashSet<>();
	@Column(name = "name")
	private String text;

	public Integer getId() {
		return id;
	}

	public void setId(Integer pId) {
		id = pId;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> pBooks) {
		books = pBooks;
	}

	public String getText() {
		return text;
	}

	public void setText(String pText) {
		text = pText;
	}

	@Override
	public boolean equals(Object pO) {
		if (this == pO) return true;
		if (!(pO instanceof Author)) return false;

		Author author = (Author) pO;

		return id != null ? id.equals(author.id) : author.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}
}
