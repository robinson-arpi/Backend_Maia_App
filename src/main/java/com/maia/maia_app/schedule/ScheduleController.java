package com.maia.maia_app.schedule;

import com.maia.maia_app.schedule.Model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<ScheduleResponse>> getUserSchedule(@PathVariable Integer userId) {
        List<ScheduleResponse> schedules = scheduleService.getUserSchedule(userId);

        if (schedules.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }
}