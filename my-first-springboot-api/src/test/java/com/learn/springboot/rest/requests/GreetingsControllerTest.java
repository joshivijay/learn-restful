package com.learn.springboot.rest.requests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GreetingsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	/**
	 *
	 * @throws Exception
	 *
	 *                   It tests response to be "Hello Java!"
	 */
	@Test
	public void greetJava() throws Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users/greet/Java"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();

		Assert.assertEquals(response, "Hello Java!");
	}

	/**
	 *
	 * @throws Exception
	 *
	 *                   It tests response to be "Hello Spring!"
	 */
	@Test
	public void greetSpring() throws Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users/greet/Spring"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();

		Assert.assertEquals(response, "Hello Spring!");
	}

	/**
	 *
	 * @throws Exception
	 *
	 *                   It tests response to be "Hello RodJohnson!"
	 */
	@Test
	public void greetRodJohnson() throws Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users/greet/RodJohnson"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();

		Assert.assertEquals(response, "Hello RodJohnson!");
	}

	@Test
	public void greetWorld() throws Exception {
		String response = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users/greet"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();

		Assert.assertEquals(response, "Hello world!");
	}
}
