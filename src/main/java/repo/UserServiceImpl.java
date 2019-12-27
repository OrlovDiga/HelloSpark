package repo;

import domain.User;
import domain.UserException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    Map<String, User> userMap;

    public UserServiceImpl() {
        this.userMap = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public Collection<User> getUsers() {
        return userMap.values();
    }

    @Override
    public User getUser(String id) {
        return userMap.get(id);
    }

    @Override
    public User editUser(User user) throws UserException {
        try {

            if (user.getId() == null)
                throw new UserException("ID cannot be blank");

            User toEdit = userMap.get(user.getId());

            if (toEdit == null)
                throw new UserException("User not found");

            if (user.getFirstName() != null) {
                toEdit.setFirstName(user.getFirstName());
            }

            if (user.getLastName() != null) {
                toEdit.setLastName(user.getLastName());
            }

            if (user.getEmail() != null) {
                toEdit.setEmail(user.getEmail());
            }

            return toEdit;
        } catch (Exception ex) {
            throw new UserException(ex.getMessage());
        }
    }

    @Override
    public void deleteUser(String id) {
        userMap.remove(id);
    }

    @Override
    public boolean userExist(String id) {
        return userMap.containsKey(id);
    }
}
