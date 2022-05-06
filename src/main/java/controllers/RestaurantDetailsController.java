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
import businessLogics.ReviewBL;
import businessLogics.UserBL;
import javaBeans.Address;
import javaBeans.Category;
import javaBeans.Image;
import javaBeans.Restaurant;
import javaBeans.Review;
import javaBeans.User;

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
		
		// get address
		AddressBL addBL = new AddressBL();
		String address = addBL.getStringAddress(restaurant.getIdAddress()); 
		
		// get poster
		UserBL uBL = new UserBL();
		User u = uBL.getById(restaurant.getIdUser());
		
		//getReview
		ReviewBL reBL = new ReviewBL();
		List<Review> listReview = reBL.getByIdRestaurant(idRes, 8);
		List<User> listUserReview = new ArrayList<User>();
		for(Review review: listReview) {
			listUserReview.add(uBL.getById(review.getIdUser()));
		}
				
		
		// get images
		ImageBL imageBL = new ImageBL();
		List<Image> listFeatureImg = imageBL.getByIdResAlbum(idRes, 1);
		List<Image> listFoodImg = imageBL.getByIdResAlbum(idRes, 2);
		List<Image> listReviewImg = imageBL.getByIdResAlbum(idRes, 3);
		
		// set attribute
		request.setAttribute("res", restaurant);
		request.setAttribute("cat", cat);
		request.setAttribute("listFeatureImg", listFeatureImg);
		request.setAttribute("listFoodImg", listFoodImg);
		request.setAttribute("listReviewImg", listReviewImg);
		request.setAttribute("address", address);
		request.setAttribute("poster", u);
		request.setAttribute("listReview", listReview);
		request.setAttribute("listUserReview", listUserReview);
		
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
		List<Address> listAdd = new ArrayList<>(); 
		for (int i = 0; i<listRes.size();i++) {
			Address address = addBL.getAddress(listRes.get(i).getIdAddress());
			listAdd.add(address);
		}
		
		//related restaurant category
		CategoryBL catBL = new CategoryBL();
		List<Category> listCatRes = new ArrayList<Category>();
		for (Restaurant res: listRes) {
			listCatRes.add(catBL.getById(res.getIdCategory()));
		}
		
		// set att
		request.setAttribute("listAdd", listAdd);
		request.setAttribute("listRes", listRes);
		request.setAttribute("listCatRes", listCatRes);
		
		return "related_restaurant_section";
	}

	@RequestMapping({"/post_review"})
	public String postReview(HttpServletRequest request,
			@RequestParam(name = "idRes",required = true) int idRes,
			@RequestParam(name = "idUser",required = true) int idUser,
			@RequestParam(name = "stars",required = true) int stars,
			@RequestParam(name = "title",required = true) String title,
			@RequestParam(name = "content",required = true) String content) {

		ReviewBL reBL = new ReviewBL();
		reBL.postCommentRestaurant(title, content, stars, idRes, idUser);
		
		return "redirect:/restaurant-details.jsp?idRes="+idRes;
	}
}
