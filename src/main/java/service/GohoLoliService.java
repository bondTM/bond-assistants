package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import daos.GohololiDatastore;

public class GohoLoliService {

	private Map<String, String> rtn = new HashMap<String, String>();


	public Map<String, String> start(Map<String, String> slot){

		switch(slot.get("intent")){

		case "shijuhatte":
			shijuhatte(slot);
			break;
		case "goodbye":
			goodbye();
			break;
		case "sex":
			sex(slot);
			break;
		default :
			break;
		}

		return rtn;
	}


	private void shijuhatte(Map<String, String> slot){
		GohololiDatastore gd = new GohololiDatastore();
		rtn.put("status", "true");
		rtn.put("talkend", "false");
		rtn.put("message", gd.getShijuhatte(slot.get("shijuhatte")));

	}


	private void goodbye(){

		rtn.put("status", "true");
		rtn.put("talkend", "true");
		rtn.put("message", "楽しかったわ。またいっしょに、しましょうね。");
	}

	private void sex(Map<String, String> slot){

		rtn.put("status", "true");
		rtn.put("talkend", "false");

		List<String> list = new ArrayList<String>();
		list.add("ああん、早く、早くして！あなたのそれ、ぶちこんで！");
		list.add("いいじゃない、行きましょうよ");
		list.add("まぁ悪くはないのかしら");
		list.add("だからあなたは童貞なのよ！");
		Collections.shuffle(list);


		rtn.put("message", slot.get("location") + "だなんて、" + list.get(0));
	}

}
