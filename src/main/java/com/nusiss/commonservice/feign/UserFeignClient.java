package com.nusiss.commonservice.feign;

import com.nusiss.commonservice.config.ApiResponse;
import com.nusiss.commonservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service")
public interface UserFeignClient {

    @GetMapping("/api/user/{id}")
    ResponseEntity<ApiResponse<User>> getUserById(@PathVariable("id") Integer id);


    @RequestMapping(value = "/getCurrentUserInfo", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<User>> getCurrentUserInfo(@RequestHeader("authToken") String authToken);

}
