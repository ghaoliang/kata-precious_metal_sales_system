package com.coding.member.service;

import com.coding.member.Member;
import com.coding.utils.MemberFactory;

/**
 * 会员信息服务类
 * @author: gaohaoliang
 */
public class MemberService {

    public Member getMemberInfoByMemberId(String memberId){
        return MemberFactory.getMemberInfoByMemberId(memberId);
    }
}
