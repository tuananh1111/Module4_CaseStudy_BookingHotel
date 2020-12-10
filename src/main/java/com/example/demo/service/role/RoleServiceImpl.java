package com.example.demo.service.role;

import com.example.demo.model.Role;
import com.example.demo.repository.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void save(Role user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Role> findById(Long id) {
        return Optional.empty();
    }
}
