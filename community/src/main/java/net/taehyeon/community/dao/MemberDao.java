package net.taehyeon.community.dao;

import net.taehyeon.community.model.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MemberDao {
    List<Member> getAllMem();
    Member getMem(int id);
    void insertMem(Member member);
    void updateMem(Member member);
    void deleteMem(int id);
}
