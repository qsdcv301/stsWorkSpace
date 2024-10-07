package net.taehyeon.community.service;

import net.taehyeon.community.mapper.MemberMapper;
import net.taehyeon.community.model.CustomUserDetails;
import net.taehyeon.community.model.Member;
import net.taehyeon.community.model.MemberRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberMapper.getMemberUserId(username);
        if(member == null) {
            throw new UsernameNotFoundException("회원 정보가 없습니다.");
        }
        List<MemberRole> roles = (List<MemberRole>) memberMapper.getMemberRole(member.getId());

        return new CustomUserDetails(member, roles);
    }
}
