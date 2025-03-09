package com.bangvan.efyp.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
@Tag(name = "Hello World", description = "Hello World")
public class HelloWorldController {

    @Operation(summary = "Hello World", description = "Hello World")
    @GetMapping()
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
