package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.pagable.Pageble;

public interface INewService {
 List<NewModel> findByCategoryId(Long categoryId);
 Long save(NewModel newModel);
 List<NewModel> findAll(Pageble pageble); 
 int getTotalItem();
}
