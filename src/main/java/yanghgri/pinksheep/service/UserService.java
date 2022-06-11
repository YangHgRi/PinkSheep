package yanghgri.pinksheep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import yanghgri.pinksheep.entity.User;
import yanghgri.pinksheep.enums.StatusCode;
import yanghgri.pinksheep.mapper.UserMapper;

import java.util.Objects;

@Service
public class UserService {
    private final UserMapper mapper;
    private final RedisTemplate<String, Object> template;

    @Autowired
    public UserService(UserMapper mapper, RedisTemplate<String, Object> template) {
        this.mapper = mapper;
        this.template = template;
    }

    public User selectByPrimaryKey(Long userId) {
        return mapper.selectByPrimaryKey(userId);
    }

    public int signup(User user) {
        return mapper.signup(user);
    }

    public Number signin(String account, String password) {
        User user = mapper.selectByAccount(account);
        if (user == null) {
            return StatusCode.DATA_NOT_EXIST.NOT_EXIST_USER.getCode();
        }
        if (!Objects.equals(password, user.getPassword())) {
            return StatusCode.INVALID_PARAMETER.WRONG_USER_PASSWORD.getCode();
        }
        return user.getId();
    }

    public int signout(Long userId) {
        return 1;
    }
}
