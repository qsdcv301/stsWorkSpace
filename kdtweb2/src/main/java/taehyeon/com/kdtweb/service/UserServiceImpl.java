package taehyeon.com.kdtweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import taehyeon.com.kdtweb.dao.UserDao;
import taehyeon.com.kdtweb.model.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public int insertUser(UserDto dto) {
		return dao.insertUser(dto);
	}

	@Override
	public int updateUser(UserDto dto) {
		return dao.updateUser(dto);
	}

	@Override
	public int deleteUser(String userid) {
		return dao.deleteUser(userid);
	}

	@Override
	public UserDto getByUserId(Model model, String userid) {
		return dao.getByUserId(userid);
	}

	@Override
	public void getAll(Model model) {
		List<UserDto> dtos = dao.getAll();
		model.addAttribute("list", dtos);
	}

}
