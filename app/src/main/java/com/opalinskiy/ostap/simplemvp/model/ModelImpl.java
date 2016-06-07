package com.opalinskiy.ostap.simplemvp.model;

import android.content.Context;

import com.opalinskiy.ostap.simplemvp.DBUtils.DBManager;


public class ModelImpl implements IModel {

    private DBManager dbManager;

    public ModelImpl(Context context) {
        dbManager = new DBManager(context);
    }

    @Override
    public void saveUser(User user) {
       dbManager.writeUserToDb(user);
    }

    @Override
    public User findUser(String id) {
        return  dbManager.findUserById(id);
    }

    public void close() {
        dbManager.closeDatabase();
    }
}
