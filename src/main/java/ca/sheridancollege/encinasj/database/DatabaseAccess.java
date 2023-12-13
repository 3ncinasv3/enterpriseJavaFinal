package ca.sheridancollege.encinasj.database;

import ca.sheridancollege.encinasj.beans.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DatabaseAccess {
  private final NamedParameterJdbcTemplate jdbc;

  public DatabaseAccess(NamedParameterJdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public List<Student> getStudentList() {
    MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    String query = "SELECT * FROM student ORDER BY name";
    return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<>(Student.class));
  }

  public void insertStudent(Student student) {
    MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    namedParameters.addValue("name", student.getName());
    String query = "INSERT INTO student(name) VALUES (:name)";
    jdbc.update(query, namedParameters);
  }

  public void deleteStudentById(Long id) {
    MapSqlParameterSource namedParameters = new MapSqlParameterSource();
    namedParameters.addValue("id", id);
    String query = "DELETE FROM student WHERE id = :id";
    jdbc.update(query, namedParameters);
  }
}
