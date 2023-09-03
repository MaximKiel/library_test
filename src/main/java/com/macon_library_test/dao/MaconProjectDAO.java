package com.macon_library_test.dao;

import com.macon_library_test.model.MaconProject;
import com.macon_library_test.utul.SearchProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
                "INSERT INTO macon_project(number, title, country, region, city, client, segment, type, period) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)", project.getNumber(), project.getTitle(), project.getCountry(),
                project.getRegion(), project.getCity(), project.getClient(), project.getSegment(), project.getType(),
                project.getPeriod());
    }

    public List<MaconProject> findProject(SearchProject searchProject) {
        List<MaconProject> result =
                jdbcTemplate.query("SELECT * FROM macon_project", new BeanPropertyRowMapper<>(MaconProject.class));
        if (!searchProject.getNumber().equals("")) {
            result = result.stream().filter(p -> p.getNumber().equals(searchProject.getNumber())).collect(Collectors.toList());
        }
        if (!searchProject.getTitle().equals("")) {
            result = result.stream().filter(p -> p.getTitle().equals(searchProject.getTitle())).collect(Collectors.toList());
        }
        if (!searchProject.getCountry().equals("")) {
            result = result.stream().filter(p -> p.getCountry().equals(searchProject.getCountry())).collect(Collectors.toList());
        }
        if (!searchProject.getRegion().equals("")) {
            result = result.stream().filter(p -> p.getRegion().equals(searchProject.getRegion())).collect(Collectors.toList());
        }
        if (!searchProject.getCity().equals("")) {
            result = result.stream().filter(p -> p.getCity().equals(searchProject.getCity())).collect(Collectors.toList());
        }
        if (!searchProject.getClient().equals("")) {
            result = result.stream().filter(p -> p.getClient().equals(searchProject.getClient())).collect(Collectors.toList());
        }
        if (!searchProject.getSegment().equals("")) {
            result = result.stream().filter(p -> p.getSegment().equals(searchProject.getSegment())).collect(Collectors.toList());
        }
        if (!searchProject.getType().equals("")) {
            result = result.stream().filter(p -> p.getType().equals(searchProject.getType())).collect(Collectors.toList());
        }
        if (!searchProject.getPeriod().equals("")) {
            result = result.stream().filter(p -> p.getPeriod() == Integer.parseInt(searchProject.getPeriod())).collect(Collectors.toList());
        }
        return result;
    }

    public void update(int id, MaconProject updatedProject) {
        jdbcTemplate.update("UPDATE macon_project SET number=?, title=?, country=?, region=?, city=?, client=?," +
                        "segment=?, type=?, period=? WHERE id=?", updatedProject.getNumber(),
                updatedProject.getTitle(), updatedProject.getCountry(), updatedProject.getRegion(),
                updatedProject.getCity(), updatedProject.getClient(), updatedProject.getSegment(),
                updatedProject.getType(), updatedProject.getPeriod(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM macon_project WHERE id=?", id);
    }
}
