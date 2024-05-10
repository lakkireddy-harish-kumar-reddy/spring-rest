package com.in28mins.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	static{
		users.add(new User(1,"Harish",LocalDate.now().minusYears(30)));
		users.add(new User(2,"Ganesh",LocalDate.now().minusYears(31)));
		users.add(new User(3,"Gayathri",LocalDate.now().minusYears(31)));
	}
	
	public List<User> findAll(){
		return users;
	}

	public User findOne(Integer id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
		}

	public User saveUser(User user) {
		user.setId(users.size()+1);
		users.add(user);
		return user;
	}
	public void deleteById(Integer id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
		}
}
