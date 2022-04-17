package controllers;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import businessLogics.AddressBL;
import businessLogics.CategoryBL;
import businessLogics.RestaurantBL;
import javaBeans.Address;
import javaBeans.Category;
import javaBeans.Restaurant;

@Controller
public class ShopGridController {
	@ModelAttribute
	public void setUTF8(HttpServletRequest rq) {
		try {
			rq.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping({"/ShopGrid"})
	public String shopGrid() {
		return "redirect:/shop_grid.jsp";
	}
	
	@RequestMapping({"/restaurant_grid"})
	public String breadcrumb(HttpServletRequest request) {
		CategoryBL catBL = new CategoryBL();
		List<Category> listCategogy = catBL.getAllCategory();
		
		//
		RestaurantBL restaurantBL = new RestaurantBL();
		List<Restaurant> listRestaurant;
		if (request.getParameter("category") == null)
			listRestaurant = restaurantBL.getAllRestaurants();
		else {
			int id_cat = Integer.parseInt(request.getParameter("category"));
			listRestaurant = restaurantBL.getAllRestaurantsByCategory(id_cat,6);
		}
		
		//address
		AddressBL addBL = new AddressBL();
		List<String> listCity = addBL.getAllCity();
		List<String> listDistrict = addBL.getAllDistrict();
		List<String> listWard = addBL.getAllWard();
		
		request.setAttribute("listCat", listCategogy);
		request.setAttribute("listRes", listRestaurant);
		request.setAttribute("listCity", listCity);
		request.setAttribute("listDist", listDistrict);
		request.setAttribute("listWard", listWard);
		
		return "restaurant_grid_section";
	}
	
	
}