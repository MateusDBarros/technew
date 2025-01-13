package com.example.technew.person.repository;

import com.example.technew.person.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {

    private final JdbcTemplate jdbc;


    public PersonRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void addNewPerson(Person person) {
        String sql = "INSERT INTO Persons (name, email) VALUES (?, ?)";
        jdbc.update(sql, person.getName(), person.getEmail());
    }

    public List<Person> getPerson() {
        String sql = "SELECT * FROM Persons";
        return jdbc.query(sql, (rs, rowNum) ->
                new Person(
                        rs.getInt("personID"),
                        rs.getString("name"),
                        rs.getString("email")
                )
        );
    }

    public void updatePerson(Person person) {
        String sql = "UPDATE SET name = ?, email = ?, WHERE personID = ?";
        jdbc.update(sql, person.getName(), person.getEmail(), person.getPersonID());
    }


    public void deletePerson(int id) {
        String sql = "DELETE FROM Persons WHERE personID = ?";
        jdbc.update(sql, id);
    }

    public boolean existById(int id) {
        String sql = "SELECT COUNT (*) FROM Persons WHERE personID = ?";
        Integer count = jdbc.queryForObject(sql, Integer.class, id);
        return count != null && count  > 0;
    }
}
