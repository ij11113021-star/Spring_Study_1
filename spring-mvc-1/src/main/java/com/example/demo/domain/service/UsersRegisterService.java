package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.example.demo.domain.entity.Users;
import com.example.demo.domain.model.UserForm;
import com.example.demo.domain.repository.UsersRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UsersRegisterService {

    @Autowired
    private UsersRepository usersRepository;

    public void register(final UserForm userForm) {
        Users entity = new Users();
        entity.setName(userForm.getName());
        entity.setEmail(userForm.getEmail());
        entity.setAge(userForm.getAge());
        entity.setNote(userForm.getNote());
        usersRepository.save(entity);
    }
    
    public boolean isValid(UserForm userForm,  BindingResult bindingResult) {
    	
    	 if(usersRepository.existsByEmail(userForm.getEmail())) {
    		 
    		 FieldError fieldError = new FieldError("userForm", "email", "既に登録されているE-Mailです。");
    		 bindingResult.addError(fieldError);
    		 	return true;
    		 	
    	 }
    	 return false;
    }
}
