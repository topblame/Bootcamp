package kr.co.soldesk.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.soldesk.beans.BoardInfoBean;
import kr.co.soldesk.mapper.TopMenuMapper;

//mapper에서 직접 결과물을 받을 수 없으므로 오버라이딩하여 결과를 받아옴 -> 유지보수가 효율적.
@Repository
public class TopMenuDAO {
	@Autowired
	private TopMenuMapper topMenuMapper;
	
	public List<BoardInfoBean> getTopMenuList(){
		List<BoardInfoBean> topMenuList = topMenuMapper.getTopMenuList();
		
		return topMenuList;
	}
}
