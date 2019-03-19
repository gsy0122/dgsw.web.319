package kr.hs.dgsw.web_319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user")
    @ResponseBody
    public List<User> list() {
      return userService.list();
    }
    @GetMapping("/user/{id}")
    @ResponseBody
    public User view(@PathVariable String id) {
        return userService.view(id);
    }
    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user) {
        return userService.add(user);
    }
    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean delete(@PathVariable String id) {
        return userService.delete(id);
    }
}
// CRUD Create  Read    Update  Delete
// SQL  insert  select  update  delete
// HTTP POST    GET     PUT     DELETE