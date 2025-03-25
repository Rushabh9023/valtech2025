package com.valtech.training.loanmanagementclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.loanmanagement.vos.LoanVO;
import com.valtech.training.loanmanagement.webservices.LoanServiceWS;

@SpringBootTest
class LoanManagementClientApplicationTests {
	
	@Autowired
	private LoanServiceWS loanService;

	@Test
	void contextLoads() {
		loanService.applyLoan(new LoanVO( "home", "APPLY", 1000000, "gold", 670000, "Yashvi", 5656565, 580, "WIHS876", 1000000));
	}

}
