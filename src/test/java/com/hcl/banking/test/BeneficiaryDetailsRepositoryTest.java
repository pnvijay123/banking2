/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hcl.banking.test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.hcl.banking.repository.BeneficiaryDetailsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BeneficiaryDetailsRepositoryTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private BeneficiaryDetailsRepository beneficiaryDetailsRepository;

	@Before(value = "")
	public void deleteAllBeforeTests() throws Exception {
		beneficiaryDetailsRepository.deleteAll();
	}

	@Test
	public void shouldReturnRepositoryIndex() throws Exception {

		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
				jsonPath("$._links.banking").exists());
	}

	@Test
	public void shouldCreateEntity() throws Exception {

		mockMvc.perform(post("/banking").content(
				"{\n" + 
				"	\"accountNumber\":12345,\n" + 
				"	\"beneficiaryAccountNumber\":101010,\n" + 
				"	\"beneficiaryName\":\"Manoj Kumar\",\n" + 
				"	\"beneficiaryNickName\":\"Manoj\",\n" + 
				"	\"ifsccode\":\"ICICI1234\",\n" + 
				"	\"addPayeeStatus\":\"New\"\n" + 
				"}")).andExpect(
						status().isCreated()).andExpect(
								header().string("Location", containsString("banking/")));
	}
	
	@Test
	public void shouldRetrieveEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/banking").content(
				"{\n" + 
				"	\"accountNumber\":12345,\n" + 
				"	\"beneficiaryAccountNumber\":21112,\n" + 
				"	\"beneficiaryName\":\"Suraj Kumar\",\n" + 
				"	\"beneficiaryNickName\":\"Surya\",\n" + 
				"	\"ifsccode\":\"SBI1234\",\n" + 
				"	\"addPayeeStatus\":\"New\"\n" + 
				"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.accountNumber").value("12345")).andExpect(
						jsonPath("$.beneficiaryAccountNumber").value("21112")).andExpect(
								jsonPath("$.beneficiaryName").value("Suraj Kumar")).andExpect(
										jsonPath("$.beneficiaryNickName").value("Surya")).andExpect(
												jsonPath("$.ifsccode").value("SBI1234")).andExpect(
																jsonPath("$.addPayeeStatus").value("New"));
	}


	

	
}