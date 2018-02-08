package service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

public class CommonService {

	protected Map<String, String> rtn = new HashMap<String, String>();
	protected Properties botStr = new Properties();


	protected Map<String, String> commonStart(Map<String, String> slot){

		switch(slot.get("intent")){

		case "greeting":
			greeting(slot);
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
		case "greetingTest":
			greetingTest(slot);
			break;
		default :
			break;
		}

		return rtn;
	}

	private void greeting(Map<String, String> slot){

		Random rnd = new Random();
		int ldt = LocalDateTime.now(ZoneId.of("Asia/Tokyo")).getHour();

		if(slot.containsKey("period")){
			if(slot.get("period").equals("朝")){
				ldt = 7;
			}
			else if(slot.get("period").equals("昼")){
				ldt = 12;
			}
			else if(slot.get("period").equals("夕方")){
				ldt = 16;
			}
			else if(slot.get("period").equals("夜")){
				ldt = 19;
			}
			else if(slot.get("period").equals("深夜")){
				ldt = 23;
			}
		}

		rtn.put("status", "true");
		rtn.put("talkend", "false");

		//乱数と現在時刻が一致したらレアセリフ
		int ran = rnd.nextInt(24);
		if(ldt == ran){
			rtn.put("message", botStr.getProperty("random"));
			return;
		}
		//朝
		if(6 <= ldt && ldt <= 10){
			rtn.put("message", botStr.getProperty("morning"));
		}
		//昼
		else if(11 <= ldt && ldt <= 14){
			rtn.put("message", botStr.getProperty("noon"));
		}
		//夕方
		else if(15 <= ldt && ldt <= 17){
			rtn.put("message", botStr.getProperty("afternoon"));
		}
		//夜
		else if(18 <= ldt && ldt <= 22){
			rtn.put("message", botStr.getProperty("night"));
		}
		//深夜
		else if(23 <= ldt || ldt <= 5){
			rtn.put("message", botStr.getProperty("midnight"));
		}
	}


	private void weather(){

		rtn.put("status", "true");
		rtn.put("talkend", "false");
		rtn.put("message", botStr.getProperty("weather"));
	}


	private void goodbye(){

		rtn.put("status", "true");
		rtn.put("talkend", "true");
		rtn.put("message", botStr.getProperty("goodbye"));
	}

	private void time(Map<String, String> slot){

		rtn.put("status", "true");
		rtn.put("talkend", "false");

		if(slot.get("utterance").equals("今何時")){
			rtn.put("message", "そおねだいたいねー");
			return;
		}

		LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
		rtn.put("message", "ただいまの時刻は"+ ldt.getHour() + "時" +
							ldt.getMinute() + "分" +
							ldt.getSecond() + "秒" +
							String.valueOf(ldt.getNano()) + "です");
	}


	private void greetingTest(Map<String, String> slot) {
		slot.put("intent", "greeting");
		commonStart(slot);
	}



}
