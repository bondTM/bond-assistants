package chtbt;

import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import model.ParamsModel;
import model.ResponseBodyModel;

public class SutechanService extends ResponseBodyModel {

	private Iterator<Map.Entry<String, JsonNode>> slot;

	public SutechanService(JsonNode rbm){

		//各パラメータをJSONで受け取った値で初期化
//		super.setBot_id(rbm.get("bot_id").toString());
//		super.setError_code("success");
//		super.setStatus("true");
//		super.setUser_id(rbm.get("user_id").toString());
		super.bot_id = rbm.get("bot_id").toString();
		super.error_code = "success";
		super.status = "true";
		super.user_id = rbm.get("user_id").toString();

		//argsの中身をMapに格納
		slot = rbm.get("args").fields();

		super.params = new ParamsModel();
	}

	public void greeting(){

		super.params.status = "true";
		super.params.talkend = "true";
		super.params.message = "うんち";
//		super.getParams().put("status", "true");
//		super.getParams().put("talkend", "true");
//		super.getParams().put("message", "うんち");

	}





}
