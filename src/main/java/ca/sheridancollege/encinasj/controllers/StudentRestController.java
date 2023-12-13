package ca.sheridancollege.encinasj.controllers;

import ca.sheridancollege.encinasj.beans.Student;
import ca.sheridancollege.encinasj.database.DatabaseAccess;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentRestController {
  private final DatabaseAccess da;

  public StudentRestController(DatabaseAccess da) {
    this.da = da;
  }

  @GetMapping
  public List<Student> getStudentCollection() {
    return da.getStudentList();
  }
}