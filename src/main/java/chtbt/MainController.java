package chtbt;

import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.JsonNode;

@Path("/assistant")
public class MainController {

	@Path("/sutechan")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SutechanService sutechan(JsonNode param) {
//    public void sutechan(JsonNode param) {

//		param.keySet().forEach(k ->{
//			System.out.println(k);
//		});

//		param.fieldNames().forEachRemaining(p->{
//			System.out.println(p);
//		});

		SutechanService ss = new SutechanService(param);
		ss.greeting();

//		Params pm = new Params();
//		pm.message = ss.params.message;
//		pm.status = ss.params.status;
//		pm.talkend = ss.params.talkend;
//		Response res = new Response();
//		res.bot_id = ss.bot_id;
//		res.error_code = ss.error_code;
//		res.params = pm;
//		res.status = ss.status;
//		res.user_id = ss.user_id;

//		Map<String, String> a = new HashMap<String, String>();
//		a.put("a", "a");
//
//		List<String> b = Arrays.asList("a", "b");
//		String c = "abc";

		return ss;
    }



	@Path("/sample")
	@GET
    @Produces(MediaType.TEXT_HTML)
    public String sample() {
        return "<b>Hello, World!</b>" + new Random().nextLong();
    }


	static public class Response{
	public String error_code;
	public String status;
	public String bot_id;
	public String user_id;
	public Params params;

};

static public class Params{
	public String status;
	public String talkend;
	public String message;

};



}
