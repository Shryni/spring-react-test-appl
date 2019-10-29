package com.nci.cad.springReact.controller;

import com.nci.cad.springReact.model.Event;
import com.nci.cad.springReact.model.Group;
import com.nci.cad.springReact.repository.GroupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class GroupController {

    private final GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping("/groups")
    Collection<Group> groups() {
        return groupRepository.findAll();
    }

    @GetMapping("/group/{id}")
    ResponseEntity<?> getGroup(@PathVariable Long id) {
        Optional<Group> group = groupRepository.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    @PostMapping("/add")
//    void addAll(){
//        Stream.of("Denver JUG", "Utah JUG", "Seattle JUG",
//                "Richmond JUG").forEach(name ->
//                groupRepository.save(new Group(name))
//        );
//    }

    @PostMapping("/group")
    ResponseEntity<Group> createGroup(@Valid @RequestBody Group group) throws URISyntaxException {
        //log.info("Request to create group: {}");
        Group result = groupRepository.save(group);
        return ResponseEntity.created(new URI("/api/group/" + result.getId()))
                .body(result);
    }

    @PutMapping("/group/{id}")
    ResponseEntity<Group> updateGroup(@Valid @RequestBody Group group) {
        //log.info("Request to update group: {}");
        Group result = groupRepository.save(group);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        //log.info("Request to delete group: {}");
        groupRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
