package com.valtech.training.jaxws;

import javax.jws.WebService;

@WebService
public interface HelloWorld {

	String hello(String name);

}