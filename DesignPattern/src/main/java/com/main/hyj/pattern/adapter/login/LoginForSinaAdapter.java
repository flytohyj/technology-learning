package com.main.hyj.pattern.adapter.login;

/**
 * create by flytohyj  2019/7/23
 **/
public class LoginForSinaAdapter implements LoginAdapter {

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForSinaAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
