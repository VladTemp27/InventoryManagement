package com.example.inventorymanagement.util.requests;

import com.example.inventorymanagement.util.ClientCallback;
import com.example.inventorymanagement.util.exceptions.AlreadyLoggedInException;
import com.example.inventorymanagement.util.exceptions.NotLoggedInException;
import com.example.inventorymanagement.util.exceptions.OutOfRoleException;
import com.example.inventorymanagement.util.exceptions.UserExistenceException;
import com.example.inventorymanagement.util.objects.User;

import java.rmi.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public interface UserRequestInterface extends Remote{

    //Method to log the user in
    public void login(ClientCallback clientCallback)throws RemoteException, AlreadyLoggedInException, UserExistenceException;

    //Method to log the user out
    public void logout(ClientCallback clientCallback) throws RemoteException, NotLoggedInException;

    //Method to return LinkedList of users active
    public LinkedList<User> getActiveUser(ClientCallback clientCallback) throws OutOfRoleException, NotLoggedInException, RemoteException;

    //Method to add user
    public boolean addUser(ClientCallback clientCallback, User requestBy, User toAdd) throws OutOfRoleException, NotLoggedInException, RemoteException, UserExistenceException;

    //Method to remove user
    public boolean removeUser(ClientCallback clientCallback, User requestBy, User toRemove) throws OutOfRoleException, NotLoggedInException, RemoteException, UserExistenceException;

    //Method for changing the role of a user
    public boolean changeUserRole(ClientCallback clientCallback, User requestBy, User toChange) throws OutOfRoleException, NotLoggedInException, RemoteException, UserExistenceException;

    //Method for changing password
    public boolean changePassword(ClientCallback clientCallback, User requestBy, User toChange, String oldPassword) throws OutOfRoleException, NotLoggedInException, RemoteException, UserExistenceException;


}
