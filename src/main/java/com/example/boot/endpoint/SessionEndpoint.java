package com.example.boot.endpoint;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viewer")
public class SessionEndpoint {
	
	@RequestMapping(method=RequestMethod.GET)
	public Map<String,Object> get(HttpSession session) throws Exception {
		//map session
		Map<String,Object> map = new HashMap<String,Object>();
		Enumeration<String> names = session.getAttributeNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			map.put(name, session.getAttribute(name));
		}//end while
		//return
		return map;
	}
	
}
