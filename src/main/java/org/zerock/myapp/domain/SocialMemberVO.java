package org.zerock.myapp.domain;

import lombok.Value;

@Value
public class SocialMemberVO {
	
	private Integer member_no;
	private String id;
	private String email;
	private String social_type;
	private Integer address1;
	private String address2;
	private String address3;
	private String gender;
	private Integer birth_year;
	private Integer birth_month;
	private Integer birth_day;
	
} // end class