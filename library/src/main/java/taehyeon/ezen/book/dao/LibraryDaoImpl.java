package taehyeon.ezen.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import taehyeon.ezen.book.dto.LibraryDto;


@Repository
public class LibraryDaoImpl implements LibraryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insertLibrary(LibraryDto dto) {
		String sql = "insert into book (title, writer, isbn, publication) "
				+ "values (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, dto.getTitle(), dto.getWriter(), dto.getIsbn(), dto.getPublication());
	}

	@Override
	public int updateLibrary(LibraryDto dto) {
		String sql = "update book SET title = ?, writer = ?, isbn = ?, publication = ? where id = ?";
		return jdbcTemplate.update(sql, dto.getTitle(), dto.getWriter(),dto.getIsbn(), 
				dto.getPublication(), dto.getId());
	}

	@Override
	public int deleteLibrary(int id) {
		String sql = "delete from book where id = ?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public List<LibraryDto> listLibrary() {
	    String sql = "select * from book order by id desc";
	    return jdbcTemplate.query(sql, new Object[] { }, new LibraryRowMapper());
	}

	@Override
	public LibraryDto viewLibrary(int id) {
		String sql = "select * from book where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new LibraryRowMapper());
	}

	private static class LibraryRowMapper implements RowMapper<LibraryDto> {
		@Override
		public LibraryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			LibraryDto library = new LibraryDto();
			library.setId(rs.getInt("id"));
			library.setTitle(rs.getString("title"));
			library.setWriter(rs.getString("writer"));
			library.setIsbn(rs.getString("isbn"));
			library.setPublication(rs.getTimestamp("publication"));
			return library;
		}
	}
}
