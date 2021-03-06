package com.domino.t1.board.news;

import java.util.List;

import com.domino.t1.util.Pager;

public interface NewsDAO{

	public int setInsert(NewsDTO newsDTO) throws Exception;
	
	public int setUpdate(NewsDTO newsDTO) throws Exception;
	
	public int setDelete(NewsDTO newsDTO) throws Exception;
	
	public List<NewsDTO> getList(Pager pager) throws Exception;
	
	public NewsDTO getOne(NewsDTO newsDTO) throws Exception;
	
	public long getCount(Pager pager) throws Exception;
	
	
}
