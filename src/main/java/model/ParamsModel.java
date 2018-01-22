package model;

import javax.xml.bind.annotation.XmlElement;

public class ParamsModel {

	@XmlElement
	private String status;
	@XmlElement
	private String talkend;
	@XmlElement
	private String message;


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTalkend() {
		return talkend;
	}
	public void setTalkend(String talkend) {
		this.talkend = talkend;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
