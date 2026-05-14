package Attendance.example.Attendance_Management_System.Controller;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @GetMapping("/status")
    public String status() {
        return "Attendance Service Running";
    }

    @PostMapping("/checkin")
    public String checkin() {
        return "Check-in Successful";
    }



}
