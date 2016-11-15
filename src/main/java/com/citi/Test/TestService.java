package com.citi.Test;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public interface TestService {
	public ArrayList<FileDataBean> readFile(); 
	public int findMaxSatisfaction(ArrayList<FileDataBean> data);
}
