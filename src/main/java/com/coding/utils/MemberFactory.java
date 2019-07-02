package com.coding.utils;

import com.coding.member.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberFactory {

    private static Map<String,Member> memberMap = new HashMap<String,Member>();

    /**
     * 初始化会员信息的memberMap
     */
    static{
        memberMap.put("6236609999",getMemberMaDing());
        memberMap.put("6630009999",getMemberWangLi());
        memberMap.put("8230009999",getMemberLiXiang());
        memberMap.put("9230009999",getMemberZhangSan());
    }

    /**
     * 工厂方法创建对应会员
     * @param memberId
     * @return
     */
    public static Member getMemberInfoByMemberId(String memberId){
        return memberMap.get(memberId);
    }

    /**
     * 获取马丁的会员类信息
     * @return
     */
    private static Member getMemberMaDing(){
        Member member = new Member();
        member.setMemberId("6236609999");
        member.setMemberLevel("普卡");
        member.setMemberName("马丁");
        member.setMemberPoint(9860);
        return member;
    }

    /**
     * 获取马丁的会员类信息
     * @return
     */
    private static Member getMemberWangLi(){
        Member member = new Member();
        member.setMemberId("6630009999");
        member.setMemberLevel("金卡");
        member.setMemberName("王立");
        member.setMemberPoint(48860);
        return member;
    }

    /**
     * 获取马丁的会员类信息
     * @return
     */
    private static Member getMemberLiXiang(){
        Member member = new Member();
        member.setMemberId("8230009999");
        member.setMemberLevel("白金卡");
        member.setMemberName("李想");
        member.setMemberPoint(98860);
        return member;
    }

    /**
     * 获取马丁的会员类信息
     * @return
     */
    private static Member getMemberZhangSan(){
        Member member = new Member();
        member.setMemberId("9230009999");
        member.setMemberLevel("钻石卡");
        member.setMemberName("张三");
        member.setMemberPoint(198860);
        return member;
    }

}
