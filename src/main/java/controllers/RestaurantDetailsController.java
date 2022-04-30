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
import businessLogics.ImageBL;
import businessLogics.RestaurantBL;
import javaBeans.Address;
import javaBeans.Category;
import javaBeans.Image;
import javaBeans.Restaurant;

@Controller
public class RestaurantDetailsController {
	@ModelAttribute
	public void setUTF8(HttpServletRequest rq) {
		try {
			rq.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping({"/restaurant_details"})
	public String restaurantDetails(HttpServletRequest request,
			@RequestParam(name = "idRes",required = true) int idRes) {
		// get Restaurant
		RestaurantBL resBL = new RestaurantBL();
		Restaurant restaurant = resBL.getById(idRes);
		
		// get category
		CategoryBL catBL = new CategoryBL();
		Category cat = catBL.getById(restaurant.getIdCategory());
		
		//address
		AddressBL addBL = new AddressBL();
		String address = addBL.getStringAddress(restaurant.getIdAddress()); 
		
		
		// get images
		ImageBL imageBL = new ImageBL();
		List<Image> listFeatureImg = imageBL.getByIdResAlbum(idRes, 1);
		List<Image> listFoodImg = imageBL.getByIdResAlbum(idRes, 2);
		List<Image> listReviewImg = imageBL.getByIdResAlbum(idRes, 3);
		
		// set att
		request.setAttribute("res", restaurant);
		request.setAttribute("cat", cat);
		request.setAttribute("listFeatureImg", listFeatureImg);
		request.setAttribute("listFoodImg", listFoodImg);
		request.setAttribute("listReviewImg", listReviewImg);
		request.setAttribute("address", address);
		
		return "restaurant_details_section";
	}
	
		@RequestMapping({"/related_restaurant"})
	public String relatedRestaurant(HttpServletRequest request,
			@RequestParam(name = "idRes",required = true) int idRes) {
		// get Restaurant
		RestaurantBL resBL = new RestaurantBL();
		Restaurant restaurant = resBL.getById(idRes);
		List<Restaurant> listRes = resBL.getAllRestaurantsByCategory(restaurant.getIdCategory(), 4);
		
		//address
		AddressBL addBL = new AddressBL();
		List<String> listAdd = new ArrayList<String>(); 
		for (int i = 0; i<listRes.size();i++) {
			String address = addBL.getStringAddress(listRes.get(i).getIdAddress());
			listAdd.add(address);
		}
		
		// set att
		request.setAttribute("listAdd", listAdd);
		request.setAttribute("listRes", listRes);
		
		return "related_restaurant_section";
	}
}
