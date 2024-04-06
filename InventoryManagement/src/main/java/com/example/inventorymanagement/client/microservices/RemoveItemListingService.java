package com.example.inventorymanagement.client.microservices;

import com.example.inventorymanagement.client.model.ClientCallbackImpl;
import com.example.inventorymanagement.util.ClientCallback;
import com.example.inventorymanagement.util.exceptions.NotLoggedInException;
import com.example.inventorymanagement.util.exceptions.OutOfRoleException;
import com.example.inventorymanagement.util.objects.Item;
import com.example.inventorymanagement.util.objects.User;
import com.example.inventorymanagement.util.requests.ItemRequestInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoveItemListingService {
    public boolean process (User requestBy, Item item){
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            ItemRequestInterface ItemRequest = (ItemRequestInterface) registry.lookup("item");

            ClientCallback cB = new ClientCallbackImpl(requestBy);

            return ItemRequest.removeItemListing(cB,item);

        } catch (NotBoundException | RemoteException | NotLoggedInException | OutOfRoleException e) {
            throw new RuntimeException(e);
        }
    }
}