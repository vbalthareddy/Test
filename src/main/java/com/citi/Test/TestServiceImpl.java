package com.citi.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{
	
	private int TIME;
	private int MENUITEMS;
	
	public ArrayList<FileDataBean> readFile() {
		
		ArrayList<FileDataBean> data=null;
		
		boolean readMenuItems=false;
		
		FileReader reader;
		try {
			
			reader = new FileReader("data.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			
	        String line;	               	
	        while ((line = bufferedReader.readLine()) != null) {
	        	
	        	String[] splitLine=line.split(" ");
	        	
	        	if(!readMenuItems)
	        	{
	        		readMenuItems=true;
	        		TIME=Integer.parseInt(splitLine[0]);
	        		MENUITEMS=Integer.parseInt(splitLine[1]);
	        	}
	        	else
	        	{
	        		if(data==null)
		        		data=new ArrayList<FileDataBean>();
	        		
	        		FileDataBean fileData=new FileDataBean();
	        		fileData.setSatisfaction(Integer.parseInt(splitLine[0]));
	        		fileData.setTime(Integer.parseInt(splitLine[1]));
	        		fileData.setSatisfactionPerSec((double)fileData.getSatisfaction()/(double)fileData.getTime());
	        		data.add(fileData);
	        	}
	        }
	       
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
		
		return data;
	}

	public int findMaxSatisfaction(ArrayList<FileDataBean> data) {
		
		int totalTime=0;
		int totalsatis=0;
		
		//sort list based on Satisfaction per Second
		Collections.sort(data, new Comparator<FileDataBean>(){
			public int compare(FileDataBean d1, FileDataBean d2) {
				return  (d1.getSatisfactionPerSec() < d2.getSatisfactionPerSec() ? 1 :
		               (d1.getSatisfactionPerSec() == d2.getSatisfactionPerSec() ? 0 : -1));
				}
		});
		
		for(FileDataBean item:data)
		{
			if(totalTime+item.getTime()<=TIME)
			{				
				totalsatis+=item.getSatisfaction();
				totalTime+=item.getTime();
			}
		}
		
		return totalsatis;
		
	}
	
}
