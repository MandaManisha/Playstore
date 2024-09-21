package com.store.services.imp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.store.customexception.InvalidUserInputException;
import com.store.customexception.UserAlreadyExistsException;
import com.store.customexception.UserNotFoundException;
import com.store.dto.UserDTO;
import com.store.entity.User;
import com.store.repository.UserRepository;
import com.store.services.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User createUser(User user) {

		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		validateUserInput(user); // Validate user input

		// Check if the email already exists
		if (userRepository.existsByEmail(user.getEmail())) {
			throw new UserAlreadyExistsException("User with this email already exists.");
		}

		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		validateUserInput(user); // Validate user input

		Long id = user.getId();
		User u = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id)); // Custom exception

		// Update user details
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		u.setEmail(user.getEmail());
		return userRepository.save(u);
	}

	@Override
	public String deleteUser(Long id) {
		if (!userRepository.existsById(id)) {
			throw new UserNotFoundException("User not found with id: " + id); // Custom exception
		}
		userRepository.deleteById(id);
		return "User deleted successfully.";
	}

	@Override
	public UserDTO GetUserData(Long ownerid) {
		User user = userRepository.findById(ownerid).get();
		UserDTO userDTO = mapper.map(user, UserDTO.class);
		return userDTO;
	}

	// Method to validate user input
	private void validateUserInput(User user) {

		if (!StringUtils.hasText(user.getEmail()) || !user.getEmail().contains("@")) {
			throw new InvalidUserInputException("Invalid email format.");
		}
		if (!StringUtils.hasText(user.getPassword()) || user.getPassword().length() < 6) {
			throw new InvalidUserInputException("Password must be at least 6 characters long.");
		}
	}
}
