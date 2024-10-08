package net.taehyeon.community.mapper;

import java.util.List;

import net.taehyeon.community.model.BbsAdmin;

public interface BbsAdminMapper {
	void insertBbsAdmin(BbsAdmin dto);
	void updateBbsAdmin(BbsAdmin dto);
	void deleteBbsAdmin(int id);
	BbsAdmin selectById(int id);
	List<BbsAdmin> selectList();
}
