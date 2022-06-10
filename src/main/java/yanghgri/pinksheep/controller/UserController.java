package yanghgri.pinksheep.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yanghgri.pinksheep.entity.User;
import yanghgri.pinksheep.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * 注册
     *
     * @param user 用户
     * @return int
     */
    @PostMapping("/signup")
    public int signup(@RequestBody User user) {
        return service.signup(user);
    }

    /**
     * 登录
     *
     * @param account  账户
     * @param password 密码
     * @return int
     */
    @PostMapping("/signin")
    public int signin(@RequestBody String account, @RequestBody String password, HttpServletResponse response) {
        Number res = service.signin(account, password);
        if (res instanceof Integer) {
            return 0;
        }
        response.setHeader("Auth", String.valueOf(res));
        return 1;
    }

    /**
     * 注销
     *
     * @param userId 用户id
     * @return int
     */
    @PostMapping("/signout")
    public int signout(@RequestBody Long userId) {
        return 1;
    }
}