package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import daos.GohololiDatastore;
import daos.SutechanDatastore;

public class GohoLoliService extends CommonService {

	private Map<String, String> rtn = new HashMap<String, String>();

	public Map<String, String> start(Map<String, String> slot){

		try {
			InputStream inputStream = getClass().getResourceAsStream("/gohololiString.properties");
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

		case "shijuhatte":
			shijuhatte(slot);
			break;
		case "sex":
			sex(slot);
			break;
		case "lines":
			lines(slot);
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

	private void lines(Map<String, String> slot){
		SutechanDatastore sd = new SutechanDatastore();

		rtn.put("status", "true");
		rtn.put("talkend", "false");
		rtn.put("message", sd.listTasks());
//		s.addTask("あいうえお");
	}

}
