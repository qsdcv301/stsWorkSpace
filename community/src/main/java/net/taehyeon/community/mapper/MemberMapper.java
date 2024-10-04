package net.taehyeon.community.mapper;

import net.taehyeon.community.model.Member;
import net.taehyeon.community.model.MemberRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member getMemberUserId(String userid);
    void insertMember(Member member);
    void setInsertRole(MemberRole role);
}
