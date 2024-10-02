package taehyeon.com.kdtweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import taehyeon.com.kdtweb.model.UserDto;

@Repository
public interface UserDao {
	int insertUser(UserDto dto);

	int updateUser(UserDto dto);

	int deleteUser(String userid);

	UserDto getByUserId(String userid); // 내용보기

	List<UserDto> getAll(); // 목록보기
}
