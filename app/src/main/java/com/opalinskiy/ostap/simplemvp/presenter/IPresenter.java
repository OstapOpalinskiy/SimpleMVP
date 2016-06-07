package com.opalinskiy.ostap.simplemvp.presenter;


public interface IPresenter {
    void onSave(String name, String email);
    void onFind(String id);
    void onDestroy();
}
