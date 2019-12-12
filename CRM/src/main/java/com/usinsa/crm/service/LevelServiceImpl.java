package com.usinsa.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usinsa.crm.dao.LevelDAO;
import com.usinsa.crm.vo.LevelVO;

@Service("LevelService")
public class LevelServiceImpl implements LevelService{
	@Autowired
	private LevelDAO levelMapper;
	
	@Override
	@Transactional
	public List level_order(LevelVO vo) throws Exception{
		return levelMapper.level_order(vo);
	}
	
	@Override
	@Transactional
	public List level_down_list() throws Exception{
		return levelMapper.level_down_list();
	}
	
	@Override
	@Transactional
	public List level_down_expected_list() throws Exception{
		return levelMapper.level_down_expected_list();
	}
}
