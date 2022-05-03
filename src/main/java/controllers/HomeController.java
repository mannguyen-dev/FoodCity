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
import businessLogics.AdvertisementBL;
import businessLogics.BlogBL;
import businessLogics.CategoryBL;
import businessLogics.EmailSubBL;
import businessLogics.RestaurantBL;
import javaBeans.Address;
import javaBeans.Advertisement;
import javaBeans.Blog;
import javaBeans.Category;
import javaBeans.Restaurant;

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
	
	@RequestMapping({"email_sub"})
	public String emailSub(HttpServletRequest request, @RequestParam(name = "email",required = true) String email) {
		EmailSubBL eBL = new EmailSubBL();
		eBL.insertEmail(email);
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
		request.setAttribute("listCat", listCategogy);
		
		//Get list restaurant with category
		RestaurantBL restaurantBL = new RestaurantBL();
		List<Restaurant> listRestaurant = new ArrayList<Restaurant>();	
		listRestaurant = restaurantBL.getTopRateRestaurants(8);
		List<Category> listCatRes = new ArrayList<Category>();
		for (Restaurant res: listRestaurant) {
			listCatRes.add(categoryBL.getById(res.getIdCategory()));
		}
		
		// get list address
		AddressBL addBL = new AddressBL();
		List<Address> listAdd = new ArrayList<Address>(); 
		for (int i = 0; i<listRestaurant.size();i++) {
			Address address = addBL.getAddress(listRestaurant.get(i).getIdAddress());
			listAdd.add(address);
		}
		
		// get attribute
		request.setAttribute("listRes", listRestaurant);
		request.setAttribute("listCatRes", listCatRes);
		request.setAttribute("listAdd", listAdd);
		
		return "feature_section";
	}
	
	@RequestMapping({"/product"})
	public String product(HttpServletRequest request) {
		CategoryBL catBL = new CategoryBL();
		
		// Get latest Restaurant
		RestaurantBL restaurantBL = new RestaurantBL();
		List<Restaurant> latestRestaurant = restaurantBL.getLatestRestaurants(6);
		
		List<Category> latestResCat = new ArrayList<Category>();
		for (Restaurant res: latestRestaurant) {
			latestResCat.add(catBL.getById(res.getIdCategory()));
		}
		
		// Get latest Restaurant
		List<Restaurant> topRateRestaurant = restaurantBL.getTopRateRestaurants(6);
		
		List<Category> topRateResCat = new ArrayList<Category>();
		for (Restaurant res: topRateRestaurant) {
			topRateResCat.add(catBL.getById(res.getIdCategory()));
		}
		
		// Get latest Restaurant
		List<Restaurant> topReviewRestaurant = restaurantBL.getTopReviewRestaurants(6);
		
		List<Category> topReviewResCat = new ArrayList<Category>();
		for (Restaurant res: topReviewRestaurant) {
			topReviewResCat.add(catBL.getById(res.getIdCategory()));
		}
		
		
		//Set attribute
		request.setAttribute("latestRes", latestRestaurant);
		request.setAttribute("topRateRes", topRateRestaurant);
		request.setAttribute("topReviewRes", topReviewRestaurant);
		
		request.setAttribute("latestResCat", latestResCat);
		request.setAttribute("topRateResCat", topRateResCat);
		request.setAttribute("topReviewResCat", topReviewResCat);
		
		return "product_section";
	}
	
	@RequestMapping({"/breadcrumb"})
	public String breadcrumb(HttpServletRequest request,
			@RequestParam(name = "pageInfo",required = true) String pageInfo) {
		// Get list restaurant
		if (request.getParameter("idRes") != null) {
			int idRes = Integer.parseInt(request.getParameter("idRes"));
			RestaurantBL resBL = new RestaurantBL();
			Restaurant res = resBL.getById(idRes);
			request.setAttribute("res", res);
		}
		// Set attribute
		request.setAttribute("pageInfo", pageInfo);
		
		return "breadcrumb_section";
	}
	
	@RequestMapping({"/search_bar"})
	public String searchBar(HttpServletRequest request) {
		
		// Get category
		CategoryBL categoryBL = new CategoryBL();
		List<Category> listCategogy = categoryBL.getAllCategory();
				
		request.setAttribute("listCat", listCategogy);
				
		return "search_bar";
	}
	
	@RequestMapping({"/banner"})
	public String banner(HttpServletRequest request) {
		
		// Get category
		AdvertisementBL adBL = new AdvertisementBL();
		List<Advertisement> listAd = adBL.getAll();
				
		request.setAttribute("listAd", listAd);
				
		return "banner";
	}
	
	@RequestMapping({"/blog_section"})
	public String blogSection(HttpServletRequest request) {
		
		// Get blog
		BlogBL blogBL = new BlogBL();
		List<Blog> listBlog = blogBL.getAll(3);
				
		request.setAttribute("listBlog", listBlog);
				
		return "blog_section";
	}
}
