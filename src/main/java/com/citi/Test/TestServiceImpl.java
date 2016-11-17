package com.citi.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
		
		
		//sort list based on Satisfaction per Second
		Collections.sort(data, new Comparator<FileDataBean>(){
			public int compare(FileDataBean d1, FileDataBean d2) {
				return  (d1.getTime() < d2.getTime() ? -1 :
		               (d1.getTime() == d2.getTime() ? 0 : 1));
				}
		});
		
		
		System.out.println(data);
		int itemTime[][]=new int[MENUITEMS+1][TIME+1];

		
		for(int t=0;t<TIME+1;t++)
			itemTime[0][t]=0;
		
		for(int i=0;i<MENUITEMS+1;i++)
			itemTime[i][0]=0;
		
		
		
		for(int i=1;i<MENUITEMS+1;i++)
		{
			for(int t=1;t<TIME+1;t++)
			{
				if(data.get(i-1).getTime()<=t)
				{
					if((data.get(i-1).getSatisfaction()+itemTime[i-1][t-data.get(i-1).getTime()]) > itemTime[i-1][t])
						itemTime[i][t]=data.get(i-1).getSatisfaction()+itemTime[i-1][t-data.get(i-1).getTime()];
					else
						itemTime[i][t]=itemTime[i-1][t];
				}
				else
					itemTime[i][t]=itemTime[i-1][t];
			}
		}
		
		return itemTime[MENUITEMS][TIME];
		
	}
	
}
