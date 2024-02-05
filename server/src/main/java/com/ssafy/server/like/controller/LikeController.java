package com.ssafy.server.like.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.ssafy.server.api.ApiResponse;
import com.ssafy.server.common.error.ApiException;
import com.ssafy.server.common.error.ApiExceptionFactory;
import com.ssafy.server.like.error.LikeExceptionEnum;
import com.ssafy.server.like.service.LikeService;
import com.ssafy.server.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private final LikeService likeService;

    @Autowired
    private final UserService userService;

    @Autowired
    public LikeController(LikeService likeService, UserService userService) {
        this.likeService = likeService;
        this.userService = userService;
    }

    /**
     * 테스트 용으로 작성해서 userPk를 주게 되어있음 UUID를 인자로 바꾸기
     * @param jsonNode
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Boolean>> create(@RequestBody JsonNode jsonNode) {
        int feedId = -1, userPk = -1;
        UUID userUUID = null;
        try {
            feedId = Integer.parseInt(jsonNode.get("feedId").asText());
            if(jsonNode.get("uuid") != null) {
                userUUID = UUID.fromString(jsonNode.get("uuid").asText());
                userPk = userService.getUserPk(userUUID);
            }
            else {
                userPk = Integer.parseInt(jsonNode.get("userPk").asText());
            }

            likeService.save(feedId, userPk);
        } catch(Exception e) {
            throw new ApiException(ApiExceptionFactory.fromExceptionEnum(LikeExceptionEnum.LIKE_CREATION_FAILED));
        }

        return new ResponseEntity<>(ApiResponse.success(true), HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete/{userPk}/{feedId}")
    public ResponseEntity<ApiResponse<Boolean>> delete(@PathVariable int userPk, @PathVariable int feedId) {
        try {
            likeService.delete(userPk, feedId);
        } catch(Exception e) {
            throw new ApiException(ApiExceptionFactory.fromExceptionEnum(LikeExceptionEnum.LIKE_DELETE_FAILED));
        }
        return new ResponseEntity<>(ApiResponse.success(true), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/{feedId}")
    public ResponseEntity<ApiResponse<Integer>> get(@PathVariable int feedId) {
        Integer count = Integer.MIN_VALUE;
        try {
            count = likeService.findAllByFeedId(feedId);
        } catch(Exception e) {
            throw new ApiException(ApiExceptionFactory.fromExceptionEnum(LikeExceptionEnum.LIKE_FETCH_ERROR));
        }
        return new ResponseEntity<>(ApiResponse.success(count), HttpStatus.ACCEPTED);
    }

}