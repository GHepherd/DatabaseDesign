package com.scau.entity.user.dto;

import lombok.Data;

/**
 * @author <a href="https://github.com/TennKane">gtkkang</a>
 */
@Data
public class UserRegisterDto {
    public String username;

    public String password;

    public String email;
}
