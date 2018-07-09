package com.project.multi.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
@RequestMapping("/user")
public class LoginController {
    
	@ApiOperation(value = "user", nickname = "user",response = String.class)
    @ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found"), 
            @ApiResponse(code = 500, message = "Failure") 
            })
    @GetMapping("/me")
    public Principal user(Principal principal) {
        return principal;
    }
}
