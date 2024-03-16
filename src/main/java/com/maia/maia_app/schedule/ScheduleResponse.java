package com.maia.maia_app.schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponse {
    private Integer scheduleId;
    private String className;
    private String professorFirstName;
    private String professorLastName;
    private String classroomName;
    private String day;
    private LocalTime startTime;
    private LocalTime endTime;
}
