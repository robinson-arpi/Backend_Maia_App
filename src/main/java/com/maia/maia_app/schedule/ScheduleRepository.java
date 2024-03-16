package com.maia.maia_app.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class ScheduleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ScheduleResponse> getUserSchedule(Integer userId) {
        String sql = "SELECT h.schedule_id, c.subject_name, p.first_name AS ProfessorFirstName, p.last_name AS ProfessorLastName, " +
                "a.classroom_name, h.day, bh.start_time, bh.end_time " +
                "FROM Registrations r " +
                "INNER JOIN Schedules h ON r.subject_id = h.subject_id " +
                "INNER JOIN Subjects c ON h.subject_id = c.subject_id " +
                "INNER JOIN Users p ON h.user_id = p.user_id " +
                "INNER JOIN Classrooms a ON h.classroom_id = a.classroom_id " +
                "INNER JOIN TimeBlocks bh ON h.block_id = bh.block_id " +
                "WHERE r.user_id = ?";

        return jdbcTemplate.query(sql, new Object[]{userId}, new ScheduleResponseMapper());
    }

    private class ScheduleResponseMapper implements RowMapper<ScheduleResponse> {
        @Override
        public ScheduleResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
            ScheduleResponse response = new ScheduleResponse();

            response.setScheduleId(rs.getInt("schedule_id"));
            response.setClassName(rs.getString("subject_name"));
            response.setProfessorFirstName(rs.getString("ProfessorFirstName"));
            response.setProfessorLastName(rs.getString("ProfessorLastName"));
            response.setClassroomName(rs.getString("classroom_name"));
            response.setDay(rs.getString("day"));
            response.setStartTime(rs.getTime("start_time").toLocalTime());
            response.setEndTime(rs.getTime("end_time").toLocalTime());

            return response;
        }
    }
}