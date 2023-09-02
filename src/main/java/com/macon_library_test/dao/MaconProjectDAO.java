package com.macon_library_test.dao;

import com.macon_library_test.model.MaconProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MaconProjectDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MaconProjectDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MaconProject> index(){
        return jdbcTemplate.query("SELECT * FROM macon_project", new BeanPropertyRowMapper<>(MaconProject.class));
    }

    public MaconProject show(int id) {
        return jdbcTemplate.query("SELECT * FROM macon_project WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(MaconProject.class)).stream().findAny().orElse(null);
    }

    public void save(MaconProject project) {
        jdbcTemplate.update(
                "INSERT INTO macon_project(number, title, country, region, city, client, segment, period) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?)", project.getNumber(), project.getTitle(), project.getCountry(),
                project.getRegion(), project.getCity(), project.getClient(), project.getSegment(), project.getPeriod());
    }

    public void update(int id, MaconProject updatedProject) {
        jdbcTemplate.update("UPDATE macon_project SET number=?, title=?, country=?, region=?, city=?, client=?," +
                        "segment=?, period=? WHERE id=?", updatedProject.getNumber(),
                updatedProject.getTitle(), updatedProject.getCountry(), updatedProject.getRegion(),
                updatedProject.getCity(), updatedProject.getClient(), updatedProject.getSegment(),
                updatedProject.getPeriod(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM macon_project WHERE id=?", id);
    }
}
