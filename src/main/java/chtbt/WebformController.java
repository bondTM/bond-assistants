package chtbt;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.server.mvc.Viewable;

@Path("/form")
public class WebformController {

	@GET
    @Path("/scripts")
    public Viewable getJsp() {

		List<String> test = new ArrayList<String>();
		test.add("a");
		test.add("b");
		test.add("c");
		test.add("d");

        return new Viewable("bot-form.jsp", test);
    }


}

