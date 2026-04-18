package com.example.guchiBoard.controller;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.guchiBoard.dto.CalendarForm;
import com.example.guchiBoard.dto.MedicalCheckForm;
import com.example.guchiBoard.entity.Calendar;
import com.example.guchiBoard.entity.Post;
import com.example.guchiBoard.service.CalendarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class CalendarController {
	
	
	@Autowired
	private CalendarService calendarService;
	
	
	@GetMapping(value = "/calendar/calendar")
	public String newMedicalCheck(Model model) {
				System.out.println("test");
		return "calendar/calendar";
	}
	
	
	@GetMapping("/search")
	@ResponseBody
	public String search() {
		System.out.println("test /search call");
				String jsonData = null;
		
		List<Calendar> calendarAll = calendarService.findCalendar();
		
		List<CalendarForm> calendarList = new ArrayList<CalendarForm>();
		
				 for (Calendar calendar : calendarAll) { 
		  CalendarForm calendarForm = new CalendarForm(); 
		  calendarForm.setTitle(calendar.getTitle()); 
		  String startDay = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getStartDate());
		  calendarForm.setStart(startDay);
		  String endDay = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getEndDate());
		  calendarForm.setEnd(endDay); 
		  calendarForm.setDescription(calendar.getComment()); 
		  calendarList.add(calendarForm);
		  }
		 
		 
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		
		try {
			jsonData = mapper.writeValueAsString(calendarList);
			System.out.println(jsonData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return jsonData;
	}
	
	
	@PostMapping("/add")
	@ResponseBody
		public CalendarForm add(@RequestBody CalendarForm calendarForm) {
		System.out.println("add test");
		System.out.println(calendarForm);
		
				try {
			Calendar calendar = new Calendar();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date startdate = dateFormat.parse(calendarForm.getStart());
			calendar.setStartDate(startdate);
			Date enddate = dateFormat.parse(calendarForm.getEnd());
			calendar.setEndDate(enddate);
			calendar.setTitle(calendarForm.getTitle()); 
			calendar.setComment(calendarForm.getDescription());
			calendarService.addCalendar(calendar);
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
	    		return calendarForm;
	}
}