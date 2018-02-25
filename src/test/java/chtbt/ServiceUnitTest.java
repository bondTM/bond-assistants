package chtbt;

import java.util.HashMap;
import java.util.Map;

import service.SutechanService;

public class ServiceUnitTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Map<String, String> testArgs = new HashMap<String, String>();
		testArgs.put("utterance", "test");//発話内容
		testArgs.put("intent", "");//インテント

		Map<String, String> returnMap = new HashMap<String, String>();
		SutechanService ss = new SutechanService();
		returnMap = ss.start(testArgs);

		System.out.println(returnMap.get("status"));
		System.out.println(returnMap.get("talkend"));
		System.out.println(returnMap.get("message"));
	}

}
