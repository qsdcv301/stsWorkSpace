package net.taehyeon.community.dao;

import net.taehyeon.community.mapper.MemberMapper;
import net.taehyeon.community.model.Member;
import net.taehyeon.community.model.MemberRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> getAllMem() {
        return List.of();
    }

    @Override
    public Member getMem(int id) {
        return null;
    }

    @Override
    public void insertMem(Member member) {
        memberMapper.insertMember(member);
    }

    @Override
    public void updateMem(Member member) {

    }

    @Override
    public void deleteMem(int id) {

    }

    @Override
    public void insertMemRole(MemberRole memberRole) {
        memberMapper.setInsertRole(memberRole);
    }
}
