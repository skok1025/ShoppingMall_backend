package com.cafe24.mall.provider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.cafe24.mall.dto.JSONResult;
import com.cafe24.mall.vo.BigCategoryVo;
import com.cafe24.mall.vo.GoodsVo;
import com.cafe24.mall.vo.MemberVo;
import com.cafe24.mall.vo.SmallCategoryVo;

@Repository
public class AdminProvider {

	@Autowired
	private RestTemplate restTemplate;

	public List<MemberVo> selectMemberList(String id, String orderDateStart, String orderDateEnd) {
		
		if(id== null)
			id = "";
		if(orderDateStart== null)
			orderDateStart = "";
		if(orderDateEnd== null)
			orderDateEnd = "";
		
		JSONResultMemberList jsonresult = 
				restTemplate.getForObject("http://localhost:8099/ShoppingMall_backend/api/admin/member?id="+id+
						"&orderdateStart="+ orderDateStart
						+"&orderdateEnd="+ orderDateEnd, JSONResultMemberList.class);		
		
		return jsonresult.getData();
	}
	
	public int deleteMember(Long userNo) {
		
		
		restTemplate.delete("http://localhost:8099/ShoppingMall_backend/api/admin/member/"+userNo);
		
		return 1;
	}
	
public List<GoodsVo> selectGoodsList(Long pageNum) {
		
		JSONResultGoodsList jsonresult = 
				restTemplate.getForObject("http://localhost:8099/ShoppingMall_backend/api/admin/goodslist/"+pageNum, JSONResultGoodsList.class);		
		
		return jsonresult.getData();
	}
	
	public int deleteGoods(Long goodsNo) {
		
		restTemplate.delete("http://localhost:8099/ShoppingMall_backend/api/admin/goods/"+goodsNo);
		
		return 1;
	}
	public List<BigCategoryVo> selectBigCategoryList() {

		JSONResultBigCategoryList jsonresult = 
				restTemplate.getForObject("http://localhost:8099/ShoppingMall_backend/api/admin/category/biglist", JSONResultBigCategoryList.class);		
		
		return jsonresult.getData();
	}

	public List<SmallCategoryVo> selectSmallCategoryList(Long bigCategoryNo) {
		JSONResultSmallCategoryList jsonresult = 
				restTemplate.getForObject("http://localhost:8099/ShoppingMall_backend/api/admin/category/smalllist/"+bigCategoryNo, JSONResultSmallCategoryList.class);		
		
		return jsonresult.getData();
	}
	public Integer insertGoods(GoodsVo goodsVo) {
		
		JSONResultInteger jsonresult = 
				restTemplate.postForObject("http://localhost:8099/ShoppingMall_backend/api/admin/goods", goodsVo, JSONResultInteger.class);
		
		return jsonresult.getData();
	}
	private static class JSONResultMemberList extends JSONResult<List<MemberVo>>{	}
	private static class JSONResultInteger extends JSONResult<Integer>{	}
	private static class JSONResultGoodsList extends JSONResult<List<GoodsVo>>{}
	private static class JSONResultBigCategoryList extends JSONResult<List<BigCategoryVo>>{}
	private static class JSONResultSmallCategoryList extends JSONResult<List<SmallCategoryVo>>{}
	


}