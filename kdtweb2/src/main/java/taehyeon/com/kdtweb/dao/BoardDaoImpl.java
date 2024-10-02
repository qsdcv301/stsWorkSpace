package taehyeon.com.kdtweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import taehyeon.com.kdtweb.model.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insertBoard(BoardDto dto) {
		String sql = "insert into bbs_bbs (title, contents, writer, userid, password) "
				+ "values (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, dto.getTitle(), dto.getContents(), dto.getWriter(), 
			dto.getUserid(), dto.getPassword());
	}

	@Override
	public int updateBoard(BoardDto dto) {
		String sql = "update bbs_bbs SET title = ?, contents = ?, writer = ?, password = ? where num = ?";
		return jdbcTemplate.update(sql, dto.getTitle(), dto.getContents(), dto.getWriter(), 
			dto.getPassword(), dto.getNum());
	}

	@Override
	public int updateCount(long num) {
		String sql = "update bbs_bbs set count = count + 1 where num = ?";
		return jdbcTemplate.update(sql, num);
	}

	@Override
	public int deleteBoard(long num) {
		String sql = "delete from bbs_bbs where num = ?";
		return jdbcTemplate.update(sql, num);
	}

	@Override
	public int getTotalBoardCount() {
		String sql = "select count(*) as total from bbs_bbs";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	@Override
	public List<BoardDto> listBoard(int limit, int recordsPerPage) {
	    String sql = "select * from bbs_bbs order by num desc limit ?, ?";
	    return jdbcTemplate.query(sql, new Object[] { limit, recordsPerPage }, new BoardRowMapper());
	}

	@Override
	public BoardDto viewBoard(long num) {
		String sql = "select * from bbs_bbs where num = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { num }, new BoardRowMapper());
	}

	@Override
	public int selectUserId(String userid, int num) {
		String sql = "select count(*) as total from bbs_bbs where num = ? and userid = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { num, userid }, Integer.class);
	}

	@Override
	public int isPass(long num, String pass) {
		String sql = "select count(*) as ispass from bbs_bbs where password = ? and num = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { pass, num }, Integer.class);
	}

	@Override
	public int getSearchBoardCount(String searchKey, String searchVal) {
		String sql = "select count(*) as total from bbs_bbs where " + searchKey + " like ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { "%" + searchVal + "%" }, Integer.class);
	}

	@Override
	public List<BoardDto> listSearchBoard(String searchKey, String searchVal, int limit, int recordsPerPage) {
		String sql = "select * from bbs_bbs where " + searchKey + " like ? order by num desc limit ?, ?";
		return jdbcTemplate.query(sql, new Object[] { "%" + searchVal + "%", limit, recordsPerPage }, new BoardRowMapper());
	}

	private static class BoardRowMapper implements RowMapper<BoardDto> {
		@Override
		public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardDto board = new BoardDto();
			board.setNum(rs.getLong("num"));
			board.setTitle(rs.getString("title"));
			board.setContents(rs.getString("contents"));
			board.setWriter(rs.getString("writer"));
			board.setUserid(rs.getString("userid"));
			board.setPassword(rs.getString("password"));
			board.setCount(rs.getInt("count"));

			return board;
		}
	}
}
