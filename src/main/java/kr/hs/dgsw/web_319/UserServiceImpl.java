package kr.hs.dgsw.web_319;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    List<User> userList;
    public UserServiceImpl() {
        userList = new ArrayList<>();
        userList.add(new User("user1", "강서연", "user111@dgsw"));
        userList.add(new User("user2", "강서", "user222@dgsw"));
        userList.add(new User("user3", "서연","user333@dgsw"));
    }
    @Override
    public List<User> list() {
        return userList;
    }
    @Override
    public User view(String id) { // Java 8+
        User user = userList.stream()
                .filter(found -> found.getId().equals(id))
                .findAny()
                .orElse(null);
        return user;
    }

    @Override
    public boolean add(User user) {
        User found = view(user.getId());
        if (found == null)
            return userList.add(user);
        return false;
    }

    @Override
    public User update(User user) {
        User found = view(user.getId());
        if (found != null) {
            found.setName(user.getName());
            found.setEmail(user.getEmail());
        }
        return found;
    }

    @Override
    public boolean delete(String id) {
        User found = view(id);
        return userList.remove(found);
    }

    public User find1(String name) {
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if (user.getName().equals(name)) return user;
        }
        return null;
    }
    public User find2(String name) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getName().equals(name)) return user;
        }
        return null;
    }
    public User find3(String name) { // Java 5+
        for (User user : userList) {
            if (user.getName().equals(name)) return user;
        }
        return null;
    }
}
