package project.seb39_main_043.schedule.service;

import org.springframework.stereotype.Service;
import project.seb39_main_043.schedule.entity.Schedule;

import java.util.List;

@Service
public class ScheduleService {

    public Schedule createSchedule(Schedule event) {

        Schedule createdEvent = event;
        return createdEvent;
    }

    public Schedule updateSchedule(Schedule schedule) {

        return null;
    }

    public Schedule findSchedule(long scheduleId) {

        return null;
    }

    public List<Schedule> findSchedules() {

        return null;
    }

    public void deleteSchedule(long scheduleId) {

    }
}
