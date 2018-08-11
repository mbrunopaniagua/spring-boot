package com.example.palindrome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private Integer port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void palindromeShouldReturnIndexHtml() {
		assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/", String.class).contains("Palindrome Started"), is(true));
	}
}
