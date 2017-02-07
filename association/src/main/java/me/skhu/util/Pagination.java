package me.skhu.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Pagination {
	int currentPage = 1;
	int pageSize = 15;
	int srchType;
	String srchText = "";
	int recordCount;

	public int getCp(){
		return this.currentPage;
	}

	public void setCp(int currentPage){
		this.currentPage=currentPage;
	}

	public int getPs(){
		return this.pageSize;
	}

	public void setPs(int pageSize){
		this.pageSize=pageSize;
	}

	public int getSt(){
		return this.srchType;
	}

	public void setSt(int srchType){
		this.srchType=srchType;
	}

	public String getSs(){
		return this.srchText;
	}

	public void setSs(String srchText){
		this.srchText=srchText;
	}

	public int getRc(){
		return this.recordCount;
	}

	public void setRc(int recordCount){
		this.recordCount=recordCount;
	}

	public String getQueryString() throws UnsupportedEncodingException{
		String temp = (srchText == null) ? "" : URLEncoder.encode(srchText, "UTF-8");
		return String.format("cp=%d&ps=%d&st=%d&ss=%s",currentPage,pageSize,srchType,temp);
	}

	public List<PageIndex> getPageIndexList(){
		ArrayList<PageIndex> list = new ArrayList<PageIndex>();
		int pageCount = ( recordCount + pageSize - 1 ) / pageSize;
		int basePage = (( currentPage - 1 ) /10 ) * 10;
		if(basePage > 0 )
			list.add(new PageIndex("Prev",basePage));
		for(int i = 1; i<=10 && basePage + i <= pageCount; ++i )
			list.add(new PageIndex(basePage + i, currentPage == basePage + i));
		if(basePage + 11 <= pageCount)
			list.add(new PageIndex("Next", basePage + 11));
		return list;
	}

	@Data
	public class PageIndex{
		String label;
		int number;
		String cssClass;

		public PageIndex(int number, boolean active){
			this.label = "" + number;
			this.number = number;
			this.cssClass = active ?  "active" : "";
		}

		public PageIndex(String label, int number){
			this.label = label;
			this.number = number;
			this.cssClass = "";
		}
	}
}