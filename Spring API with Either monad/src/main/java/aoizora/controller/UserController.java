package aoizora.controller;

import aoizora.model.UserListRequest;
import aoizora.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController extends AbstractController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
            value = "/user",
            method = RequestMethod.GET)
    public ResponseEntity getAllUsers(UserListRequest request, Pageable pageable) {
        return userService.findAll(request, pageable).fold(
                this::toErrorResponse,
                this::toResponse);
    }
}
