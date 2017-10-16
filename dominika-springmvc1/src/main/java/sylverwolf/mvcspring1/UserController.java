package sylverwolf.mvcspring1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sylverwolf.mvcspring1.converters.UserConverter;
import sylverwolf.mvcspring1.entity.*;
import sylverwolf.mvcspring1.models.UserVm;
import sylverwolf.mvcspring1.repository.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by szkolenia on 2017-07-07.
 */
@Controller
public class UserController {

    @Autowired
    UserRepository userrepository;

    @GetMapping("/home")
    public String savePage(Model model) {

        System.out.println("USERS: " + userrepository.findAll());

        Set<UserVm> users = new LinkedHashSet<UserVm>();
        for (User u : userrepository.findAll()) {
            users.add(UserConverter.convertToVm(u));
        }

        model.addAttribute("users", users);
        model.addAttribute("user", new UserVm());

        return "home";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") UserVm user,
                           final RedirectAttributes redirectAttributes) {

        userrepository.save(UserConverter.convertToEntity(user));

        redirectAttributes.addFlashAttribute("saveUser", "success");


        return "redirect:/home";
    }

    @RequestMapping(value = "/{operation}/{userId}", method = RequestMethod.GET)
    public String editRemoveUser(@PathVariable("operation") String operation,
                                 @PathVariable("userId") Integer userId, final RedirectAttributes redirectAttributes,
                                 Model model) {
        if (operation.equals("delete")) {
            userrepository.delete(userId);
            redirectAttributes.addFlashAttribute("deletion", "success");
        } else if (operation.equals("edit")) {

            User us = userrepository.findOne(userId);
            UserVm vm = UserConverter.convertToVm(us);
            if (vm != null) {
                model.addAttribute("editUser", vm);
                    return "editPage";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        } else if (operation.equals("read")) {
            Set<UserVm> users2 = new LinkedHashSet<UserVm>();
            User us = userrepository.findOne(userId);
            users2.add(UserConverter.convertToVm(us));

            if (us != null) {
                model.addAttribute("readUser", users2);
                model.addAttribute("oneUser", userrepository.findOne(userId));
                return "viewPage";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }

        return "redirect:/home";
    }

    @RequestMapping(value = "/editPage", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute UserVm editUser,
                             final RedirectAttributes redirectAttributes) {
        userrepository.save(UserConverter.convertToEntity(editUser));

        redirectAttributes.addFlashAttribute("edit", "success");

        return "redirect:/home";
    }

    @GetMapping("/viewPage")
    public String viewPage(Model model) {
        model.addAttribute("user", new UserVm());

        return "viewPage";
    }


}
