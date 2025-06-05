package com.data.controller;

import com.data.model.ScreenRoom;
import com.data.model.Theater;
import com.data.service.ScreenRoomService;
import com.data.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/screen-rooms")
public class ScreenRoomController {

    @Autowired
    private TheaterService theaterService;

    @Autowired
    private ScreenRoomService screenRoomService;

    @GetMapping
    public String listScreenRooms(Model model) {
        List<ScreenRoom> rooms = screenRoomService.getActiveScreenRooms();
        model.addAttribute("screenRooms", rooms);
        return "screen-room/list";
    }

    // Form thêm mới
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("screenRoom", new ScreenRoom());
        model.addAttribute("theaters", theaterService.getAllTheaters());
        return "screen-room/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("screenRoom") @Valid ScreenRoom screenRoom,
                       BindingResult result,
                       @RequestParam("theaterId") Long theaterId,
                       Model model) {

        if (result.hasErrors()) {
            model.addAttribute("theaters", theaterService.getAllTheaters());
            return "screen-room/add";
        }

        Theater theater = theaterService.getTheaterById(theaterId);
        screenRoom.setTheater(theater);
        screenRoomService.addScreenRoomWithSeat(screenRoom);

        return "redirect:/screen-rooms";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        ScreenRoom room = screenRoomService.getScreenRoomById(id);
        model.addAttribute("screenRoom", room);
        model.addAttribute("theaters", theaterService.getAllTheaters());
        return "screen-room/edit";
    }

    // Xử lý sửa
    @PostMapping("/edit")
    public String update(@ModelAttribute("screenRoom") @Valid ScreenRoom screenRoom,
                         BindingResult result,
                         @RequestParam("theaterId") Long theaterId,
                         Model model) {

        if (result.hasErrors()) {
            model.addAttribute("theaters", theaterService.getAllTheaters());
            return "screen-room/edit";
        }

        Theater theater = theaterService.getTheaterById(theaterId);
        screenRoom.setTheater(theater);
        screenRoomService.updateScreenRoom(screenRoom);

        return "redirect:/screen-rooms";
    }
}
