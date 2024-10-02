package taehyeon.ezen.book.dto;

import java.sql.Timestamp;

public class LibraryDto {
	private int id;
	private String title;
	private String writer;
	private String isbn;
	private Timestamp publication;

	public LibraryDto() {
	}

	public LibraryDto(int id, String title, String writer, String isbn, Timestamp publication) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.isbn = isbn;
		this.publication = publication;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Timestamp getPublication() {
		return publication;
	}

	public void setPublication(Timestamp publication) {
		this.publication = publication;
	}

	@Override
	public String toString() {
		return "BoardDto [id=" + id + ", title=" + title + ", writer=" + writer + ", isbn=" + isbn + ", publication="
				+ publication + "]";
	}

}
