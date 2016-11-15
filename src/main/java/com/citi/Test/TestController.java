package com.citi.Test;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	TestService service;
	
	@RequestMapping(value = "/getMaxSat")
	@ResponseBody
	public String getMaximumSatisFaction()
	{		
		ArrayList<FileDataBean> data=service.readFile();
		return "Maximum satisfaction is "+service.findMaxSatisfaction(data);		
	}
}
