package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.service.User;
import com.example.demo.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerJUnitTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	public void performGetUserFromApi_ReturnJsonUser() throws Exception {
		User user  = new User(1,"Donald","Trump","Fox");
		when(userService.findById(1)).thenReturn(user);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/user/1").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expected = "{\"userId\":1,\"firstName\":\"Donald\",\"lastName\":\"Trump\",\"companyName\":\"Fox\"}";
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void performGetUserFromApi_ReturnJsonUser2() throws Exception {
		User user  = new User(1,"Donald","Duck","Fox");
		when(userService.findById(1)).thenReturn(user);
		
		this.mockMvc
		.perform(get("/api/user/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.lastName").value("Donald"));
	}
}
