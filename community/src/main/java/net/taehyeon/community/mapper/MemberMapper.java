package net.taehyeon.community.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.taehyeon.community.model.Member;
import net.taehyeon.community.model.MemberRole;

@Mapper
public interface MemberMapper {
    Member getMemberUserId(String userid);
    List<MemberRole> getMemberRole(int id);
    void insertMember(Member member);
    void setInsertRole(MemberRole role);
}
