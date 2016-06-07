package com.opalinskiy.ostap.simplemvp.presenter;

import android.content.Context;

import com.opalinskiy.ostap.simplemvp.view.IView;
import com.opalinskiy.ostap.simplemvp.model.User;
import com.opalinskiy.ostap.simplemvp.model.IModel;
import com.opalinskiy.ostap.simplemvp.model.ModelImpl;


public class PresenterImpl implements IPresenter {

    private IView view;
    private IModel model;

    public PresenterImpl(IView view, Context context) {
        this.model = new ModelImpl(context);
        this.view = view;
    }

    @Override
    public void onSave(String name, String email) {
        User user = new User(name, email);
        model.saveUser(user);
    }

    @Override
    public void onFind(String id) {
        User user = model.findUser(id);
        String msg;
        if (user != null) {
            msg = "user id: " + id + "\n"
                    + "name: " + user.getName() + "\n"
                    + "email: " + user.getEmail();
        } else {
            msg = "No such user!";
        }
        view.showUser(msg);
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
