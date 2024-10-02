package taehyeon.com.kdtweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import taehyeon.com.kdtweb.model.UserDto;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insertUser(UserDto dto) {
		String sql = "insert into members (userid, userpass, username, useremail, usertel, userpost, useraddr1, useraddr2, useraddrexc)"
				+ " values (?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, dto.getUserid(), dto.getUserpass(), dto.getUsername(), dto.getUseremail(),
				dto.getUsertel(), dto.getUserpost(), dto.getUseraddr1(), dto.getUseraddr2(), dto.getUseraddrexc());
	}

	@Override
	public int updateUser(UserDto dto) {
		String sql = "update members set userpass=?, username=?, useremail=?, usertel=?"
				+ ", userpost=?, useraddr1=?, useraddr2=?, useraddrexc=?" + " where userid=?";
		return jdbcTemplate.update(sql, dto.getUserpass(), dto.getUsername(), dto.getUseremail(),
				dto.getUsertel(), dto.getUserpost(), dto.getUseraddr1(), dto.getUseraddr2(), dto.getUseraddrexc(),
				dto.getUserid());
	}

	@Override
	public int deleteUser(String userid) {
		String sql = "delete from members where userid =?";
		return jdbcTemplate.update(sql, userid);
	}

	@Override
	public UserDto getByUserId(String userid) {
		String sql = "select * from members where userid = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { userid }, new UserRowMapper());
	}

	@Override
	public List<UserDto> getAll() {
		String sql = "select * from members order by userid desc";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}
	
	private static class UserRowMapper implements RowMapper<UserDto> {

		@Override
		public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserDto dto = new UserDto();
			dto.setId(rs.getInt("id"));
			dto.setUserid(rs.getString("userid"));
			dto.setUserpass(rs.getString("userpass"));
			dto.setUsername(rs.getString("username"));
			dto.setUseremail(rs.getString("useremail"));
			dto.setUsertel(rs.getString("usertel"));
			dto.setUserpost(rs.getInt("userpost"));
			dto.setUseraddr1(rs.getString("useraddr1"));
			dto.setUseraddr2(rs.getString("useraddr2"));
			dto.setUseraddrexc(rs.getString("useraddrexc"));
			return dto;
		}

	}

}
