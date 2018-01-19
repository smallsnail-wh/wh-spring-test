package com.wh.demo.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhTestApplicationTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void whenQuerySuccess() throws Exception {
		mockMvc.perform(get("/users/test")
				.param("name", "wanghuan")
				/*.param("size", "15")
				.param("page", "3")
				.param("sort", "id,desc")*/
				.contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.length()").value(3));
	}

	@Test
	public void whenGetInfoSuccess() throws Exception {
		String result = mockMvc.perform(get("/users/user/3")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk())
		.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}

	@Test
	public void whenGetInfoFail() throws Exception {
		String result = mockMvc.perform(get("/users/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}
	
	@Test
	public void whenCreateSuccess() throws Exception {
		Date date = new Date();
		System.out.println(date.getTime());
		String content = "{\"name\":null,\"password\":\"123123\",\"birthday\":\""+date.getTime()+"\"}";
		String result = mockMvc.perform(post("/users/user")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(content))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1))
				.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}
	
	@Test
	public void whenUploadSuccess() throws Exception {
		mockMvc.perform(fileUpload("/file")
				.file(new MockMultipartFile("file", "test.txt","mutipart/form-data","hello upload".getBytes())))
				.andExpect(status().isOk());
	}

}
