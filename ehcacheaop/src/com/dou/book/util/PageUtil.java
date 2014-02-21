package com.dou.book.util;

public class PageUtil {
public int getStartRow(int totalRow,int rowCount){
	getTotalPage(totalRow,rowCount);
	return 0;
	
}
	public int getTotalPage(int totalRow,int rowCount){
		if(rowCount>totalRow){
			rowCount=totalRow;
		}
		if(totalRow%rowCount==0){
			return totalRow/rowCount;
		}else{
			return totalRow/rowCount+1;
		}
		
	}
}
