package com.mavs.reservationservice.client;

import com.mavs.reservationservice.client.dto.AuthenticationDto;
import com.mavs.reservationservice.client.dto.UserDto;
import com.mavs.reservationservice.config.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service")
@RibbonClient(name = "user-service", configuration = RibbonConfiguration.class)
public interface UserClient {

    @PostMapping("/auth/login")
    String authenticateUserUser(@RequestBody AuthenticationDto authenticationDto);

    @GetMapping("/api/v1/users/{id}")
    UserDto findUserById(@PathVariable("id") Integer id);

    @GetMapping("/api/v1/users/username/{username}")
    UserDto findUserByName(@PathVariable("username") String username);
}