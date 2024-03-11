package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.pagable.Pageble;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService{
	
	@Inject
	private INewDAO newDAO;
	
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return newDAO.findByCategoryId(categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		// TODO Auto-generated method stub
		return newDAO.save(newModel);
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		// TODO Auto-generated method stub
		return newDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return newDAO.getTotalItem();
	}

}
