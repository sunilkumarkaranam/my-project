package com.thanh.connect.springboot.controller;

import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.atlassian.connect.spring.IgnoreJwt;
import com.bosch.callapi.model.StoryPoint;

@RestController
public class HelloWorldController {
	// @Autowired private AtlassianHostRestClients atlassianHostRestClients;

	@SuppressWarnings("null")
	@IgnoreJwt

	@GetMapping("callapi")
	public ModelAndView getAllStoryPoint() {
		ModelAndView modelAndView = new ModelAndView("listissues");

		RestTemplate restTemplate = null;
		try {
			restTemplate = this.createRestTemplate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		String url = "https://woven-handbook-352309.el.r.appspot.com/all".trim();
		// StoryPoint[] dataResponse = restTemplate.getForObject(url,
		// StoryPoint[].class);
		List<StoryPoint> list = restTemplate.getForObject(url, List.class);
		System.out.println(list);
		modelAndView.addObject("list", list);
		return modelAndView;
	}

	@GetMapping("insert")
	public String insert() {
		RestTemplate restTemplate = null;
		try {
			restTemplate = this.createRestTemplate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		StoryPoint storyPoint = new StoryPoint("Key-123456", 123456);
		String url = "https://woven-handbook-352309.el.r.appspot.com/insert";
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, storyPoint, String.class); //
		responseEntity.getBody(); // is get success list story point // GOOGLE CLOUD
		return responseEntity.getBody();
	}

	private RestTemplate createRestTemplate() throws Exception {
		final String username = "uql1kor";
		final String password = "Sunimouni@1997";
		final String proxyUrl = "rb-proxy-unix-apac.bosch.com";
		final int port = 8080;

		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(new AuthScope(proxyUrl, port),
				new UsernamePasswordCredentials(username, password));

		HttpHost myProxy = new HttpHost(proxyUrl, port);
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();

		clientBuilder.setProxy(myProxy).setDefaultCredentialsProvider(credsProvider).disableCookieManagement();

		HttpClient httpClient = clientBuilder.build();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setHttpClient(httpClient);

		return new RestTemplate(factory);
	}

}
