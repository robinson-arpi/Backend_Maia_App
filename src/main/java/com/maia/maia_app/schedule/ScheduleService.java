package com.maia.maia_app.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<ScheduleResponse> getUserSchedule(Integer userId) {
        return scheduleRepository.getUserSchedule(userId);
    }
}