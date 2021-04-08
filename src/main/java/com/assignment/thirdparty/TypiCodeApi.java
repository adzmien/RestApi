package com.assignment.thirdparty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.assignment.ob.OBPost;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TypiCodeApi {
	
	//should but in properties/db for easy maintenance
	final String uriGetPost = "https://jsonplaceholder.typicode.com/posts?id={id}";
	
	
	public List<OBPost> GetPost(String id) throws JsonProcessingException,JsonMappingException {
		
		List<OBPost> output = new ArrayList<>(); 
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> params = new HashMap<String, String>();
		String result = "";
		
		try {
			
			if(id != "") {
				
				params.put("id", id);
				result = restTemplate.getForObject(uriGetPost, String.class, params);
				         				
			}
			
			else {
				
				result = restTemplate.getForObject(uriGetPost, String.class);
			}
			
			if (result != "") {
				
				output = (List<OBPost>) objectMapper.readValue(result, new TypeReference<List<OBPost>>(){});
			}
			
			
			return output;
		}
		
		catch (JsonMappingException e) {
			
			e.printStackTrace();
			throw e;
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
			throw e;
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		}
	}
}
