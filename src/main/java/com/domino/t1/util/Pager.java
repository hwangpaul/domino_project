package com.domino.t1.util;

import com.domino.t1.address.AddressDTO;

public class Pager extends AddressDTO{
	
	//********검색
	private String kind;
	private String search;
	
	private Integer curPage; //null받을수 있는 integer로 선언
	
	private int startRow;
	private int lastRow;
	
	private int perPage; //한페이지당 글 몇개씩 보여주는지 정하는 수
	
	//JSP에서 사용할 변수 
	private long startNum;
	private long lastNum;
	private boolean beforeCheck;
	private boolean nextCheck;
	
	
	private long totalCount;
	
	public Pager() {
		this.perPage=10;
	}
	
	//**********startRow, lastRow 계산 하는 메서드******
	public void makeRow() {
		
		//********rownum 계산***********
		
		//startRow
		startRow = (this.getCurPage()-1)*this.getPerPage();
		
		//lastRow
		lastRow = this.getCurPage()*this.getPerPage();
		
		//*****************************
	}
	
	//***********페이징 계산**************	
	public void makePage() {

		//2. 전체 페이지의 갯수 
		long totalPage = this.getTotalCount()/10; //146
		if(this.getTotalCount()%10 !=0) {
			totalPage++;
		}
		
		//3. 전체 블럭의 갯수 구하기 
		long totalBlock = totalPage/5;
		if(totalPage%5 !=0) {
			totalBlock++;
				}
		
		//4. curPage를 이용해서 현재 블럭 번호를 찾기 
		long curBlock = this.getCurPage()/5;
		if(this.getCurPage()%5 !=0) {
			curBlock++;
		}
		
		//5. 현재블럭번호로 시작번호 끝번호 게산 
		this.startNum = (curBlock-1)*5+1; 
		this.lastNum = curBlock*5;
		
		//6. 현재블럭번호와 전체블럭번호가 같은지 결정 
		this.nextCheck=true;
		if(curBlock == totalBlock) {
			nextCheck = !nextCheck;
			//현재블럭이 마지막 블럭이라면 lastNum 수정
			lastNum = totalPage;
		}
		
		this.beforeCheck = true;
		if(curBlock == 1) {
			beforeCheck =! beforeCheck;
		}	
	}
	
	//*******setter, getter
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(search==null) {
			search="";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public long getStartNum() {
		return startNum;
	}
	
	public void setStartNum(long startNum) {
		this.startNum = startNum;
	}

	public long getLastNum() {
		return lastNum;
	}

	public void setLastNum(long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isBeforeCheck() {
		return beforeCheck;
	}

	public void setBeforeCheck(boolean beforeCheck) {
		this.beforeCheck = beforeCheck;
	}

	public boolean isNextCheck() {
		return nextCheck;
	}

	public void setNextCheck(boolean nextCheck) {
		this.nextCheck = nextCheck;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getCurPage() {
		if(curPage==null){
			curPage=1;
		}
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		if(curPage == null) {
			curPage=1;
		}
		this.curPage = curPage;
	}

	public long getTotalCount() {
		if(this.totalCount==0) {
			this.totalCount=1;
		}
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}

}
