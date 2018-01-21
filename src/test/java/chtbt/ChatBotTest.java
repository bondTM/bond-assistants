package chtbt;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

public class ChatBotTest extends JerseyTest {

	@Override
	protected Application configure() {
	    return new ResourceConfig(MainController.class);
	}

	@Test
	public void testHelloWorld() throws Exception {

		String json =
				"{"
				+ "\"bot_id\":\"aaaaa\","
				+ "\"user_id\":\"bbbbb\","
				+ "\"lang\":\"ja-JP\","
				+ "\"args\":{"
					+ "\"utterance\": \"こんにちは\","
					+ "\"intent\":\"greeting\""
					+ "}"
				+ "}";

		Entity<String> userEntity = Entity.entity(json, MediaType.APPLICATION_JSON_TYPE);

	    Response response =
	            //リクエストするパスを指定する。
	            //ベースとなるURLはJerseyTestによって設定済みなので
	            //ここではリソースクラスの@Pathに書かれたパスから指定する。
	            target("assistant/sutechan")
	            //クエリパラメータを設定する。
	            //URLの後ろにくっつく ?name=world の部分。
//	           .queryParam("name", "world")
	            //ここまで組み立てたリソースに対してリクエストを行うよ！っていう印的な
	           .request()
	           .post(userEntity);
	            //GETリクエストをして、レスポンスをStringで受け取る。
//	           .get(String.class);

//	    assertEquals(Response.ok(), response.getStatus());
	    System.out.println(response.getStatus());
	}



}
