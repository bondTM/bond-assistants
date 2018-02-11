package chtbt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.JsonNode;

import daos.SutechanDatastore;
import model.SebastienResponseModel;
import service.GohoLoliService;
import service.SebastienService;
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

	@Path("/shota")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SebastienResponseModel shota(JsonNode param) {

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
		srm.getParams().setStatus("true");
		srm.getParams().setTalkend("true");
		srm.getParams().setMessage("またな");

		return srm;
    }

	@Path("/gohololi")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SebastienResponseModel gohololi(JsonNode param) {

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
		GohoLoliService gs = new GohoLoliService();
		srm.setParams(ioc.SebastienSetParams(gs.start(args)));

		return srm;
    }


	@Path("/sebastien")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SebastienResponseModel sebastien(JsonNode param) {

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
		SebastienService ss = new SebastienService();
		srm.setParams(ioc.SebastienSetParams(ss.start(args)));

		return srm;
    }

	@Path("/resist")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
	public String linesInsert(@FormParam("lines")String lines){
		SutechanDatastore s = new SutechanDatastore();
		s.addTask(lines);

		return "<b>OK!!!!</b>"; // The ID of the Key
	}



	@Path("/sample")
	@GET
    @Produces(MediaType.TEXT_HTML)
    public String sample() {
        return "<b>Hello, World!</b>" + new Random().nextLong();
    }




}
