package kr.co.soldesk.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.soldesk.beans.ContentBean;
import kr.co.soldesk.mapper.BoardMapper;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
    private SqlSession sqlSession;
	private final String namespace = "kr.co.soldesk.mapper.BoardMapper";
	
	public void addContentInfo(ContentBean writeContentBean) {
		// 제목 내용 이미지 게시판종류, 사용자정보
		boardMapper.addContentInfo(writeContentBean);
	}

	public String getBoardInfoName(int board_info_idx) {
		return boardMapper.getBoardInfoName(board_info_idx);
	}

	public List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds) {
		return boardMapper.getContentList(board_info_idx, rowBounds);
	}

	public ContentBean getContentInfo(int content_idx) {
		return boardMapper.getContentInfo(content_idx);
	}

	public void modifyContentInfo(ContentBean modifyContentBean) {
		boardMapper.modifyContentInfo(modifyContentBean);
	}

	public void deleteContentInfo(int content_idx) {
		boardMapper.deleteContentInfo(content_idx);
	}

	public int getContentCnt(int content_board_idx) {
		return boardMapper.getContentCnt(content_board_idx);
	}
	public List<ContentBean> searchContents(String keyword) {
        return sqlSession.selectList(namespace + ".searchContents", keyword);
    }
}
