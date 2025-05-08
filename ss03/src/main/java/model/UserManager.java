package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserManager {
    private List<User> userList = new ArrayList<>();
    private int idCounter = 1;

    public void addUser(String name, String email) {
        userList.add(new User(idCounter++, name, email));
    }

    public List<User> getUsers() {
        return userList;
    }

    public void removeUser(int id) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
}
