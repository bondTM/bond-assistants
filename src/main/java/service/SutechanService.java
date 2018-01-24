package service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SutechanService {

	private Map<String, String> rtn = new HashMap<String, String>();


	public Map<String, String> start(Map<String, String> slot){

		switch(slot.get("intent")){

		case "greeting":
			greeting();
			break;
		case "sex":
			sex(slot);
			break;
		case "weather":
			weather();
			break;
		case "goodbye":
			goodbye();
			break;
		case "time":
			time(slot);
			break;
		default :
			break;
		}

		return rtn;
	}


	private void greeting(){

		Random rnd = new Random();
		LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));

		rtn.put("status", "true");
		rtn.put("talkend", "false");

		//乱数と現在時刻が一致したら「うんち」
		int ran = rnd.nextInt(24);
		if(ldt.getHour() == ran){
			rtn.put("message", "うんち");
			return;
		}
		//朝
		if(6 <= ldt.getHour() && ldt.getHour() <= 10){
			rtn.put("message", "おはようございます。いい一日になりますように");
		}
		//昼
		else if(11 <= ldt.getHour() && ldt.getHour() <= 14){
			rtn.put("message", "こんにちは。ご飯を食べると眠たくなっちゃいます");
		}
		//夕方
		else if(15 <= ldt.getHour() && ldt.getHour() <= 17){
			rtn.put("message", "こんにちは。おやつの食べすぎには注意です");
		}
		//夜
		else if(18 <= ldt.getHour() && ldt.getHour() <= 22){
			rtn.put("message", "こんばんは。今日も一日お疲れ様でした");
		}
		//深夜
		else if(23 <= ldt.getHour() || ldt.getHour() <= 5){
			rtn.put("message", "こんばんは。早く寝ないと、お、お、おばけが出ますよ");
		}
	}


	private void sex(Map<String, String> slot){

		rtn.put("status", "true");
		rtn.put("talkend", "false");

		List<String> list = new ArrayList<String>();
		list.add("最高です。あへあへ");
		list.add("少し、、、興味があります");
		list.add("フケツです！");
		list.add("死ね");
		Collections.shuffle(list);

		rtn.put("message", slot.get("location") + "とか、" + list.get(0));
	}


	private void weather(){

		rtn.put("status", "true");
		rtn.put("talkend", "false");
		rtn.put("message", "明日の天気は晴れときどき曇り、ところにより雨か雪でしょう。");
	}


	private void goodbye(){

		rtn.put("status", "true");
		rtn.put("talkend", "true");
		rtn.put("message", "鋼のメンタルアシスタント、すてちゃんでした。またね。");
	}

	private void time(Map<String, String> slot){

		rtn.put("status", "true");
		rtn.put("talkend", "false");

		if(slot.get("utterance").equals("今何時")){
			rtn.put("message", "そおね、だいたいねええ");
			return;
		}

		LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
		rtn.put("message", "ただいまの時刻は"+ ldt.getHour() + "時" +
							ldt.getMinute() + "分" +
							ldt.getSecond() + "秒" +
							ldt.getNano() + "です");
	}

}
