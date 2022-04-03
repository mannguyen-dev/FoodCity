package controllers;

import java.io.UnsupportedEncodingException;
import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.CategoryBL;
import businessLogics.UserBL;
import javaBeans.Category;
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
	

}
