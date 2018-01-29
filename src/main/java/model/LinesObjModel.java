package model;

import java.time.LocalDateTime;

public class LinesObjModel {

	public static final String NAME = "name";
	public static final String INTENT = "intent";
	public static final String LINES = "lines";
	public static final String CREATE_DATETIME = "createDatetiem";


	private String name;
	private String intent;
	private String lines;
	private LocalDateTime createDatetiem;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntent() {
		return intent;
	}
	public void setIntent(String intent) {
		this.intent = intent;
	}
	public String getLines() {
		return lines;
	}
	public void setLines(String lines) {
		this.lines = lines;
	}
	public LocalDateTime getCreateDatetiem() {
		return createDatetiem;
	}
	public void setCreateDatetiem(LocalDateTime createDatetiem) {
		this.createDatetiem = createDatetiem;
	}



}
