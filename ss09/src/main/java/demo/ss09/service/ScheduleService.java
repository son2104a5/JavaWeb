package demo.ss09.service;

import demo.ss09.model.Schedule;
import java.util.List;

public interface ScheduleService {
    List<Schedule> findAllScheduleByMovie(Long movieId);
}

