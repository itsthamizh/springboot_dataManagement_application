package com.example.demo.Controller;

import com.example.demo.Model.DatabaseFile;
import com.example.demo.Service.DatabaseFileServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class FogController {


    @Autowired
    private DatabaseFileServiceInter databaseFileServiceInter;



    //This for index page
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Registration_Index");
        return modelAndView;
    }




    //This for Staff's Login
    @RequestMapping(value = "/staffLogin", method = RequestMethod.GET)
    public ModelAndView staffLogin() {
        ModelAndView modelAndView = new ModelAndView("staff_Login");
        return modelAndView;
    }

    //This for Student's Login
    @RequestMapping(value = "/studentLogin", method = RequestMethod.GET)
    public ModelAndView studentLogin() {
        ModelAndView modelAndView = new ModelAndView("student_Login");
        return modelAndView;
    }




    //This for Staff's Registration
    @RequestMapping(value = "/staffReg", method = RequestMethod.GET)
    public ModelAndView staffReg() {
        ModelAndView modelAndView = new ModelAndView("staff_Registration");
        return modelAndView;
    }

    //This for Student's Registration
    @RequestMapping(value = "/studentReg", method = RequestMethod.GET)
    public ModelAndView studentReg() {
        ModelAndView modelAndView = new ModelAndView("student_registration");
        return modelAndView;
    }





    //This for Student's Registration
    @RequestMapping(value = "/staffUpload", method = RequestMethod.GET)
    public ModelAndView staffUpload() {
        ModelAndView modelAndView = new ModelAndView("staffUpload");
        return modelAndView;
    }


    @RequestMapping(value = "/StudentDownload", method = RequestMethod.GET)
    public ModelAndView message() {
        ModelAndView mav = new ModelAndView("/Student_Download");
        mav.addObject("databasefiles", databaseFileServiceInter.findAll());
        return mav;
    }
    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String messages(Model model) {
        model.addAttribute("databasefiles", databaseFileServiceInter.findAll());
        return "/reg/Student_Download";
    }

    @ModelAttribute("/StudentDownload")
    public List<DatabaseFile> messages() {
        return databaseFileServiceInter.findAll();
    }


}
