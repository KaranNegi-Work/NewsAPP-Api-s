package com.Project.App.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project.App.Entities.Admins;
import com.Project.App.Entities.AllNews;
import com.Project.App.Entities.Entities;
import com.Project.App.Entities.Postcheck;
import com.Project.App.ResponceBody.CreateUserResponce;
import com.Project.App.ResponceBody.LoginResponse;
import com.Project.App.UserRepository.Checkpost;
import com.Project.App.UserRepository.UserPostsRepository;
import com.Project.App.UserRepository.UserRepository;
import com.Project.App.UserRepository.adminRepository;
import com.Project.App.UserRequestBody.ProfilePhotoRequest;
import com.Project.App.UserRequestBody.UserLoginRequest;
import com.Project.App.UserRequestBody.UserPostRequest;
import com.Project.App.UserRequestBody.UserRequest;

@RestController
@RequestMapping("/home")
public class Controller {
	@GetMapping("/Auth")
	public String healthCheck() {
		return "UP";
	}

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserPostsRepository postRepository;
	@Autowired
	private Checkpost CheckPostRepository;

	@GetMapping("/news")
	public @ResponseBody List<AllNews> news() {
		
		return postRepository.findAll();
	}

	@PostMapping("/CreateUser")
	public @ResponseBody CreateUserResponce createUser(@RequestBody UserRequest request) {

		Entities data = new Entities();
		data.setName(request.getName());
		data.setEmail(request.getEmail());
		data.setPassword(request.getPassword());
		data.setPhoneno(request.getPhoneno());
		userRepository.save(data);
		CreateUserResponce response = new CreateUserResponce();
		response.setMessage("User Is Created");
		response.setName(data.getName());
		return response;
	}
	//POST METHOD FOR IMAGE UPLOADING
	@PostMapping("/Addpost")
    public LoginResponse Addpost(@RequestBody UserPostRequest userPostRequest) {
		Postcheck post=new Postcheck();
		post.setDiscription(userPostRequest.getDiscription());
		post.setImage(userPostRequest.getImage());
		post.setFullInformation(userPostRequest.getFullInformation());
		CheckPostRepository.save(post);
		LoginResponse back = new LoginResponse();
        back.setStatus("Post is Created Successfully");
			return back;
	
	
	}
	
	@PostMapping("/userlogin")
	public LoginResponse auth(@RequestBody UserLoginRequest userLoginRequest) {
		Entities user = userRepository.findByEmailAndPassword(userLoginRequest.getEmail(),
		userLoginRequest.getPassword());
		System.out.println("user" + user);
//		System.out.println("user" + user.getEmail());
		LoginResponse back = new LoginResponse();

		if (user != null) {
			back.setStatus("Success");
			back.setName(user.getName());
			return back;
		} else {
			back.setStatus("Failed");
			return back;
		}
		

	}

	//For Rating the News
	@PostMapping("/Rating")
	public String TRP(@RequestParam int id) {
		
		AllNews createpost=postRepository.findByid(id);
		int rate=createpost.getRate();
		rate++;
		createpost.setRate(rate);
		postRepository.save(createpost);
		return "OK..";
	}
	@PostMapping("/FullArticle")
	private @ResponseBody AllNews fullarticle(@RequestParam int id) {
		AllNews createpost=postRepository.findByid(id);
		int rate=createpost.getRate();
		rate++;
		createpost.setRate(rate);
		postRepository.save(createpost);
	return createpost;
	}
	
	
	@PostMapping("/ProfilePhoto")
	private String ProfilePhonto(@RequestBody ProfilePhotoRequest profiledata ) {
//		System.out.println("REQUEST DATA" + profiledata.getEmail());
//		System.out.println("REQUEST DATA" + profiledata.getPhoto());
		Entities entities=userRepository.findByEmail(profiledata.getEmail());
		entities.setProfilephoto(profiledata.getPhoto());
		userRepository.save(entities);
		return "done";
	}
	@PostMapping("/FetchProfilePhoto")
	private  ProfilePhotoRequest ProfilePhonto(@RequestParam String email ) {
		Entities entities=userRepository.findByEmail(email);
		System.out.println("REQUEST DATA" + entities.getProfilephoto());
		ProfilePhotoRequest back=new ProfilePhotoRequest();
		back.setEmail(entities.getEmail());
		back.setPhoto(entities.getProfilephoto());
		
		return back;
	}
	
	//*******************************************ADMIN***********************************************
	@Autowired
	adminRepository ar; 
	@PostMapping("/loginAdmin")
	public LoginResponse adminAauth(@RequestBody UserLoginRequest adminLoginRequest) {
		Admins user = ar.findByEmailAndPassword(adminLoginRequest.getEmail(),
		adminLoginRequest.getPassword());
		System.out.println("user" + user);
//		System.out.println("user" + user.getEmail());
		LoginResponse back = new LoginResponse();

		if (user != null) {
			back.setStatus("Success");
			back.setName(user.getName());
			return back;
		} else {
			back.setStatus("Failed");
			return back;
		}
	}
	@PostMapping("/CreateAdmin")
	public @ResponseBody CreateUserResponce createadmin(@RequestBody UserRequest request) {

		Admins data = new Admins();
		data.setName(request.getName());
		data.setEmail(request.getEmail());
		data.setPassword(request.getPassword());
		data.setPhone(request.getPhoneno());
         ar.save(data);
		CreateUserResponce response = new CreateUserResponce();
		response.setMessage("User Is Created");
		response.setName(data.getName());
		return response;
	}

}
