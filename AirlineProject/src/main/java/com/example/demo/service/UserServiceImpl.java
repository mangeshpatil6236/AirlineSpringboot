//package com.example.demo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.exception.InvalidCredetainalsException;
//import com.example.demo.model.User;
//import com.example.demo.repository.UserRepository;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private UserRepository userRepo;
//	
//	@Override
//	public boolean login(User user) {
//		// TODO Auto-generated method stub
//		
//		User dbUser = userRepo.findByUsernameAndPassword(
//				user.getUsername(),
//				user.getPassword()
//				);
//		
//		if(dbUser == null) {
//			throw new InvalidCredetainalsException("Invalid Username and Password");
//		}
//		
//		return dbUser != null;
//	}
//
//}
