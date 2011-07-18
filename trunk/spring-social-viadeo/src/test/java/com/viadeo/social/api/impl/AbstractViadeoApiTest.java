package com.viadeo.social.api.impl;

import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.test.client.MockRestServiceServer;

public class AbstractViadeoApiTest {
		protected static final String ACCESS_TOKEN = "ACCESS_TOKEN";

		protected ViadeoTemplate viadeo;
		protected MockRestServiceServer mockServer;
		protected HttpHeaders responseHeaders;

		@Before
		public void setup() {
			viadeo = new ViadeoTemplate(ACCESS_TOKEN);
			mockServer = MockRestServiceServer.createServer(viadeo.getRestTemplate());
			responseHeaders = new HttpHeaders();
			responseHeaders.setContentType(MediaType.APPLICATION_JSON);

		}

		protected Resource jsonResource(String filename) {
			return new ClassPathResource(filename + ".json", getClass());
		}
}
