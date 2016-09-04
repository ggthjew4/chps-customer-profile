package com.chc.chps.config;

import org.glassfish.jersey.server.ResourceConfig;

import com.chc.chps.restful.Endpoint;

//@Configuration
//@AutoConfigureAfter(AuthorizationConfig.class)
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(Endpoint.class);
	}
}
