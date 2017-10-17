package ru.test.mtm.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
	@Column(name = "id", unique = true)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENT_ID_GENERATOR")
	@SequenceGenerator(name = "SEQ_CLIENT_ID_GENERATOR", sequenceName = "id_gen", allocationSize = 1)
	private Integer id;

	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "books")
	private Set<Author> authors = new HashSet<>();

	@Column(name = "name")
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer pId) {
		id = pId;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> pAuthors) {
		authors = pAuthors;
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		name = pName;
	}
}
