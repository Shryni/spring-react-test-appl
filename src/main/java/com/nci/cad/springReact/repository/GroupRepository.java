package com.nci.cad.springReact.repository;

import com.nci.cad.springReact.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
    Group findByName(String name);
}
