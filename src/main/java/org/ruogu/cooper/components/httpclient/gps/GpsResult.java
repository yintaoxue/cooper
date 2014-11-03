package org.ruogu.cooper.components.httpclient.gps;

/**
 * GpsResult
 *
 * @author xueyintao 2014年11月2日 下午8:18:34
 */
public class GpsResult {
	private int status;
	private Result result;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "GpsResult [status=" + status + ", result=" + result + "]";
	}
	
}

class Result {
	private Location location;
	private int precise;
	private int confidence;
	private String level;
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Result [location=" + location + ", precise=" + precise + ", confidence=" + confidence + ", level="
				+ level + "]";
	}
	
}

class Location {
	private String lng;
	private String lat;
	
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	@Override
	public String toString() {
		return "Location [lng=" + lng + ", lat=" + lat + "]";
	}
	
}
