package util;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import model.ParamsModel;
import model.SebastienResponseModel;

public class IOConverter {

	public SebastienResponseModel SebastienInit(JsonNode jn){

		SebastienResponseModel srm = new SebastienResponseModel();
		ParamsModel pm = new ParamsModel();
		//各パラメータをJSONで受け取った値で初期化
		srm.setBot_id(jn.get("bot_id").toString());
		srm.setError_code("success");
		srm.setStatus("true");
		srm.setUser_id(jn.get("user_id").toString());
		srm.setParams(pm);

		return srm;

	}

	public ParamsModel SebastienSetParams(Map<String, String> params){

		ParamsModel pm = new ParamsModel();

		pm.setStatus(params.get("status"));
		pm.setTalkend(params.get("talkend"));
		pm.setMessage(params.get("message"));

		return pm;




	}

}
