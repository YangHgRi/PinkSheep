package yanghgri.pinksheep.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yanghgri.pinksheep.entity.User;
import yanghgri.pinksheep.service.UserService;

@RestController
@Slf4j
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public User selectByPrimaryKey(Long userId) {
        return service.selectByPrimaryKey(userId);
    }
}
