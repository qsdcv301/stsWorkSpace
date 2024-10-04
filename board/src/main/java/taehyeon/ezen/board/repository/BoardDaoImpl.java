package taehyeon.ezen.board.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import taehyeon.ezen.board.dto.BoardDto;


@Repository
public class BoardDaoImpl implements BoardDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertBoard(BoardDto dto) {
        String sql = "insert into board (title, writer, contents) "
                + "values (?, ?, ?)";
        return jdbcTemplate.update(sql, dto.getTitle(), dto.getWriter(), dto.getContents());
    }

    @Override
    public int updateBoard(BoardDto dto) {
        String sql = "update board SET title = ?, writer = ?, contents = ? where num = ?";
        return jdbcTemplate.update(sql, dto.getTitle(), dto.getWriter(), dto.getContents(), dto.getNum());
    }

    @Override
    public int deleteBoard(long num) {
        String sql = "delete from board where num = ?";
        return jdbcTemplate.update(sql, num);
    }

    @Override
    public int getTotalBoardCount() {
        String sql = "select count(*) as total from board";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<BoardDto> listBoard(int limit, int recordsPerPage) {
        String sql = "select * from board order by num desc limit ?, ?";
        return jdbcTemplate.query(sql, new Object[]{limit, recordsPerPage}, new BoardRowMapper());
    }

    @Override
    public BoardDto viewBoard(long num) {
        String sql = "select * from board where num = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{num}, new BoardRowMapper());
    }

    @Override
    public int selectBoardTitle(String title, long num) {
        String sql = "select count(*) as total from board where num = ? and title = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{num, title}, Integer.class);
    }

    @Override
    public int getSearchBoardCount(String searchKey, String searchVal) {
        String sql = "select count(*) as total from board where " + searchKey + " like ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{"%" + searchVal + "%"}, Integer.class);
    }

    @Override
    public List<BoardDto> listSearchBoard(String searchKey, String searchVal, int limit, int recordsPerPage) {
        String sql = "select * from board where " + searchKey + " like ? order by num desc limit ?, ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + searchVal + "%", limit, recordsPerPage}, new BoardRowMapper());
    }

    private static class BoardRowMapper implements RowMapper<BoardDto> {
        @Override
        public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            BoardDto Board = new BoardDto();
            Board.setNum(rs.getLong("num"));
            Board.setTitle(rs.getString("title"));
            Board.setWriter(rs.getString("writer"));
            Board.setContents(rs.getString("contents"));
            Board.setCreate_at(rs.getTimestamp("create_at"));
            return Board;
        }
    }
}
