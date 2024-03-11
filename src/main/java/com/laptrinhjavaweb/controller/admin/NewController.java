package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.Utils.FormUtil;
import com.laptrinhjavaweb.constant.Constant;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.pagable.PageRequest;
import com.laptrinhjavaweb.pagable.Pageble;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.sorter.Sorter;
@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet{

	/**
	 * 
	 */
	@Inject
	private INewService newService;
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NewModel model = FormUtil.toModel(NewModel.class, req);
		PageRequest pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
		model.setListResult(newService.findAll(pageble));
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int)Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
		req.setAttribute(Constant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/new/list.jsp");
		rd.forward(req, resp);
	}
}
