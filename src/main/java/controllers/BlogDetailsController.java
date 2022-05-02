package controllers;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.BlogBL;
import businessLogics.CategoryBL;
import businessLogics.ReviewBL;
import businessLogics.RoleBL;
import businessLogics.UserBL;
import javaBeans.Blog;
import javaBeans.Category;
import javaBeans.Review;
import javaBeans.Role;
import javaBeans.User;

@Controller
public class BlogDetailsController {
	@ModelAttribute
	public void setUTF8(HttpServletRequest rq) {
		try {
			rq.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping({"/blog_details"})
	public String blogDetails(HttpServletRequest request,
			@RequestParam(name = "idBlog",required = true) int idBlog) {
		//get blog
		BlogBL blogBL = new BlogBL();
		Blog blog = blogBL.getById(idBlog);
		
		//get poster and poster role
		UserBL userBL = new UserBL();
		User poster = userBL.getById(blog.getIdUser());
		RoleBL roleBL = new RoleBL();
		Role role = roleBL.getByIdRole(poster.getIdRole());
		
		//get list comment
		ReviewBL rBL = new ReviewBL();
		List<Review> listReview = rBL.getByIdBlog(idBlog, 8);
		
		//get list cat and this cat
		List<String> listCatAndAmt = blogBL.getStringBlogCategory();
		CategoryBL catBL = new CategoryBL();
		Category cat = catBL.getById(blog.getIdCategory());
		
		//set attribute
		request.setAttribute("blog", blog);
		request.setAttribute("poster", poster);
		request.setAttribute("listReview", listReview);
		request.setAttribute("listCatAndAmt", listCatAndAmt);
		request.setAttribute("posterRole", role);
		request.setAttribute("thisCat", cat);
		
		return "blog_details_section";
	}
}
