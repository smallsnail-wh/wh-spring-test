package com.wh.demo.test;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhTestApplicationTests {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	private MockRestServiceServer mockRestServiceServer;

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		this.mockRestServiceServer = MockRestServiceServer.bindTo(restTemplate).build();
		
	}
	
	@Test
	public void testMockMvc() throws Exception {
		this.mockMvc.perform(get("/test/1")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name").value("wanghuan"));
	}
	
	@Test
	public void testClient() {
		this.mockRestServiceServer.expect(requestTo("/test/1")).andRespond(withSuccess());
		System.out.println("123");
	}

}
