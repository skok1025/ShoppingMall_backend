package com.cafe24.mall.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mall.vo.BigCategoryVo;
import com.cafe24.mall.vo.SmallCategoryVo;

@Repository
public class AdminDao {

	@Autowired
	private SqlSession sqlsession;

	public int insertBigCategory(BigCategoryVo vo) {
		return sqlsession.insert("admin.insertBigCategory",vo);
	}

	public int updateBigCategory(BigCategoryVo vo) {
		return sqlsession.update("admin.updateBigCategory",vo);
	}

	public Long getCurrentInsertBigCategoryNo() {
		return sqlsession.selectOne("admin.getCurrentInsertBigCategoryNo");
	}

	public Long getCurrentInsertSmallCategoryNo() {
		return sqlsession.selectOne("admin.getCurrentInsertSmallCategoryNo");
	}
	public int deleteBigCategory(BigCategoryVo vo) {
		sqlsession.delete("admin.deleteBigCategory",vo);
		return vo.getPresult();
	}

	
	public int updateGoodsSmallCategoryNullByBigCategoryNo(Long no) {
		return sqlsession.update("admin.updateGoodsSmallCategoryNullByBigCategoryNo", no);
	}

	public int deleteSmallCategoryByBigCategoryNo(Long no) {
		return sqlsession.delete("admin.deleteSmallCategoryByBigCategoryNo",no);
	}

	public int insertSmallCategory(SmallCategoryVo vo) {
		return sqlsession.insert("admin.insertSmallCategory", vo);
	}

	public int updateSmallCategory(SmallCategoryVo vo) {
		return sqlsession.update("admin.updateSmallCategory", vo);
	}

	
}
