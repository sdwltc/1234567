package com.example.mybatisplus_news_system.controller;

import com.example.mybatisplus_news_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.mybatisplus_news_system.entity.User;

@RestController//这意味着这是个controller类，且其中的方法都是返回json格式的数据
@RequestMapping("api/users")//这是一个请求路径，即api/users，是我自定义的，无关其他
//如果某个控制器类上标注了 @RequestMapping("/api/users")，那么这个控制器类中的方法将处理发送到 http://localhost:8080/api/users 的 HTTP 请求.
public class UsersController
{
    private final UserService userService;
    @Autowired
    public UsersController(UserService userService)
    {
        this.userService = userService;
    }

    //处理用户 POST 请求，即用户注册
    //这里的 @PostMapping("/register") 是一个自定义的请求路径，无关其他
    //register" 是自定义的路径。这意味着当一个 HTTP POST 请求被发送到这个路径时，对应的方法（registerUser）将被调用。
    @PostMapping("/register")
    //ResponseEntity 是一个Spring类，它代表整个 HTTP 响应，因此你可以使用它来定制 HTTP 响应的任何内容。
    //<?> “?” 是一个通配符，表示ResponseEntity可以 包含任何类型的数据
    public ResponseEntity<?> registerUser(@RequestBody User user)//@RequestBody 用于自动将 HTTP 请求的内容（JSON 格式）转换为一个 User 对象
    {
        //调用userService中的register方法，即用户注册
        //不用 Impl，因为 controller 直接与 service 交互， service 再用 impl，不直接用Impl
        userService.register(user);
        //返回一个ResponseEntity，即返回一个HTTP响应
        return ResponseEntity.ok("User registered successfully");
        /*return ResponseEntity.ok().build();也是一种写法，但是这种写法不会返回任何数据，只是返回一个HTTP响应，即返回一个状态码，状态码是200，表示成功*/
    }

    //处理用户 PUT 请求，即用户个人信息更改，PUT请求是更新资源，POST请求是创建资源
    //这里的 @PutMapping("/{id}") 是一个自定义的请求路径，id是占位符，这个部分会被实际的值替换
    // 例如，如果有一个请求发送到 /api/users/123，那么 {id} 将被替换为 123
    @PutMapping("/{id}")//@PutMapping 是一种组合注解，它是 @RequestMapping 的特定变体，用于处理 HTTP PUT 请求,PUT 请求通常用于更新资源。
    // @PutMapping("/{id}") 不用写 user/{id}，因为@RequesMapping定义了 controller 的路径，即api/users
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user)//@PathVariable 用于将请求路径中的值绑定到方法参数上,即将id绑定到方法参数上
    {
        //调用userService中的updateUserById方法，即用户个人信息更改，根据id更改
        userService.updateUserById(id,user);
        //返回一个ResponseEntity，即返回一个HTTP响应
        return ResponseEntity.ok("User updated successfully");
    }


}
