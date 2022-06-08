package yanghgri.pinksheep.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("logon")
    public int logOn(@RequestBody User user) {
        log.info(user.toString());
        return 1;
//        return service.logon(user);
    }
}
