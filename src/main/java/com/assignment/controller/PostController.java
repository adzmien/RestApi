package com.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.ob.OBMessage;
import com.assignment.ob.OBPost;
import com.assignment.thirdparty.TypiCodeApi;

@RestController
public class PostController {
	
	@GetMapping("/post/getpost")
	public List<OBPost> GetAllPost(@RequestParam(value = "id", defaultValue = "") String id) {
		
		List<OBPost> result = new ArrayList<>();
		TypiCodeApi api = new TypiCodeApi();
		
		try {
			
			result = api.GetPost(id);
			return result;
		}
		
		catch(Exception ex) {
			
			OBPost obError = new OBPost();
			obError.setMessage("Something is not right : " + ex.getMessage());
			result.add(obError);
			return result;
		}
	}
	
	@PostMapping("/post/sendpost")
	public String SendPost(@RequestBody OBMessage ob) {
		
		
		try {
			
			return "Succesfully posted :  " +  ob.getSendMessage();
		}
		
		catch(Exception ex) {
			
			return "Something is wrong : " + ex.getMessage();
		}
		
	}
	
}
