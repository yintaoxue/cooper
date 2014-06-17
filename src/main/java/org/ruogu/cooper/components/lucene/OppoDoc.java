package org.ruogu.cooper.components.lucene;

/**
 * 商机文档类
 * <p>建索引的实体类</p>
 * 
 * @author xueyintao 2014年6月13日 下午2:26:34
 * @since 1.0
 */
public class OppoDoc {
	private String oppoId;
	private String userId;
	private Integer userType;
	private Integer cityId;
	private Integer productLine;
	private String companyFullName;
	private String tel;
	private String contactPersonTel;
	private String contactPersonMobile;
	
	public String getOppoId() {
		return oppoId;
	}
	public void setOppoId(String oppoId) {
		this.oppoId = oppoId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getProductLine() {
		return productLine;
	}
	public void setProductLine(Integer productLine) {
		this.productLine = productLine;
	}
	public String getCompanyFullName() {
		return companyFullName;
	}
	public void setCompanyFullName(String companyFullName) {
		this.companyFullName = companyFullName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getContactPersonTel() {
		return contactPersonTel;
	}
	public void setContactPersonTel(String contactPersonTel) {
		this.contactPersonTel = contactPersonTel;
	}
	public String getContactPersonMobile() {
		return contactPersonMobile;
	}
	public void setContactPersonMobile(String contactPersonMobile) {
		this.contactPersonMobile = contactPersonMobile;
	}
	
	@Override
	public String toString() {
		return "OppoDoc [oppoId=" + oppoId + ", userId=" + userId + ", userType=" + userType + ", cityId=" + cityId
				+ ", productLine=" + productLine + ", company_full_name=" + companyFullName + ", tel=" + tel
				+ ", contactPersonTel=" + contactPersonTel + ", contactPersonMobile=" + contactPersonMobile + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
		result = prime * result + ((companyFullName == null) ? 0 : companyFullName.hashCode());
		result = prime * result + ((contactPersonMobile == null) ? 0 : contactPersonMobile.hashCode());
		result = prime * result + ((contactPersonTel == null) ? 0 : contactPersonTel.hashCode());
		result = prime * result + ((oppoId == null) ? 0 : oppoId.hashCode());
		result = prime * result + ((productLine == null) ? 0 : productLine.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OppoDoc other = (OppoDoc) obj;
		if (cityId == null) {
			if (other.cityId != null)
				return false;
		} else if (!cityId.equals(other.cityId))
			return false;
		if (companyFullName == null) {
			if (other.companyFullName != null)
				return false;
		} else if (!companyFullName.equals(other.companyFullName))
			return false;
		if (contactPersonMobile == null) {
			if (other.contactPersonMobile != null)
				return false;
		} else if (!contactPersonMobile.equals(other.contactPersonMobile))
			return false;
		if (contactPersonTel == null) {
			if (other.contactPersonTel != null)
				return false;
		} else if (!contactPersonTel.equals(other.contactPersonTel))
			return false;
		if (oppoId == null) {
			if (other.oppoId != null)
				return false;
		} else if (!oppoId.equals(other.oppoId))
			return false;
		if (productLine == null) {
			if (other.productLine != null)
				return false;
		} else if (!productLine.equals(other.productLine))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}
}
