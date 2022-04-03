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

import businessLogics.UserBL;

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
	public String trangChu() {
		return "redirect:/index.jsp";
	}
	
	@RequestMapping(path = "/login")
	public String header(HttpServletRequest request) {
		return "login_section";
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String header(HttpServletRequest request, 
			@RequestParam(name = "email",required = true) String email,
			@RequestParam(name = "password",required = true) String password) {
		UserBL uBL = new UserBL();
		User u;
		if (email.contains("@"))
			u =  uBL.loginByEmail(email, password);
		else
			u = uBL.loginByPhone(email, password);
		
		if (u == null) {
			request.setAttribute("mess", "Sai mật khẩu hoặc email/số điện thoại chưa đăng ký.");
			return "login_section";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", u);
		request.setAttribute("mess1", "Đăng nhập thành công. Trở về <a href='home'> trang chủ!  </a>");
		return "login_section";
	}
	
	@RequestMapping(path = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) session.invalidate();
		return "redirect:/home";
	}
	

}
