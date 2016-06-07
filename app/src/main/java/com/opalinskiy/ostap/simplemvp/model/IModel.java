package com.opalinskiy.ostap.simplemvp.model;


public interface IModel {
    void saveUser(User user);
    User findUser(String id);
}
