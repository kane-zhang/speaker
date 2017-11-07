package com.sample.speaker.api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.speaker.api.dao.*;
import com.sample.speaker.api.dao.model.*;

@RestController
public class MessageController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    

    @Autowired @Qualifier("serviceFactory") private ServiceFactory serviceFactory;    
    
    @RequestMapping("/messages/categories")
    public List<Greeting> greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	String resp;
    	 try {
    		  MessageDAO messageDAO = serviceFactory.getMessageDAO();
    	      Message msg = messageDAO.findById(1);
    	      resp = msg.getMessage();
    	    }
    	    catch (Exception ex) {
    	      resp = "not found";
    	    }
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, resp));
    }
}