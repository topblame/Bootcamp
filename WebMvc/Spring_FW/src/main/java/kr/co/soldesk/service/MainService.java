package kr.co.soldesk.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.soldesk.beans.ContentBean;
import kr.co.soldesk.dao.BoardDAO;

@Service
public class MainService {
	@Autowired
	private BoardDAO boardDao;
	
	public List<ContentBean> getMainList(int board_info_idx){
		RowBounds rowBounds = new RowBounds(0, 5);
		//해당 게시글에서 5개씩읽어옴
		return boardDao.getContentList(board_info_idx, rowBounds);
	}
}
