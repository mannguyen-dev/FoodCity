package controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.AddressBL;
import businessLogics.CategoryBL;
import businessLogics.RestaurantBL;
import javaBeans.Address;
import javaBeans.Category;
import javaBeans.Restaurant;

@Controller
public class RestaurantGridController {
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
	
	@RequestMapping({"/find_restaurant"})
	public String findRestaurant(HttpServletRequest request,
			@RequestParam(name = "txtSearch",required = false) String name,
			@RequestParam(name = "category",required = false) String idCat,
			@RequestParam(name = "ward",required = false) String ward,
			@RequestParam(name = "district",required = false) String district,
			@RequestParam(name = "city",required = false) String city) {
		
		
		CategoryBL catBL = new CategoryBL();
		List<Category> listCategogy = catBL.getAllCategory();
		
		//
		RestaurantBL restaurantBL = new RestaurantBL();
		List<Restaurant> listRestaurant;
		if (idCat == null) {
			listRestaurant = restaurantBL.find(name, idCat, ward, district, city);
		}else if (idCat.equals("-1"))
			listRestaurant = restaurantBL.getAllRestaurants();
		else {
			listRestaurant = restaurantBL.find(name, idCat, ward, district, city);
		}
		
		//address
		AddressBL addBL = new AddressBL();
		List<String> listCity = addBL.getAllCity();
		List<String> listDistrict = addBL.getAllDistrict();
		List<String> listWard = addBL.getAllWard();
		
		//address
		List<String> listAdd = new ArrayList<String>(); 
		for (int i = 0; i<listRestaurant.size();i++) {
			String address = addBL.getStringAddress(listRestaurant.get(i).getIdAddress());
			listAdd.add(address);
		}
		
		request.setAttribute("listAdd", listAdd);
		request.setAttribute("listCat", listCategogy);
		request.setAttribute("listRes", listRestaurant);
		request.setAttribute("listCity", listCity);
		request.setAttribute("listDist", listDistrict);
		request.setAttribute("listWard", listWard);
		
		return "restaurant_grid_section";
	}
	
	
}
