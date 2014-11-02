package org.ruogu.cooper.components.httpclient.gps;

import java.math.BigDecimal;

/**
 * Address
 *
 * @author xueyintao 2014年11月2日 下午5:17:12
 */
public class Loc {
	
	private int status;
	private BigDecimal lng;
	private BigDecimal lat;
	private int precise;
	private int confidence;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public BigDecimal getLng() {
		return lng;
	}
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public int getPrecise() {
		return precise;
	}
	public void setPrecise(int precise) {
		this.precise = precise;
	}
	public int getConfidence() {
		return confidence;
	}
	public void setConfidence(int confidence) {
		this.confidence = confidence;
	}
	@Override
	public String toString() {
		return "Location [status=" + status + ", lng=" + lng + ", lat=" + lat + ", precise=" + precise
				+ ", confidence=" + confidence + "]";
	}
}
