package demo.ss09.controller;

import demo.ss09.model.Movie;
import demo.ss09.model.Schedule;
import demo.ss09.model.ScreenRoom;
import demo.ss09.service.MovieService;
import demo.ss09.service.ScheduleService;
import demo.ss09.service.ScreenRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.util.List;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

public class HomeController extends HttpServlet {
    @Autowired
    private MovieService movieService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ScreenRoomService screenRoomService;

    @GetMapping("/detailMovie")
    public String detail(@RequestParam("id") Long id, Model model) {
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);

        List<Schedule> schedules = scheduleService.findAllScheduleByMovie(id);
        model.addAttribute("schedules", schedules);

        List<ScreenRoom> screenRooms = screenRoomService.getAllScreenRooms();
        model.addAttribute("screenRooms", screenRooms);

        return "detailMovie";
    }

}