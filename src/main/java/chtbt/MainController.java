package chtbt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.JsonNode;

import model.SebastienResponseModel;
import service.SutechanService;
import util.IOConverter;

@Path("/assistant")
public class MainController {

	@Path("/sutechan")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SebastienResponseModel sutechan(JsonNode param) {

		Map<String, String> args = new HashMap<String, String>();
		SebastienResponseModel srm = new SebastienResponseModel();

		//入力値を出力用Modelへ
		IOConverter ioc = new IOConverter();
		srm = ioc.SebastienInit(param);

		//argsの中身をMapに格納
		Iterator<Map.Entry<String, JsonNode>> argsWk = param.get("args").fields();
		argsWk.forEachRemaining(arg ->{
				args.put(arg.getKey(), arg.getValue().asText());
		});

		//セリフ編集＆出力のparamsを編集
		SutechanService ss = new SutechanService();
		srm.setParams(ioc.SebastienSetParams(ss.start(args)));

		return srm;
    }



	@Path("/sample")
	@GET
    @Produces(MediaType.TEXT_HTML)
    public String sample() {
        return "<b>Hello, World!</b>" + new Random().nextLong();
    }




}
