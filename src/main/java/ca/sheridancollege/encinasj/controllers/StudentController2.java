package ca.sheridancollege.encinasj.controllers;

import ca.sheridancollege.encinasj.beans.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
@Controller
public class StudentController2 {
  final String REST_URL = "http://localhost:8080/api/v1/students";

  @GetMapping("/hello")
  public String index2(Model model, RestTemplate restTemplate) {
    ResponseEntity<Student[]> responseEntity = restTemplate.getForEntity(REST_URL,
            Student[].class);
    model.addAttribute("student", new Student());
    model.addAttribute("studentList", responseEntity.getBody());
    return "index2";
  }
//@GetMapping("/hello")
//public String index2(Model model, RestTemplate restTemplate) {
//  try {
//    ResponseEntity<Student[]> responseEntity = restTemplate.getForEntity(REST_URL, Student[].class);
//    model.addAttribute("student", new Student());
//    // model.addAttribute("studentList", responseEntity.getBody());
//    return "index2";
//  } catch (HttpClientErrorException.Unauthorized e) {
//    // Log the error or print the details
//    e.printStackTrace();
//    return "index2"; // You can redirect to an error page or handle it accordingly
//  }
//}

}
