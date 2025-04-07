package com.scau.entity.user.vo;

import lombok.Data;

/**
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@Data
public class UserLoginVo {
    /**
     * token
     */
    private String token;
    /**
     * 用户id
     */
    private String userId;
}
