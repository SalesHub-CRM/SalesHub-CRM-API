package com.example.CRM.runner;

import com.example.CRM.entities.ERole;
import com.example.CRM.entities.Role;
import com.example.CRM.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class RoleInitializerRunner implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public RoleInitializerRunner(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        for (ERole enumRole : ERole.values()) {

            if (roleRepository.findByName(enumRole).isEmpty()) {
                Role role = new Role();
                role.setName(enumRole);
                roleRepository.save(role);

            }


        }
    }
}
