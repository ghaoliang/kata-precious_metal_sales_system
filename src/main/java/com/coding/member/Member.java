package com.coding.member;

import java.math.BigDecimal;

/**
 * 会员类
 */
public class Member {
    //会员姓名
    private String memberName;
    //会员等级
    private String memberLevel;
    //会员卡号
    private String memberId;
    //会员积分
    private Integer memberPoint;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(String memberLevel) {
        this.memberLevel = memberLevel;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

	public Integer getMemberPoint() {
		return memberPoint;
	}

	public void setMemberPoint(Integer memberPoint) {
		this.memberPoint = memberPoint;
	}

}
