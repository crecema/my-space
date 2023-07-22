package com.crecema.my.space.jarvis.controller;

import com.crecema.my.space.common.CommonResponse;
import com.crecema.my.space.jarvis.service.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/space")
@RequiredArgsConstructor
public class ApiSpaceController {

    private final JokeService jokeService;

    @RequestMapping("/jokes/{size}")
    public CommonResponse<List<String>> jokes(@PathVariable Integer size) {
        return CommonResponse.success(jokeService.getJokes(size));
    }

}
