package com.example.switer.controller;

import com.example.switer.form.UserForm;
import com.example.switer.model.User;
import com.example.switer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(path = "/demo")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/formAddUser"}, method = RequestMethod.GET)
    public /*@ResponseBody*/ String formNewUser(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        model.addAttribute("errorMessage", errorMessage);
        return "/user/formAddUser";
    }

    @PostMapping(path = "/formAddUser")
    public /*@ResponseBody*/ String addNewUser(Model model, @ModelAttribute("/user/userForm") UserForm userForm) {
        String name = userForm.getName();
        String email = userForm.getEmail();

        if (name != null && name.length() > 0 && email != null && email.length() > 0) {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            userRepository.save(user);
            model.addAttribute("name", name);
            return "/user/okAddUser";
        }
//        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        model.addAttribute("errorMessage", errorMessage);
        return "/user/formAddUser";
    }

    @GetMapping(path = "/listUser")
    public String getAllUsers(Map<String, Object> model) {
        Iterable<User> users = userRepository.findAll();
        model.put("users", users);
        return "/user/listUser";
    }
/*
    @GetMapping(path = "/listUser")
    public String userListArray(Model model) {
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User("Tom", "1@re") );
        userList.add(new User("Tom1", "2@re") );
        model.addAttribute("users", userList);
        return "listUser";
    }
*/

    @PostMapping(path = "/filter")
    public String getFilterUsers(@RequestParam String filterStr, Map<String, Object> model) {
        Iterable<User> users;
        if(filterStr != null && !filterStr.isEmpty()){
            users = userRepository.findByName(filterStr);
        }else {
            users = userRepository.findAll();
        }
        model.put("users", users);
        return "/user/listUser";
    }
}
