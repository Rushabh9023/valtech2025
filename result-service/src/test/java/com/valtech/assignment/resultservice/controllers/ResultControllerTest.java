package com.valtech.assignment.resultservice.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.assignment.resultservice.vos.ResultVO;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ResultControllerTest {
	
	@LocalServerPort
	private Integer port ;
	
	@Autowired
	private TestRestTemplate restTemplate;

//	@Test
//	void testEvaluateResult() {
//		String url = "http://localhost:" + port + "/api/v1/results/evaluate/1";
//		ResultVO resultVo = restTemplate.getForObject(url, ResultVO.class);
//		System.out.println("Result Score:----"+resultVo.score());
//
//	}
	
	
//	@Test
//	void testEvaluateResult2() {
//		String url = "http://localhost:" + port + "/api/v1/results/evaluate/4";
//		ResultVO resultVo = restTemplate.getForObject(url, ResultVO.class);
//		System.out.println("Result Score:----"+resultVo.score());
//
//	}

}
