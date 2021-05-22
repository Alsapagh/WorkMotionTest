package com.workmotion.poc.employee;

import java.net.URI;

import com.workmotion.poc.employee.entity.EmployeeEntity;
import com.workmotion.poc.employee.enums.States;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.net.URISyntaxException;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class EmployeeApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private MockMvc mockMvc;
    @LocalServerPort
    int randomServerPort;

    @Test
    public void testAddEmployeeSuccess() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/api/emp/";
        URI uri = new URI(baseUrl);
        EmployeeEntity employee = new EmployeeEntity(1, "Ayman", States.ADDED, new Date("11/05/1994"));

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<EmployeeEntity> request = new HttpEntity<>(employee, headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        //Verify request succeed
        Assert.isTrue(200 == result.getStatusCodeValue(), "Employee Inserted SuccessFully");
    }

    @Test
    public void testUpdate() throws Exception {

        mockMvc.perform(
                put("http://localhost:" + randomServerPort + "/api/emp/")
                        .param("EmployeeId", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());
//                .andExpect((ResultMatcher) content().string(containsString(States.INCHECK.getValue())));
    }


}
