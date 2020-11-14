package com.domino.t1.board.news.dominoNews;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.domino.t1.board.file.BoardFileDTO;
import com.domino.t1.board.news.NewsDTO;
import com.domino.t1.board.news.NewsService;
import com.domino.t1.util.FileSaver;
import com.domino.t1.util.Pager;

@Service
public class DominoNewsService implements NewsService {
	
	@Autowired
	private DominoNewsDAO dominoNewsDAO;
	
	@Autowired
	private FileSaver fileSaver;
	
	
	public String summernote(MultipartFile file, HttpSession session)throws Exception{
		//파일을 하드 디스크에 저장하고 저장된 파일명을 리턴
		String path = session.getServletContext().getRealPath("/resources/upload/dominoNews");
		System.out.println(path);
		File dest = new File(path);
		String fileName = fileSaver.saveCopy(dest, file);
		return fileName;
	}
	
	public boolean summernoteDelete(String file, HttpSession session)throws Exception{
		String path = session.getServletContext().getRealPath("/resources/upload/dominoNews");
		File file2 = new File(path, file);
		boolean result = false;
		if(file2.exists()) {
			result=file2.delete();
		}
		
		return result;
	}
	
	@Override
	public int setInsert(NewsDTO newsDTO, MultipartFile[] files, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
	
		int result = dominoNewsDAO.setInsert(newsDTO);
		
		String path = session.getServletContext().getRealPath("/resources/upload/dominoNews/");
		File file = new File(path);
	
		
		for(int i=0;i<files.length;i++) {
			if(i==0) {
				continue;
			}
			MultipartFile multipartFile = files[i];
			if( multipartFile.getSize() !=0) {
				String fileName = fileSaver.saveCopy(file, multipartFile);
				BoardFileDTO boardFileDTO = new BoardFileDTO();
				boardFileDTO.setFile_Name(fileName);
				boardFileDTO.setOri_Name(multipartFile.getOriginalFilename());
				boardFileDTO.setBoard_num(newsDTO.getBoard_num());
				dominoNewsDAO.setInsertFile(boardFileDTO);
			}
		}
		
		return result;
		
	}
	
	@Override
	public int setUpdate(NewsDTO newsDTO) throws Exception {
		// TODO Auto-generated method stub
		return dominoNewsDAO.setUpdate(newsDTO);
	}

	@Override
	public int setDelete(NewsDTO newsDTO) throws Exception {
		// TODO Auto-generated method stub
		return dominoNewsDAO.setDelete(newsDTO);
	}

	@Override
	public List<NewsDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		pager.setTotalCount(dominoNewsDAO.getCount(pager));
		pager.makePage();
		return dominoNewsDAO.getList(pager);
	}

	@Override
	public NewsDTO getOne(NewsDTO newsDTO) throws Exception {
		// TODO Auto-generated method stub
		return dominoNewsDAO.getOne(newsDTO);
	}

}
