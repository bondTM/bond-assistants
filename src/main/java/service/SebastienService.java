package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SebastienService extends CommonService {

	private Map<String, String> rtn = new HashMap<String, String>();

	public Map<String, String> start(Map<String, String> slot){

		try {
			InputStream inputStream = getClass().getResourceAsStream("/sebastienString.properties");
			super.botStr.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//共通機能呼び出し
		super.commonStart(slot);
		if(super.rtn.containsKey("message")){
			return super.rtn;
		}


		switch(slot.get("intent")){

//		case "lines":
//			lines(slot);
//			break;
//		case "fuckYou":
//			fuckYou();
//			break;
//		case "harassment":
//			harassment();
		default :
			break;
		}

		return rtn;
	}


}
