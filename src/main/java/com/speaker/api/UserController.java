package com.speaker.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.speaker.api.repository.*;
import com.speaker.api.repository.model.*;
import com.speaker.api.bean.*;

@RestController
public class UserController {

	@Autowired
	@Qualifier("serviceFactory")
	private ServiceFactory serviceFactory;

	@RequestMapping(value = "/api/authentication", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public AuthenticationBean authticate(@RequestParam Map<String, String> body) {
		if (body.get("userName") == null || body.get("userName").length() == 0) {
			return new AuthenticationBean();
		}
		if (body.get("password") == null || body.get("password").length() == 0) {
			return new AuthenticationBean();
		}
		UserRepository userRepository = serviceFactory.getUserRepository();
		List<User> users = userRepository.authorize(body.get("userName"), body.get("password"));
		if (users.size() == 1) {
			if (users.get(0).getUserName().equals(body.get("userName"))) {
				return new AuthenticationBean(true);
			}
		} else {
			return new AuthenticationBean();
		}

		return new AuthenticationBean();
	}

}