package com.example.CRM.controllers;

import com.example.CRM.entities.*;
import com.example.CRM.repositories.RoleRepository;
import com.example.CRM.repositories.UserRepository;
import com.example.CRM.security.jwt.JwtUtils;
import com.example.CRM.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
//@CrossOrigin(origins = "${baseUrl}",allowCredentials ="true",allowedHeaders = "*")
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    if (!userRepository.existsByUsername(loginRequest.getUsername())) {
      return ResponseEntity.badRequest().body("Nom d'utilisateur inexistant!");
    }
    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();


    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());


      return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
              .body(new LoginResponse(
                      userDetails.getId(),
                      userDetails.getFirstname(),
                      userDetails.getLastname(),
                      userDetails.getUsername(),
                      userDetails.getEmail(),
                      userDetails.getPhone(),
                      userDetails.getGender(),
                      userDetails.getCity(),
                      userDetails.getZipcode(),
                      userDetails.getFulladress(),
                      userDetails.getBirthdate(),
                      userDetails.getCin(),
                      userDetails.getAccountstatus(),
                      userDetails.getCreatedat(),
                      userDetails.getUpdatedat(),
                      roles));

  }

  @PostMapping("/admin/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody AdminSignUpRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body("Error: Username is already taken!");
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest().body("Error: Email is already in use!");
    }

    // Create new admin's account
    Administrator utilisateur = new Administrator();
    utilisateur.setFirstname(signUpRequest.getFirstname());
    utilisateur.setLastname(signUpRequest.getLastname());
    utilisateur.setUsername( signUpRequest.getUsername());
    utilisateur.setEmail( signUpRequest.getEmail());
    utilisateur.setPassword(encoder.encode(signUpRequest.getPassword()));
    utilisateur.setPhone( signUpRequest.getPhone());
    utilisateur.setGender( signUpRequest.getGender());
    utilisateur.setCity(signUpRequest.getCity());
    utilisateur.setZipcode(signUpRequest.getZipcode());
    utilisateur.setFulladress(signUpRequest.getFulladress());
    utilisateur.setBirthdate(signUpRequest.getBirthdate());
    utilisateur.setCin(signUpRequest.getCin());
    utilisateur.setAccountstatus(1);
    utilisateur.setConfirmaccount(false);



    Set<String> strRoles = signUpRequest.getRoles();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role utilisateurRole = roleRepository.findByName(ERole.ROLE_EMPLOYEE)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(utilisateurRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
          case "ROLE_ADMIN" -> {
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);
          }
          case "ROLE_EMPLOYEE" -> {
            Role adminRole = roleRepository.findByName(ERole.ROLE_EMPLOYEE)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);
          }

        }
      });
    }

    utilisateur.setRoles(roles);
    userRepository.save(utilisateur);

    System.out.println(utilisateur.getAccountstatus());

    return ResponseEntity.ok("ADMIN registered successfully!");
  }


  @PostMapping("/client/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody EmployeeSignUpRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body("Le nom d'utilisateur est déjà pris !");
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest().body("L'adresse e-mail est déjà utilisée !");
    }

    // Create new doctor's account
    Employee utilisateur = new Employee();
    utilisateur.setFirstname(signUpRequest.getFirstname());
    utilisateur.setLastname(signUpRequest.getLastname());
    utilisateur.setUsername( signUpRequest.getUsername());
    utilisateur.setEmail( signUpRequest.getEmail());
    utilisateur.setPassword(encoder.encode(signUpRequest.getPassword()));
    utilisateur.setPhone( signUpRequest.getPhone());
    utilisateur.setGender( signUpRequest.getGender());
    utilisateur.setCity(signUpRequest.getCity());
    utilisateur.setZipcode(signUpRequest.getZipcode());
    utilisateur.setFulladress(signUpRequest.getFulladress());
    utilisateur.setBirthdate(signUpRequest.getBirthdate());
    utilisateur.setCin(signUpRequest.getCin());
    utilisateur.setAccountstatus(signUpRequest.getAccountstatus());
    utilisateur.setRank(signUpRequest.getRank());
    utilisateur.setSalary(signUpRequest.getSalary());



    Set<String> strRoles = signUpRequest.getRoles();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role utilisateurRole = roleRepository.findByName(ERole.ROLE_EMPLOYEE)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(utilisateurRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
          case "ROLE_ADMIN" -> {
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);
          }
          case "ROLE_EMPLOYEE" -> {
            Role adminRole = roleRepository.findByName(ERole.ROLE_EMPLOYEE)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(adminRole);
          }

        }
      });
    }

    utilisateur.setRoles(roles);
    userRepository.save(utilisateur);

    return ResponseEntity.ok("Employee registered successfully!");
  }



  @PostMapping("/signout")
  public ResponseEntity<?> logoutUtilisateur() {
    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
        .body("You've been signed out!");
  }
}
