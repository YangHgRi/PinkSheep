package yanghgri.pinksheep.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @TableName user
 */
@Data
public class User implements Serializable {
    /**
     * 唯一主键,用户ID
     */
    private Long id;

    /**
     * 企业ID
     */
    private Long corpId;

    /**
     * 所属部门ID
     */
    private Long deptId;

    /**
     * 岗位职务ID
     */
    private Long postId;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户账号，登陆用
     */
    private String account;

    /**
     * 用户密码，登陆用
     */
    private String password;

    /**
     * 性别,1为男，0为女
     */
    private Boolean gender;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否已删除，已删除为1，未删除为0
     */
    private Boolean deleted;

    /**
     * 行创建者用户ID
     */
    private Long creatorId;

    /**
     * 行更新者用户ID
     */
    private Long updaterId;

    private static final long serialVersionUID = 1L;
}