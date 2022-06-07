package yanghgri.pinksheep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yanghgri.pinksheep.entity.User;
import yanghgri.pinksheep.mapper.UserMapper;

@Service
public class UserService {
    private final UserMapper mapper;

    @Autowired
    public UserService(UserMapper mapper) {
        this.mapper = mapper;
    }

    public User selectByPrimaryKey(Long userId) {
        return mapper.selectByPrimaryKey(userId);
    }
}
