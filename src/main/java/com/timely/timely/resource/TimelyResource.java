package com.timely.timely.resource;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.util.Map.of;
import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class TimelyResource {
    private final TimelyServiceImpl projectService;
    @GetMapping("/list")
    public ResponseEntity<Response> getProjects() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("projects", projectService.list(30)))
                        .message("Projects retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveProject(@RequestBody @Valid Project project) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("project", projectService.create(project)))
                        .message("Project created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getProject(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("project", projectService.get(id)))
                        .message("Project retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteProject(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", projectService.delete(id)))
                        .message("Project deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


}
