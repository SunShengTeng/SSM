package cn.sst.study.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sst.study.springmvc.mapper.ItemsMapper;
import cn.sst.study.springmvc.pojo.Items;
import cn.sst.study.springmvc.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;
	@Override
	public List<Items> queryItemList() {
		return itemsMapper.selectByExampleWithBLOBs(null);
	}
	@Override
	public Items findItemById(int id) {
		return itemsMapper.selectByPrimaryKey(id);
	}
	@Override
	public void updateItem(Items item) {
		itemsMapper.updateByPrimaryKeySelective(item);
		
	}

}
