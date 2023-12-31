package ca.sheridancollege.encinasj.controllers;

import ca.sheridancollege.encinasj.beans.Student;
import ca.sheridancollege.encinasj.database.DatabaseAccess;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
  private final DatabaseAccess da;

  public StudentController(DatabaseAccess da) {
    this.da = da;
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("student", new Student());
    model.addAttribute("studentList", da.getStudentList());
    return "index";
  }

  @PostMapping("/insertStudent")
  public String insertStudent(Model model, @ModelAttribute Student student) {
    model.addAttribute("student", new Student());
    da.insertStudent(student);
    model.addAttribute("studentList", da.getStudentList());
    return "index";
  }

  @PostMapping("/deleteStudentById/{id}")
  public String deleteStudentById(Model model, @PathVariable Long id) {
    model.addAttribute("student", new Student());
    da.deleteStudentById(id);
    model.addAttribute("studentList", da.getStudentList());
    return "index";
  }
}