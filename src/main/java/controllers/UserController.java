package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import businessLogics.UserBL;
import javaBeans.User;

@Controller
public class UserController {
	@ModelAttribute
	public void setUTF8(HttpServletRequest rq) {
		try {
			rq.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(path = "/signup")
	public String header(HttpServletRequest request) {
		return "signup_section";
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	public String header(HttpServletRequest request, 
			@RequestParam(name = "fname",required = true) String fname,
			@RequestParam(name = "birthday",required = true) String birthday,
			MultipartFile file,
			@RequestParam(name = "email",required = true) String email,
			@RequestParam(name = "phone",required = true) String phone,
			@RequestParam(name = "role",required = true) String role,
			@RequestParam(name = "gender",required = true) String gender,
			@RequestParam(name = "password",required = true) String password,
			@RequestParam(name = "re-password",required = true) String re_password,
			@RequestParam(name = "term",required = false) String term
			) throws IOException, ServletException {
		
		UserBL uBL = new UserBL();
		String warning = "";
		
		if (term == null) {
			warning = "Bạn chưa đồng ý với các điều khoản của chúng tôi?!";
		} else if (fname.equals("")) {
			warning = "Bạn chưa nhập tên. Vui lòng nhập lại thông tin!";
		} else if (email.equals("")) {
			warning = "Bạn chưa nhập email. Vui lòng nhập lại thông tin!";
		} else if (phone.equals("")) {
			warning = "Bạn chưa nhập số điện thoại. Vui lòng nhập lại thông tin!";
		} else if (password.equals("")) {
			warning = "Bạn chưa nhập password. Vui lòng nhập lại thông tin!";
		} else if (!re_password.equals(password)) {
			warning = "Mật khẩu nhập lại không khớp. Vui lòng kiểm tra lại!";
		//Check exist account
		} else if (uBL.isExistEmail(email)) {
			warning = "Email vừa nhập đã tồn tại trên hệ thống!";
		} else if (!phone.equals("") && uBL.isExistPhone(phone)) {
			warning = "Số điện thoại vừa nhập đã tồn tại trên hệ thống!";
		}
		
		if (warning != "") {
			request.setAttribute("warning", warning);
			return "signup_section";
		}
		
		Date date = null;
		
		try {
			date = new Date(Integer.parseInt(birthday.substring(6, 10))-1900,
					Integer.parseInt(birthday.substring(3, 5))-1,
					Integer.parseInt(birthday.substring(0, 2)));
		}catch(Exception e){
			e.printStackTrace();
			warning = "Định dạng ngày sinh không đúng. Vui lòng nhập lại thông tin!";
			request.setAttribute("warning", warning);
			return "signup_section";
		}
		
		String image = RandomStringUtils.randomAlphabetic(30) + ".jpg";
		
		String folderUpload = request.getServletContext().getRealPath("/img/user/");
		byte[] mb = file.getBytes();
		OutputStream os = new FileOutputStream(folderUpload+image);
		os.write(mb);
		os.close();
	
		User u = new User(0,fname,password,date,(gender == "nam")?false:true,image,email,phone,(role=="customer")?3:2);
		uBL.addUser(u);
	
		request.setAttribute("mess2", "Chúc mừng bạn đã đăng ký tài khoản thành công. Mời bạn đăng nhập!");
		
		return "login_section";
	}
	
	@RequestMapping(path = "/login")
	public String login(HttpServletRequest request) {
		return "login_section";
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, 
			@RequestParam(name = "email",required = true) String email,
			@RequestParam(name = "password",required = true) String password) {
		UserBL uBL = new UserBL();
		User u;
		String mess = null;
		
		if (email.equals("")) 
			mess = "<i class='fa fa-exclamation-triangle' aria-hidden='true'></i> Vui lòng nhập email/số điện thoại.";
		else if (password.equals(""))
			mess = "<i class='fa fa-exclamation-triangle' aria-hidden='true'></i> Vui lòng nhập mật khẩu.";
		if (mess != null) {
			request.setAttribute("mess", mess);
			return "login_section";
		}
		
		
		if (email.contains("@"))
			u =  uBL.loginByEmail(email, password);
		else
			u = uBL.loginByPhone(email, password);
		
		if (u == null) {
			request.setAttribute("mess", "<i class='fa fa-exclamation-triangle' aria-hidden='true'></i> Sai mật khẩu hoặc email/số điện thoại chưa đăng ký.");
			return "login_section";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", u);
		request.setAttribute("mess1", "Đăng nhập thành công. Trở về <a href='home' style='color:#e67700;font-weight:bold;'> TRANG CHỦ!  </a>");
		return "login_section";
	}
	
	@RequestMapping(path = "/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) session.invalidate();
		return "redirect:/home";
	}
	
	@RequestMapping(path = "/forgot_pass")
	public String forgotPass(HttpServletRequest request) {
		String mess = "Vui lòng kiểm tra email/tin nhắn và làm theo hướng dẫn!";
		request.setAttribute("mess2",mess);
		return "login_section";
	}
}
