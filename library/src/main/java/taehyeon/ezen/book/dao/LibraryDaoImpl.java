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
	public int getTotalLibraryCount() {
		String sql = "select count(*) as total from book";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public List<LibraryDto> listLibrary(int limit, int recordsPerPage) {
	    String sql = "select * from book order by id desc limit ?, ?";
	    return jdbcTemplate.query(sql, new Object[] { limit, recordsPerPage }, new LibraryRowMapper());
	}

	@Override
	public LibraryDto viewLibrary(int id) {
		String sql = "select * from book where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new LibraryRowMapper());
	}

	@Override
	public int selectBookTitle(String title, int id) {
		String sql = "select count(*) as total from book where id = ? and title = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id, title }, Integer.class);
	}

	@Override
	public int getSearchLibraryCount(String searchKey, String searchVal) {
		String sql = "select count(*) as total from book where " + searchKey + " like ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { "%" + searchVal + "%" }, Integer.class);
	}

	@Override
	public List<LibraryDto> listSearchLibrary(String searchKey, String searchVal, int limit, int recordsPerPage) {
		String sql = "select * from book where " + searchKey + " like ? order by id desc limit ?, ?";
		return jdbcTemplate.query(sql, new Object[] { "%" + searchVal + "%", limit, recordsPerPage }, new LibraryRowMapper());
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
