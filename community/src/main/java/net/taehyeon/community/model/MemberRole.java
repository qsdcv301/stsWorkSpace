package net.taehyeon.community.model;

import lombok.Data;

@Data
public class MemberRole {
    private int id;
    private int membersid;
    private String userRole;
}
