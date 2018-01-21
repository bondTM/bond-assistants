package util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;

import chtbt.SutechanService;

@Provider
//@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JsonConverter
//implements MessageBodyReader<JsonNode>

implements MessageBodyWriter<SutechanService> {

	private static ObjectMapper mapper = new ObjectMapper();



	/*
	 * Reader
	 */

//	@Override
//	public boolean isReadable(Class<?> type, Type genericType,
//			Annotation[] annotations, MediaType mediaType) {
//		return type == JsonNode.class;
//	}
//
//	@Override
//	public JsonNode readFrom(Class<JsonNode> type, Type genericType,
//			Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
//			InputStream entityStream) throws IOException, WebApplicationException {
//		// TODO 自動生成されたメソッド・スタブ
//		JsonNode map = mapper.readValue(entityStream, new TypeReference<JsonNode>(){});
//		return map;
//
//	}


	/*
	 * Writer
	 */



//	@Override
//	public long getSize(SutechanService t, Class<?> type, Type genericType,
//			Annotation[] annotations, MediaType mediaType) {
//		return -1;
//	}
//
//
//	@Override
//	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
//		// TODO 自動生成されたメソッド・スタブ
//		return type == SutechanService.class;
//	}
//
//
//
//	@Override
//	public void writeTo(SutechanService t, Class<?> type, Type genericType, Annotation[] annotations,
//			MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
//			throws IOException, WebApplicationException {
//		// TODO 自動生成されたメソッド・スタブ
//
////		ResponseBodyModel rtn = new ResponseBodyModel();
////		rtn.setBot_id(t.getBot_id());
////		rtn.setUser_id(t.getUser_id());
////		rtn.setError_code(t.getError_code());
////		rtn.setStatus(t.getStatus());
////		rtn.setParams(t.getParams());
////
////		List<String> c = Arrays.asList("a", "b", "c");
////		mapper.writeValueAsString(c);
////
////		Map<String, String> a = new HashMap<>();
////		a.put("a", "b");
////		mapper.writeValueAsString(a);
//
//		String json = createJson(t);
//		try(PrintWriter out = new PrintWriter(entityStream)){
//        	out.print(json);
//        } catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	private String createJson(ResponseBodyModel map) {
//		try {
//			Params pm = new Params();
//			pm.message = map.params.message;
//			pm.status = map.params.status;
//			pm.talkend = map.params.talkend;
//			Response res = new Response();
//			res.bot_id = map.bot_id;
//			res.error_code = map.error_code;
//			res.params = pm;
//			res.status = map.status;
//			res.user_id = map.user_id;
//
//			String json = mapper.writeValueAsString(res);
//			return json;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	static public class Response{
//		public String error_code;
//		public String status;
//		public String bot_id;
//		public String user_id;
//		public Params params;
//
//	};
//
//	static public class Params{
//		public String status;
//		public String talkend;
//		public String message;
//
//	}

	@Override
	public boolean isWriteable(Class<?> type, java.lang.reflect.Type genericType, Annotation[] annotations,
			MediaType mediaType) {
		// TODO 自動生成されたメソッド・スタブ
		return type == SutechanService.class;
	}


	@Override
	public long getSize(SutechanService t, Class<?> type, java.lang.reflect.Type genericType, Annotation[] annotations,
			MediaType mediaType) {
		// TODO 自動生成されたメソッド・スタブ
		return -1;
	}


	@Override
	public void writeTo(SutechanService t, Class<?> type, java.lang.reflect.Type genericType, Annotation[] annotations,
			MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		// TODO 自動生成されたメソッド・スタブ
//	ResponseBodyModel rtn = new ResponseBodyModel();
//	rtn.setBot_id(t.getBot_id());
//	rtn.setUser_id(t.getUser_id());
//	rtn.setError_code(t.getError_code());
//	rtn.setStatus(t.getStatus());
//	rtn.setParams(t.getParams());
//
//	List<String> c = Arrays.asList("a", "b", "c");
//	mapper.writeValueAsString(c);
//
//	Map<String, String> a = new HashMap<>();
//	a.put("a", "b");
		String json = mapper.writeValueAsString(t);
		try(PrintWriter out = new PrintWriter(entityStream)){
			out.print(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

