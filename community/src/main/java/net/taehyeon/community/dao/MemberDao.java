package net.taehyeon.community.dao;

import net.taehyeon.community.model.Member;
import net.taehyeon.community.model.MemberRole;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MemberDao {
    List<Member> getAllMem();
    Member getMem(int id);
    void insertMem(Member member);
    void updateMem(Member member);
    void deleteMem(int id);
    void insertMemRole(MemberRole memberRole);
}
