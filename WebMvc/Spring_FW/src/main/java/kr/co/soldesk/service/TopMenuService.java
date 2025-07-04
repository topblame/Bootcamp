package kr.co.soldesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.soldesk.beans.BoardInfoBean;
import kr.co.soldesk.dao.TopMenuDAO;

@Service
public class TopMenuService {
	
	@Autowired //DI Defendency Injection => topMenuDao = new TopMenuDAO();
	private TopMenuDAO topMenuDao;
	
	
	public List<BoardInfoBean> getTopMenuList(){
		List<BoardInfoBean> topMenuList = topMenuDao.getTopMenuList();
		
		return topMenuList;
	}
}
