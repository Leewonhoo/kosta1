package work.model.dto;

import java.io.Serializable;

public class AddressDto implements Serializable{
	private String post;
	private String si;
	private String gu;
	private String road;
	private String dong;
	private String subdong;
	private String roadNum;
	private String dongNum;
	private String build;
	
	public AddressDto() { }
	
	public AddressDto(String post, String si, String gu, String road, String dong, String subdong, String roadNum,
			String dongNum, String build) {
		super();
		this.post = post;
		this.si = si;
		this.gu = gu;
		this.road = road;
		this.dong = dong;
		this.subdong = subdong;
		this.roadNum = roadNum;
		this.dongNum = dongNum;
		this.build = build;
	}

	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getSi() {
		return si;
	}
	public void setSi(String si) {
		this.si = si;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getSubdong() {
		return subdong;
	}
	public void setSubdong(String subdong) {
		this.subdong = subdong;
	}
	public String getRoadNum() {
		return roadNum;
	}
	public void setRoadNum(String roadNum) {
		this.roadNum = roadNum;
	}
	public String getDongNum() {
		return dongNum;
	}
	public void setDongNum(String dongNum) {
		this.dongNum = dongNum;
	}
	public String getBuild() {
		return build;
	}
	public void setBuild(String build) {
		this.build = build;
	}
	
}
