package aoizora.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SecurityTestController {

    @GetMapping(value = "/admin")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getAdminResponse() {
        return new ResponseEntity<>("This is the admin response", HttpStatus.OK);
    }

    @GetMapping(value = "/user")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> getUserResponse(){
        return new ResponseEntity<>("This is the user response", HttpStatus.OK);
    }

    @GetMapping(value = "/general")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('USER') OR hasRole('ADMIN')")
    public ResponseEntity<String> getGeneralResponse(){
        return new ResponseEntity<>("This is the general response", HttpStatus.OK);
    }

    @GetMapping(value = "/postAuth/admin")
    @ResponseStatus(HttpStatus.OK)
    @PostAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> getPostAuthAdminResponse(){
        System.out.println("Inside the Get Response Method");
        return new ResponseEntity<>("This is the admin response", HttpStatus.OK);
    }
}
