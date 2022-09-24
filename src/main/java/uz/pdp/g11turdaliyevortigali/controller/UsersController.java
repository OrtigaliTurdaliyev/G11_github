package uz.pdp.g11turdaliyevortigali.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.g11turdaliyevortigali.dao.UsersDao;
import uz.pdp.g11turdaliyevortigali.model.Users;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersDao usersDao;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", usersDao.getAllUsersFromDb());
        return "show-users";
    }

    @GetMapping("/get-form")
    public String getUsersForm() {
        return "add-users-from";
    }

    @SneakyThrows
    @PostMapping
    public String addNewUsers(Users users) {
        try {
            usersDao.addNewUsers(users);
            return "redirect:/users";
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalAccessException("Xatolik yuz berdi....");
        }
    }

    @GetMapping("/edit/{id}")
    public String editUsers(@PathVariable Integer id, Model model) {

        model.addAttribute("users", usersDao.getUsersById(id));
        return "edit-users-from";
    }

    @SneakyThrows
    @PostMapping("/edit")
    public String editUsers(Users users) {
        try {
            usersDao.editUsers(users);
            return "redirect:/users";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteUsers(@PathVariable Integer id)  {
        try {
            usersDao.deleteUsers(id);
            return "redirect:/users";
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


}
