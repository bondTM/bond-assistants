package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import daos.SutechanDatastore;

public class SutechanService extends CommonService {

	private Map<String, String> rtn = new HashMap<String, String>();

	public Map<String, String> start(Map<String, String> slot){

		try {
			InputStream inputStream = getClass().getResourceAsStream("/sutechanString.properties");
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

		case "lines":
			lines(slot);
			break;
		case "fuckYou":
			fuckYou();
			break;
		case "harassment":
			harassment();
		case "kyasuodai":
			kyasuodai();
		default :
			break;
		}

		return rtn;
	}





	private void lines(Map<String, String> slot){
		SutechanDatastore sd = new SutechanDatastore();

		rtn.put("status", "true");
		rtn.put("talkend", "false");
		rtn.put("message", sd.listTasks());
//		s.addTask("あいうえお");
	}


	private void fuckYou(){
		rtn.put("status", "true");
		rtn.put("talkend", "false");
		rtn.put("message", "ふぁっきゅー！ふぁっきゅふぁっきゅーーー！");
	}

	private void harassment(){
		rtn.put("status", "true");
		rtn.put("talkend", "false");
		

		List<String> list = new ArrayList<String>();
		list.add("え、えっちぃのは嫌いです。");
		list.add("ば、バカじゃないですか？");
		list.add("そ、そういうこと言うの、よ、よくないと思います。");
		list.add("うう、もう。");
		list.add("ばかぁ！！！");

		Collections.shuffle(list);

		rtn.put("message", list.get(0));
	}
	
	
	private void kyasuodai(){
		rtn.put("status", "true");
		rtn.put("talkend", "false");
		
		//%dについて話してください。(テンプレ)
		//今日したこと
		//if日曜　　架空
		//if土曜　　物語
		//おたよりよもう
		//私の一人称ってなくない？
		//そろそろ喉が寂しいんじゃない？
		//かんぱいにとぶ
		//if23:20そろそろいつも終わってる時間だよ

		List<String> list = new ArrayList<String>();
		list.add("え、えっちぃのは嫌いです。");
		list.add("ば、バカじゃないですか？");
		list.add("そ、そういうこと言うの、よ、よくないと思います。");
		list.add("うう、もう。");
		list.add("ばかぁ！！！");

		Collections.shuffle(list);

		rtn.put("message", list.get(0));
	}

}
