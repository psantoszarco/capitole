package com.project.multi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.multi.entities.Users;
import com.project.multi.json.ResultUserJson;
import com.project.multi.json.UsuarioJson;
import com.project.multi.repository.UsersRepository;
import com.project.multi.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UsersRepository usersRepository;
	
	 @ApiOperation(value = "signUp", nickname = "signUp",response = String.class)
	    @ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success", response = String.class),
	            @ApiResponse(code = 400, message = "Bad Request"),
	            @ApiResponse(code = 404, message = "Not Found"), 
	            @ApiResponse(code = 500, message = "Failure") 
	            })
    @PostMapping("/new")
    public void signUp(@RequestBody Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
    }
    
    @ApiOperation(value = "getAllUsers", nickname = "getAllUsers",response = String.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 500, message = "Failure") 
            })
    @ResponseStatus(HttpStatus.OK)
	@GetMapping("/user-list")
	@ResponseBody
	public ResultUserJson getAllUsers() {
		
		ResultUserJson result = new ResultUserJson();
		List<Users> usuarios = usersRepository.findAll();
		List<UsuarioJson> lstUsers = usuarios.stream().map(obj -> {
			UsuarioJson json = new UsuarioJson();
			json.setNombre(obj.getUserName());
			json.setId(obj.getId());
			json.setActivo(true);
			return json;
        }).collect(Collectors.toList());
		result.setCode(Constants.CODE_200);
		result.setStatus(Constants.SUCCESS);
		result.setMessage(String.format("Se han recuperado %s usuarios",lstUsers.size()));
		result.setLstUsuarios(lstUsers);
		return result;
	}
}
