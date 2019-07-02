package com.coding.sales.member;

import com.coding.member.Member;
import com.coding.member.service.MemberService;
import com.coding.utils.MemberFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MemberInitTest {

    @Test
    public void getMemberInfo(){
        MemberService memberService = new MemberService();
        assertEquals("马丁",memberService.getMemberInfoByMemberId("6236609999").getMemberName());
        assertEquals("王立",memberService.getMemberInfoByMemberId("6630009999").getMemberName());
        assertEquals("李想",memberService.getMemberInfoByMemberId("8230009999").getMemberName());
        assertEquals("张三",memberService.getMemberInfoByMemberId("9230009999").getMemberName());

    }
}
