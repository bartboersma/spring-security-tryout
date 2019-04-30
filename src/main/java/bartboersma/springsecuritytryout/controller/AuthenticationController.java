package bartboersma.springsecuritytryout.controller;

import bartboersma.springsecuritytryout.model.User;
import bartboersma.springsecuritytryout.model.UserPrincipal;
import bartboersma.springsecuritytryout.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api")
public class AuthenticationController {

    @Autowired
    RegisterService registerService;

    @Autowired
    DaoAuthenticationProvider daoAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody User inlogData) {
        Authentication authentication = daoAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(inlogData.getUsername(), inlogData.getPassword()));
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        return ResponseEntity.ok("Logged in user: " + userPrincipal.getUsername());
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user) {
        registerService.register(user);

        return null;
    }
}
