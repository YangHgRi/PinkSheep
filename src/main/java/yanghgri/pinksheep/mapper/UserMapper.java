package yanghgri.pinksheep.mapper;

import org.apache.ibatis.annotations.Mapper;
import yanghgri.pinksheep.entity.User;

/**
 * @author YangHgRi
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2022-06-07 22:10:09
 * @Entity yanghgri.pinksheep.entity.User
 */
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
