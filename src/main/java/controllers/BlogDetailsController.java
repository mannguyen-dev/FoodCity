package controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
		//getReview
		UserBL uBL = new UserBL();
		List<User> listUserReview = new ArrayList<User>();
		for(Review review: listReview) {
			listUserReview.add(uBL.getById(review.getIdUser()));
		}
		
		//get list cat and this cat
		List<String> listCatAndAmt = blogBL.getStringBlogCategory();
		CategoryBL catBL = new CategoryBL();
		Category cat = catBL.getById(blog.getIdCategory());
		
		//get blog outstanding
		List<Blog> listOutStanding = blogBL.getOutstanding(5);
		
		//get blog new
		List<Blog> blogNews = blogBL.getAll(3);
		
		//set attribute
		request.setAttribute("blog", blog);
		request.setAttribute("poster", poster);
		request.setAttribute("listReview", listReview);
		request.setAttribute("listUserReview", listUserReview);
		request.setAttribute("listCatAndAmt", listCatAndAmt);
		request.setAttribute("posterRole", role);
		request.setAttribute("thisCat", cat);
		request.setAttribute("listOutStanding", listOutStanding);
		request.setAttribute("blogNews", blogNews);
		
		return "blog_details_section";
	}
	
	@RequestMapping({"/blog_section_grid"})
	public String blogSectionGrid(HttpServletRequest request) {
        int trang =1;
        int idCat =-1;
        String txtSearch = "";
        if (request.getParameter("page")!=null)
        	trang = Integer.parseInt(request.getParameter("page"));
        if (request.getParameter("idCat")!=null)
        	idCat = Integer.parseInt(request.getParameter("idCat"));
        if (request.getParameter("txtSearch")!=null)
        	txtSearch = request.getParameter("txtSearch");
		//get blog
		BlogBL blogBL = new BlogBL();
		List<Blog> listBlog;
		
		if (txtSearch != "")
			listBlog = blogBL.findByTitle(txtSearch);
		else if (idCat != -1) {
			listBlog = blogBL.getByCategory(idCat);
			CategoryBL catBL = new CategoryBL();
			request.setAttribute("category", catBL.getById(idCat));
		}else
			listBlog = blogBL.getAll();
		
		int tsd = listBlog.size();
        int sdt = 6;
        int tst = tsd/sdt + (tsd%sdt!=0?1:0);
        listBlog = listBlog.subList((trang-1)*sdt, (trang*sdt>tsd?((trang-1)*sdt+tsd%sdt):trang*sdt));
		
		//get blog outstanding
		List<Blog> listOutStanding = blogBL.getOutstanding(5);
	
		//get list cat and this cat
		List<String> listCatAndAmt = blogBL.getStringBlogCategory();
		
		//set attribute
		request.setAttribute("listBlog", listBlog);
		request.setAttribute("page", trang);
		request.setAttribute("totalPage", tst);
		request.setAttribute("listOutStanding", listOutStanding);
		request.setAttribute("listCatAndAmt", listCatAndAmt);
		
		return "blog_section_grid";
	}
	
	@RequestMapping({"/post_blog_comment"})
	public String postReview(HttpServletRequest request,
			@RequestParam(name = "idBlog",required = true) int idBlog,
			@RequestParam(name = "idUser",required = true) int idUser,
			@RequestParam(name = "like",required = false) boolean like,
			@RequestParam(name = "content",required = true) String content) {

		ReviewBL reBL = new ReviewBL();
		reBL.postCommentBlog(content, like, idBlog, idUser);
		
		return "redirect:/blog_details.jsp?idBlog="+idBlog;
	}
	
}
