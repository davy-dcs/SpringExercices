package com.insy2s.exercices.service;

import com.insy2s.exercices.domain.Address;
import com.insy2s.exercices.domain.Role;
import com.insy2s.exercices.domain.User;
import com.insy2s.exercices.repository.IAddressRepository;
import com.insy2s.exercices.repository.IRoleRepository;
import com.insy2s.exercices.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;
    private final IAddressRepository addressRepository;
    private final IRoleRepository roleRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    public void createUser(User user) {
        if (user.getAddress() != null) {
            Address address = user.getAddress();
            Optional<Address> existingAddress = addressRepository.findAddress(
                    address.getStreetNumber(), address.getStreetName(), address.getCity()
            );

            existingAddress.ifPresentOrElse(
                    foundAddress -> user.getAddress().setId(foundAddress.getId()),
                    () -> {addressRepository.save(address);}
            );
        }

        if(user.getRoles() != null) {
            List<Role> roles = user.getRoles();
            for (Role role : roles) {
                Role r = roleRepository.findByName(role.getName());
                role.setId(r.getId());
            }
        }

        userRepository.save(user);
    }

    public void updateUserLastName(Long id, String lastName) {
        Optional<User> existingUser = userRepository.findById(id);
        existingUser.ifPresent(user -> {
            if (lastName != null){
                user.setLastName(lastName);
            }
            userRepository.save(user);
        });
    }

    public void deleteUser(Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        existingUser.ifPresent(userRepository::delete);
        /*
        existingUser.ifPresent(user -> { userRepository.delete(user); });
         */
    }
}
