package com.example.palindrome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PalindromeController.class)
public class PalindromeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void checkIsPalindrome() throws Exception {
		this.mockMvc.perform(get("/palindrome?phrase=amad a la dama")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("amad a la dama is palindrome? true")));
	}

}