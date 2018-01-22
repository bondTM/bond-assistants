package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="root")
public class SebastienResponseModel {

	@XmlElement
	private String error_code;
	@XmlElement
	private String status;
	@XmlElement
	private String bot_id;
	@XmlElement
	private String user_id;
	@XmlElement
	private ParamsModel params;


	public void setParams(ParamsModel params) {
		this.params = params;
	}
	public ParamsModel getParams() {
		return params;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBot_id() {
		return bot_id;
	}
	public void setBot_id(String bot_id) {
		this.bot_id = bot_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}



}
