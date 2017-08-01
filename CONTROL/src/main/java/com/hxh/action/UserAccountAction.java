package com.hxh.action;


import com.hxh.model.TbUserAccount;
import com.hxh.services.TbUserAccount.TbUserAccountService;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2015/4/2.
 */
public class UserAccountAction extends BaseAction {


    private HttpServletRequest request = null;
    private HttpServletResponse response = null;

    private TbUserAccountService tbUserAccountService = null;

    public void setTbUserAccountService(TbUserAccountService tbUserAccountService) {
        this.tbUserAccountService = tbUserAccountService;
    }

    /**
     * 获得用户账户信息
     * @return
     */
    public String getUserAccount() {
        request = getRequest();
        response = getResponse();

        JSONObject result = new JSONObject();

        try {
            String userId = request.getParameter("userId");
            TbUserAccount tbUserAccount = tbUserAccountService.queryById(userId);
            result.put("tbUserAccount",tbUserAccount);

            print(response, result.toString());
        } catch (Exception e) {
            // 查询失败
            try {
                result.put("resultCode",3);
                print(response, result.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 更新用户账户状态
     * @return
     */
    public String updateAccountStatus() {
        request = getRequest();
        response = getResponse();
        JSONObject result = new JSONObject();

        try {
            String accountId = request.getParameter("accountId");
            String accountStatus = request.getParameter("accountStatus");

            TbUserAccount tbUserAccount = new TbUserAccount();
            tbUserAccount.setAccountId(Integer.parseInt(accountId));
            tbUserAccount.setAccountStatus(Integer.parseInt(accountStatus));

            boolean isUpdated = tbUserAccountService.update(tbUserAccount);

            if (isUpdated) {
                // 更新成功
                result.put("resultCode",1);
            } else {
                // 更新失败
                result.put("resultCode",2);
            }

            print(response, result.toString());
        } catch (Exception e) {
            // 更新失败
            try {
                result.put("resultCode",3);
                print(response, result.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }


}
