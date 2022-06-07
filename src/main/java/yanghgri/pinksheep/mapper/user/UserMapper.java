package yanghgri.pinksheep.mapper.user;

import org.apache.ibatis.annotations.Mapper;
import yanghgri.pinksheep.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectAll();
}
