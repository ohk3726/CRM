package com.usinsa.crm.dao;

import java.util.List;

import com.usinsa.crm.vo.LevelVO;

public interface LevelDAO {
	List<LevelVO> level_order(LevelVO vo) throws Exception;
	List<LevelVO> level_down_list() throws Exception;
	List<LevelVO> level_down_expected_list() throws Exception;
}
