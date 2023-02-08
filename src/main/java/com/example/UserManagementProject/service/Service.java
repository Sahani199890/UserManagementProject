package com.example.UserManagementProject.service;

import com.example.UserManagementProject.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@org.springframework.stereotype.Service
public class Service {
    private static List<Model> users=new ArrayList<>();
    private static int count=1;

    static {
        users.add(new Model(count++,"Abhishek","abhi","Jag","97486834"));
        users.add(new Model(count++,"sahani","sahani","kmr","384685"));
        users.add(new Model(count++,"ravindra","ravi","hmn","846598"));
        users.add(new Model(count++,"suresh","sahan","wrl","9723577"));
        users.add(new Model(count++,"sai","mani","krtl","236874"));

    }

    public static List<Model> findAll() { // Business Logic
        return users;
    }
    //
    public static Model findByUserId(int userId) {
//        Predicate<? super UserModel> predicate = user -> user.getUserId() == userId;
//        UserModel user = users.stream().filter(predicate).findFirst().get();
//        return user;
        for(Model u:users){
            if(u.getUserId()==userId) {
                return u;
            }
        }
        return null;
    }
    //
    public static void addUser(Model user) {
        users.add(user);
    }

    //
    public static void deleteUser(int userId) {

        Predicate<? super Model> predicate = user -> user.getUserId() == userId;
        users.removeIf(predicate);
    }

    public static void updateUser(int userId, Model newUser) {


        Model user=findByUserId(userId);// step 1

        user.setUserId(newUser.getUserId());
        user.setUserName(newUser.getUserName());
        user.setAddress(newUser.getAddress());
    }
}
