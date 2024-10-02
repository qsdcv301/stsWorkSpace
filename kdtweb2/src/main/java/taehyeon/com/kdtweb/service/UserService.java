package taehyeon.com.kdtweb.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import taehyeon.com.kdtweb.model.UserDto;

@Service
public interface UserService {
	int insertUser(UserDto dto);

	int updateUser(UserDto dto);

	int deleteUser(String userid);

	UserDto getByUserId(Model model, String userid); // 내용보기

	void getAll(Model model); // 목록보기
}
