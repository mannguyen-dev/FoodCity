package controllers;

import java.io.UnsupportedEncodingException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.AddressBL;
import businessLogics.CategoryBL;
import businessLogics.RestaurantBL;
import businessLogics.UserBL;
import javaBeans.Category;
import javaBeans.Restaurant;
import javaBeans.User;

@Controller
public class HomeController {
	@ModelAttribute
	public void setUTF8(HttpServletRequest rq) {
		try {
			rq.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping({"/","/home"})
	public String home() {
		return "redirect:/index.jsp";
	}
	
	@RequestMapping({"/hero"})
	public String hero(HttpServletRequest request) {
		//Get category
		CategoryBL categoryBL = new CategoryBL();
		List<Category> listCategogy = categoryBL.getAllCategory();
		
		request.setAttribute("listCat", listCategogy);
		
		return "hero_section";
	}
	
	@RequestMapping({"/feature"})
	public String feature(HttpServletRequest request) {
		//Get category
		CategoryBL categoryBL = new CategoryBL();
		List<Category> listCategogy = categoryBL.getAllCategory();
		
		//
		RestaurantBL restaurantBL = new RestaurantBL();
		List<Restaurant> listRestaurant = new ArrayList<Restaurant>();
		listRestaurant = restaurantBL.getTopRateRestaurants(12);
		
		request.setAttribute("listCat", listCategogy);
		request.setAttribute("listRes", listRestaurant);
		
		//address
		AddressBL addBL = new AddressBL();
		List<String> listAdd = new ArrayList<String>(); 
		for (int i = 0; i<listRestaurant.size();i++) {
			String address = addBL.getStringAddress(listRestaurant.get(i).getIdAddress());
			listAdd.add(address);
		}
		request.setAttribute("listAdd", listAdd);
		
		return "feature_section";
	}
	
	@RequestMapping({"/product"})
	public String product(HttpServletRequest request) {
		//Get latest Restaurant
		RestaurantBL restaurantBL = new RestaurantBL();
		List<Restaurant> latestRestaurant;
		latestRestaurant = restaurantBL.getLatestRestaurants(6);
		
		//Get latest Restaurant
		List<Restaurant> topRateRestaurant;
		topRateRestaurant = restaurantBL.getTopRateRestaurants(6);
		
		//Get latest Restaurant
		List<Restaurant> topReviewRestaurant;
		topReviewRestaurant = restaurantBL.getTopReviewRestaurants(6);
		
		//Set attribute
		request.setAttribute("latestRes", latestRestaurant);
		request.setAttribute("topRateRes", topRateRestaurant);
		request.setAttribute("topReviewRes", topReviewRestaurant);
		
		return "product_section";
	}
	
	@RequestMapping({"/breadcrumb"})
	public String breadcrumb(HttpServletRequest request,
			@RequestParam(name = "pageInfo",required = true) String pageInfo) {
		
		//Set attribute
		request.setAttribute("pageInfo", pageInfo);
		
		return "breadcrumb_section";
	}
	
	@RequestMapping({"/search_bar"})
	public String searchBar(HttpServletRequest request) {
		
		//Get category
		CategoryBL categoryBL = new CategoryBL();
		List<Category> listCategogy = categoryBL.getAllCategory();
				
		request.setAttribute("listCat", listCategogy);
				
		return "search_bar";
	}
	

}
