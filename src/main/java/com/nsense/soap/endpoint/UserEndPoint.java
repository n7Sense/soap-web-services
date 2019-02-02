package com.nsense.soap.endpoint;

import com.nsense.artifact.user.GetUserRequest;
import com.nsense.artifact.user.GetUserResponse;
import com.nsense.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndPoint {

    @Autowired
    private UserService userService;


    @PayloadRoot(namespace = "http://artifact.nsense.com/user",
            localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        return response;
    }
}
