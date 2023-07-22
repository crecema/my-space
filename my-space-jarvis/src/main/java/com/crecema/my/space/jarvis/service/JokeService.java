package com.crecema.my.space.jarvis.service;

import com.crecema.my.space.jarvis.client.ApiSpaceClient;
import com.crecema.my.space.jarvis.domain.apispace.Joke;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JokeService {

    private final ApiSpaceClient apiSpaceClient;
    private final RedisTemplate<String, String> redisTemplate;

    public List<String> getJokes(int size) {
        List<Joke> jokes = apiSpaceClient.getJokesRandomly(20);

        redisTemplate.opsForHash().putAll("jokes", jokes.stream()
                .collect(Collectors.toMap(joke -> String.valueOf(joke.getId()), Joke::getContent)));

        return jokes.stream()
                .map(Joke::getContent)
                .toList().subList(0, size);
    }

}
