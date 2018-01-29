package chtbt;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("/api")
public class JerseyInit extends ResourceConfig {
	public JerseyInit() {
        packages("chtbt");
        property(ServerProperties.PROVIDER_SCANNING_RECURSIVE, false);
    }
}

