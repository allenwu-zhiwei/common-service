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

    @PostMapping("/api/redis/{key}/{value}/{timeout}")
    public String save(@PathVariable("key") String var1, @PathVariable("value") String var2, @PathVariable("timeout") Integer var3);

    // Get value by key
    @GetMapping("/api/redis/{key}")
    public String get(@PathVariable("key") String var1);

    // Delete a key
    @DeleteMapping("/api/redis/{key}")
    public String delete(@PathVariable("key") String var1);

    // Check if key exists
    @GetMapping("/api/redis/exists/{key}")
    public String exists(@PathVariable("key") String var1);

}
