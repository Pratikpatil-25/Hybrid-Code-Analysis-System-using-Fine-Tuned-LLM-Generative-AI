package com.theplanners.pkiclassroomrescheduler.system.Controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theplanners.pkiclassroomrescheduler.system.Entities.ClassroomList;
import com.theplanners.pkiclassroomrescheduler.system.Entities.Schedule;
import com.theplanners.pkiclassroomrescheduler.system.Entities.Section;
import com.theplanners.pkiclassroomrescheduler.system.Entities.Result;
import com.theplanners.pkiclassroomrescheduler.system.Utilites.Algorithm;

@RestController
@RequestMapping("/api")
public class AlgorithmController {

    
    private final Schedule schedule;
    
    private final ClassroomList classroomList;

    
    public AlgorithmController(Schedule schedule, ClassroomList classroomList) {
        this.schedule = schedule;
        this.classroomList = classroomList;
    }

    
    @GetMapping("/algorithm")
    public ArrayList<String> runAlgorithm(@RequestParam String classSection, @RequestParam int newSize){

        String[] courseSection = classSection.split("-");
        for(int i = 0 ; i < courseSection.length ; i++){
            courseSection[i] = courseSection[i].trim();
        }
        Section result = null;
        for(Section section : schedule.returnSchedule()){
            if(section.getCourse().equals(courseSection[0]) && section.getSectionNumber() == Integer.parseInt(courseSection[1].replaceAll("[^\\d.]", ""))){
                result = section;
                break;
            }
        }

        try {
            ArrayList<Result> resultArr = Algorithm.doAlgorithm(result, newSize, schedule, classroomList);
            ArrayList<String> stringArr = new ArrayList<String>();
                                    for (int i = resultArr.size() - 1; i >= 0; i--) {
                Result resultObj = resultArr.get(i);
                stringArr.add(resultObj.toString());
                            }
            return stringArr;
        } catch(Exception e) {
                        ArrayList<String> stringArr = new ArrayList<String>();
            stringArr.add("Class could not be rescheduled. There are no classrooms that fit the new maximum enrollment. The best option is likely to create a new section.");
            return stringArr;
        }
    }
}