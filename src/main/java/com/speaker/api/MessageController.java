package com.speaker.api;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.*;testDev
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import com.speaker.api.repository.*;
import com.speaker.api.repository.model.*;
import com.speaker.api.bean.*;
import com.speaker.api.util.*;

@RestController
public class MessageController {

	@Autowired
	@Qualifier("serviceFactory")
	private ServiceFactory serviceFactory;
	private static GeometryFactory geometryFactory = new GeometryFactory();

	@PreAuthorize("#oauth2.hasScope('read') and hasRole('ROLE_USER')")
	@RequestMapping("/api/messages/categories")
	public List<CategoryBean> getCategories(@RequestParam(value = "id", defaultValue = "1") String id) {
		List<Category> categories = new ArrayList();
		try {
			CategoryRepository categoryRepository = serviceFactory.getCategoryRepository();
			categories = categoryRepository.findAllCategories();
		} catch (Exception ex) {

		}
		List retList = new ArrayList();
		CategoryBean tempBean;
		for (Category category : categories) {
			tempBean = new CategoryBean();
			tempBean.setId(category.getId());
			tempBean.setCategory(category.getCategory());
			retList.add(tempBean);
		}

		return retList;
	}

	@RequestMapping(value = "/api/messages", method = RequestMethod.GET)
	public List<MessageBean> getMessages(@RequestParam(value = "id", defaultValue = "null") String id,
			@RequestParam(value = "lat", defaultValue = "null") String latitude,
			@RequestParam(value = "lng", defaultValue = "null") String longitude) {
		List<Message> messages = new ArrayList();
		try {
			MessageRepository messageRepository = serviceFactory.getMessageRepository();
			Point centerPointer = geometryFactory.createPoint(new Coordinate(Double.valueOf(longitude), Double.valueOf(latitude)));
			messages = messageRepository.findMessages(centerPointer, 500000000);
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		List retList = new ArrayList();
		MessageBean tempBean;
		for (Message message : messages) {
			tempBean = new MessageBean();
			tempBean.setId(message.getId());
			tempBean.setTitle(message.getTitle());
			tempBean.setCategory(message.getCategory());
			tempBean.setDescription(message.getDescription());
			tempBean.setExpiryDate(message.getExpiryDate());
			tempBean.setId(message.getId());
			tempBean.setHasImage(message.getHasImage());
			tempBean.setGeoLocation(message.getGeoLocation());
			tempBean.setDistance(message.getDistance());
			retList.add(tempBean);
		}

		return retList;
	}

	@RequestMapping(value = "/api/messages", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String createMessage(@RequestParam Map<String, String> body) {
		boolean hasImage = false;
		try {
			MessageRepository messageRepository = serviceFactory.getMessageRepository();
			Message newMessage = new Message();
			newMessage.setTitle(body.get("title"));
			newMessage.setDescription(body.get("description"));
			newMessage.setExpiryDate(Timestamp.valueOf(body.get("expiryDate")));
			newMessage.setCategory(Long.valueOf(body.get("category")));
			Point newPoint = geometryFactory.createPoint(
					new Coordinate(Double.valueOf(body.get("longitude")), Double.valueOf(body.get("latitude"))));
			newMessage.setGeoLocation(newPoint);
			if (body.get("image") != null && body.get("image").length() != 0) {
				hasImage = true;
				newMessage.setHasImage("true");

			}
			Message tempMessage = messageRepository.save(newMessage);
			if (hasImage) {
				byte[] imageBytes = DatatypeConverter
						.parseBase64Binary(body.get("image").split("^data:image/jpeg;base64,")[1]);
				FileHandler.saveFile(ApplicationSettings.get("messageimage.storepath"), tempMessage.getId() + ".jpg",
						imageBytes);
			}
			System.out.println(tempMessage.getId());
		} catch (Exception ex) {
			ex.printStackTrace();
			return "{statu:false}";

		}

		return "{status:true}";
	}

}