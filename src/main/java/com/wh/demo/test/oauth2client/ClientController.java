package com.wh.demo.test.oauth2client;

import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/authorize")
public class ClientController {

	Logger log = LoggerFactory.getLogger(getClass());

	@GetMapping("/code")
	public String codeGet(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		String uri = "http://127.0.0.1:8080/ssy/oauth2/oauth/token";
		String username = "client";
		String password = "secret";

		RestTemplate template = new RestTemplate();

		/* 表头设置 */
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Content-Type", "application/x-www-form-urlencoded");
		String userPassword = username + ":" + password;
		String encoding = new String(Base64.encodeBase64(userPassword.getBytes()), Charset.forName("us-ascii"));
		requestHeaders.set("Authorization", "Basic " + encoding);

		/* 请求数据设置 */
		LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("grant_type", "authorization_code");
		map.add("code", code);
		/*map.add("redirect_uri", "http://127.0.0.1:8090/wh/authorize/code");*/
		map.add("redirect_uri", "http://127.0.0.1:8091/authorization");

		HttpEntity<LinkedMultiValueMap> requestEntity = new HttpEntity<LinkedMultiValueMap>(map, requestHeaders);

		ResponseEntity<String> res = template.postForEntity(uri, requestEntity, String.class);
		String reslut = res.getBody();
		return reslut;
	}

}
