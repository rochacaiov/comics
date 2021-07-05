package io.codigorocha.comics.adapter.controller;

import io.codigorocha.comics.domain.dto.UserCreateDTO;
import io.codigorocha.comics.domain.dto.UserResponseDTO;
import io.codigorocha.comics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}", produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponseDTO> findById(@PathVariable("id") @NotBlank Long id) {
        final var userResponse = userService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userResponse);
    }

    @PostMapping(consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponseDTO> create(@Valid @RequestBody UserCreateDTO createDTO) {
        final var createdUser = userService.create(createDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUser);
    }

/*
    @GetMapping("/signin")
    public ModelAndView signIn() {
        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("signin");
        return modelAndView;
    }

    @GetMapping("/signup")
    public ModelAndView signUp() {
        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("signup");
        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @PostMapping("/signup")
    public String signUp(@Valid @ModelAttribute User user, BindingResult result, RedirectAttributes redirectAttributes) {
        //return "redirect:signin";
        return userService.signUp(user, result, redirectAttributes);


//        if(result.hasErrors()) {
//            System.out.println("TEVE ERRO NESSA PORRA AIO EIN");
//            return "signup";
//        }
//
////        this.userRepository.save(user);
//        System.out.println(user.getName());
//        System.out.println(user.getEmail());
//        return "redirect:signin";
    }*/

}
