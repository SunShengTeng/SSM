package cn.sst.study.springmvc.service;

import java.util.List;

import cn.sst.study.springmvc.pojo.Items;

public interface ItemService {

	List<Items> queryItemList();

	Items findItemById(int id);

	void updateItem(Items item);

}
