package com.lwu;

import java.util.Random;

public class RnadomCode {

	public String getRandomCode(int len)
	{
		String chr="0123456789";
		
		StringBuilder code = new StringBuilder();
		
		Random rndom= new Random();
		String str="";
		
		for(int i=0;i<len;i++)
		{
			int rndidx=rndom.nextInt(chr.length());
			
			char rndchar=chr.charAt(rndidx);
			
			str=str+rndchar;
		}
		
	
		return str;
				
		
		
	}
	
}
