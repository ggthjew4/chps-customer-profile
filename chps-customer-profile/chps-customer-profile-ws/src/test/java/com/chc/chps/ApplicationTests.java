package com.chc.chps;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.chc.chps.application.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
public class ApplicationTests {
	
	@Value("${local.server.port}")
	private int port;

	
	@Test
	public void tokenKeyEndpointProtected() {
		assertEquals(HttpStatus.UNAUTHORIZED,
				new TestRestTemplate().getForEntity("http://localhost:" + port + "/admin/token_key", String.class).getStatusCode());
	}

	@Test
	public void tokenKeyEndpointWithSecret() {
		assertEquals(HttpStatus.OK,
				new TestRestTemplate("user", "password").getForEntity(
						"http://localhost:" + port + "/oauth/authorize?response_type=token&client_id=my-trusted-client&scope=read", String.class).getStatusCode());
	}



}
