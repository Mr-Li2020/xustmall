package com.xustmall.service;

import com.xustmall.common.ServerResponse;
import com.xustmall.pojo.User;

/**
 * @Description: java类作用描述
 * @Author: liningbo
 * @CreateDate: 2018/12/31 17:55
 * @UpdateUser: liningbo
 * @UpdateDate: 2018/12/31 17:55
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface IUserService {
    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str,String type);

    ServerResponse<String> selectQuestion(String username);

    ServerResponse<String> checkAnswer(String username, String question, String answer);

    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);

    ServerResponse<String> resetPassword(String passwordOld, String passwordNew, User user);

    ServerResponse<User> updateInformation(User user);

    ServerResponse<User> getInformation(Integer userId);
}
