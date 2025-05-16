package demo.ss09.dao;

import demo.ss09.model.Schedule;
import java.util.List;

public interface ScheduleDAO {
    List<Schedule> findAllScheduleByMovie(Long movieId);
}
