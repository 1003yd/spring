package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.model.PageVO;

@RequestMapping("/user")
@Controller
public class UserController {

	// userService 스프링 빈 주입
	@Resource(name = "userService")
	private UserServiceInf userService;

	@RequestMapping("/loginView")
	public String loginView() {
		return "login/login";
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String loginView(HttpServletRequest requset) {
		String userId = requset.getParameter("userId");
		String password = requset.getParameter("password");

		if (userId.equals("brown") && password.equals("brownpass")) {
			return "main";
		} else {
			return "login/login";
		}

	}

	/**
	 * Method : userAllList 
	 * 작성자 : 1003yd 
	 * 변경이력 :
	 * 
	 * @return Method 설명 : 사용자 전체 조회
	 */
	@RequestMapping("/userAllList")
	public String userAllList(Model model) {
		// userService 사용자 전체 정보조회
		List<UserVo> userList = userService.selectUserAll();

		/* request.setAttribute("userList", userList); */
		model.addAttribute("userList", userList);

		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("/user/userAllList.jsp");
		 * rd.forward(request, response);
		 */

		return "user/userAllList";
	}

	@RequestMapping("/userPageList")
	public String userPageList(Model model, PageVO pagevo) {
		/*
		 * userService 생성 UserServiceInf userService = new UserService();
		 */

		// spring 컨테이너로부터 bean을 주입받기 때문에

		/*
		 * int page = Integer.parseInt(request.getParameter("page")); int pageSize =
		 * Integer.parseInt(request.getParameter("pageSize")); PageVO pageVo = new
		 * PageVO(); pageVo.setPage(page); pageVo.setPageSize(pageSize);
		 */

		// controller method 선언

		/*
		 * //페이지 리스트 Map<String, Object> resultMap =
		 * userService.selectUserPageList(pageVo); List<UserVO> userList =
		 * (List<UserVO>) resultMap.get("userList");
		 * 
		 * //페이지 건수 int pageCnt = (int) resultMap.get("pageCount");
		 * request.setAttribute("pageUserList", userList);
		 * request.setAttribute("pageCnt", pageCnt);
		 * 
		 */

		Map<String, Object> resultMap = userService.selectUserPageList(pagevo);
		List<UserVo> pageUserList = (List<UserVo>) resultMap.get("pageUserList");
		int pageCnt = (int) resultMap.get("pageCnt");
		model.addAllAttributes(resultMap);

		/*
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("/user/userPageList.jsp"); rd.forward(request,
		 * response);
		 */

		return "user/userPageList";
	}

	@RequestMapping("/userDetail")
	public String userDetail(@RequestParam("userId") String userId, Model model) {
		/*
		 * String userId = request.getParameter("userId");
		 */

		// @RequestParam 어노테이션을 통해 설정
		/*
		 * //사용자 아이디에 해당하는 사용자 정보 조회 UserServiceInf userService = new UserService();
		 * UserVO userVo = userService.selectUser(userId);
		 */
		UserVo userVo = userService.selectUser(userId);

		/*
		 * request.setAttribute("userVo", userVo);
		 */
		model.addAttribute("userVo", userVo);

		return "user/userDetail";
	}

	@RequestMapping(value = "/userForm", method = RequestMethod.GET)
	public String userFormView() {
		return "user/userForm";
	}

	@RequestMapping(value = "/userForm", method = RequestMethod.POST)
	public String userForm(@RequestPart("profilePic") MultipartFile part, HttpServletRequest request, UserVo userVo) {

		try {
			if (part.getSize() > 0) {
				String path = request.getServletContext().getRealPath("/profile");
				String fileName = part.getOriginalFilename();
				part.transferTo(new File(path + File.separator + fileName));
				userVo.setProfile("/profile/" + fileName);
			} else {
				userVo.setProfile("");
			}

		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		userService.insertUser(userVo);

		return "redirect:/user/userPageList?page=1&pageSize=10";
	}

	@RequestMapping(value = "/userUpdate", method = RequestMethod.GET)
	public String userUpdate(Model model, @RequestParam("userId") String userId) {

		UserVo userVo = userService.selectUser(userId);
		model.addAttribute("userVo", userVo);

		return "/user/userUpdate";
	}

	@RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
	//RequestPart("profilePic)의 이름을 왜 다르게 하는지 다시 질문해봐
	public String userUpdateDone(Model model, HttpServletRequest request, UserVo userVo,
			@RequestPart("profilePic") MultipartFile part) {
		/*
		 * UserVo userVo = new UserVo();
		 * userVo.setUserId(request.getParameter("userId"));
		 * userVo.setPass(request.getParameter("pass"));
		 * userVo.setName(request.getParameter("name"));
		 * userVo.setAddr1(request.getParameter("addr1"));
		 * userVo.setAddr2(request.getParameter("addr2"));
		 * userVo.setZipcd(request.getParameter("zipcd"));
		 * userVo.setTel(request.getParameter("tel"));
		 * userVo.setEmail(request.getParameter("email"));
		 */
		try {
//			userVo.setBirth(request.getParameter("birth"));
			if (part.getSize() > 0) {
				String path = request.getServletContext().getRealPath("/profile");
				String fileName = part.getOriginalFilename();
				part.transferTo(new File(path + File.separator + fileName));
				userVo.setProfile("/profile/" + fileName);
			} else {
				userVo.setProfile("");
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		userService.updateUser(userVo);
		
		//redirect를해야 할때는 return 값에 redirect:을 먼저 작성하고 뷰이름을 작성한다.
		return "redirect:/user/userPageList?page=1&pageSize=10";
	}
}
