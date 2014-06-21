package org.ruogu.cooper.components.solr;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

public class OppoDoc {

	@Field
	private Long id;// 主键
	
	@Field
	private Long userId;// 用户id

	@Field
	private Integer userType;// 用户类型(0:个人,1:企业;

	@Field
	private Long productLine; // 产品线id

	@Field
	private String companyFullName; // 公司全称

	@Field
	private Integer cityId; // 城市id

	@Field
	private String tel; // 公司电话

	@Field
	private String contactPersonTel; // 联系人固定电话

	@Field
	private String contactPersonMobile; // 联系人手机
	
	@Field
	private Date createTime; // 创建时间

	@Field
	private Long relationId;// 关联id

	public OppoDoc() {
	}
}
