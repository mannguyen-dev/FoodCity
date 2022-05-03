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
	
	@RequestMapping({"/restaurant_grid"})
	public String breadcrumb(HttpServletRequest request) {
		CategoryBL catBL = new CategoryBL();
		List<Category> listCategogy = catBL.getAllCategory();
		
		// get list restaurant
		RestaurantBL restaurantBL = new RestaurantBL();
		List<Restaurant> listRestaurant;
		if (request.getParameter("category") == null)
			listRestaurant = restaurantBL.getAllRestaurants();
		else {
			int id_cat = Integer.parseInt(request.getParameter("category"));
			listRestaurant = restaurantBL.getAllRestaurantsByCategory(id_cat,6);
		}
		
		// get address
		AddressBL addBL = new AddressBL();
		List<String> listCity = addBL.getAllCity();
		List<String> listDistrict = addBL.getAllDistrict();
		List<String> listWard = addBL.getAllWard();
		
		// set attribute
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
		
		// get list category
		CategoryBL catBL = new CategoryBL();
		List<Category> listCategogy = catBL.getAllCategory();
		
		// get list restaurant
		RestaurantBL restaurantBL = new RestaurantBL();
		List<Restaurant> listRestaurant;
		if (idCat == null) {
			listRestaurant = restaurantBL.find(name, idCat, ward, district, city);
		}else if (idCat.equals("-1"))
			listRestaurant = restaurantBL.getAllRestaurants();
		else {
			listRestaurant = restaurantBL.find(name, idCat, ward, district, city);
		}
		
		// get list category of restaurant
		List<Category> listCatRes = new ArrayList<Category>();
		for (Restaurant res: listRestaurant) {
			listCatRes.add(catBL.getById(res.getIdCategory()));
		}
		
		// get address for search form
		AddressBL addBL = new AddressBL();
		List<String> listCity = addBL.getAllCity();
		List<String> listDistrict = addBL.getAllDistrict();
		List<String> listWard = addBL.getAllWard();
		
		// get address of list restaurant
		List<Address> listAdd = new ArrayList<Address>(); 
		for (int i = 0; i<listRestaurant.size();i++) {
			Address address = addBL.getAddress(listRestaurant.get(i).getIdAddress());
			listAdd.add(address);
		}
		
		// set attribute
		request.setAttribute("listAdd", listAdd);
		request.setAttribute("listCat", listCategogy);
		request.setAttribute("listRes", listRestaurant);
		request.setAttribute("listCity", listCity);
		request.setAttribute("listDist", listDistrict);
		request.setAttribute("listWard", listWard);
		request.setAttribute("listCatRes", listCatRes);
		
		return "restaurant_grid_section";
	}
	
	
}
