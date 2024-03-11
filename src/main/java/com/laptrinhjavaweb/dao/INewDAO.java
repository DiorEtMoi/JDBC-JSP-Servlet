package com.laptrinhjavaweb.dao;



import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.pagable.Pageble;

public interface INewDAO {
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel);
	List<NewModel> findAll(Pageble page);
	int getTotalItem();
}
