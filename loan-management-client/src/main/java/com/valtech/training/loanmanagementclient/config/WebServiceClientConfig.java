package com.valtech.training.loanmanagementclient.config;

import javax.xml.namespace.QName;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.valtech.training.loanmanagement.webservices.LoanServiceWS;

@Configuration
public class WebServiceClientConfig {
	
	@Bean
	public LoanServiceWS applyLoan() {
		JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
		proxy.setServiceClass(LoanServiceWS.class);
		proxy.setServiceName(new QName("http://webservices.loanmanagement.training.valtech.com/"
				,"LoanService"));
		proxy.setAddress("http://localhost:8080/services/loanService");
		return proxy.create(LoanServiceWS.class);
	}



//@Bean
//public LoanServiceWS applyLoan() {
//    try {
//        JaxWsProxyFactoryBean proxy = new JaxWsProxyFactoryBean();
//        proxy.setServiceClass(LoanServiceWS.class);
//        proxy.setServiceName(new QName("http://webservices.loanmanagement.training.valtech.com/", "LoanService"));
//        proxy.setAddress("http://localhost:8080/loanService");
//
//        return (LoanServiceWS) proxy.create();
//    } catch (Exception e) {
//        e.printStackTrace();  // Log the full stack trace
//        throw new RuntimeException("Error creating LoanServiceWS proxy", e);
//    }
//}
}