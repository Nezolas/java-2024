package com.abc.controller;

import com.abc.model.Tutorial;
import com.abc.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// http://localhost:8090/api

// @CrossOrigin(origins = {"http://127.0.0.1:8081", "http://localhost:3000", "http://100.20.55.145:4000"})
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TutorialController {

  @Autowired
  TutorialService tutorialService;


  //GET    http://localhost:8090/api/tutorials
  //GET    http://localhost:8090/api/tutorials?title=abc
  @GetMapping("/tutorials")
  public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
      return tutorialService.getAllTutorials(title);
  }

  //GET    http://localhost:8090/api/tutorials/:id
  @GetMapping("/tutorials/{id}")
  public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
    return tutorialService.getTutorialById(id);
  }


  //GET    http://localhost:8090/api/tutorials/published
  @GetMapping("/tutorials/published")
  public ResponseEntity<List<Tutorial>> findByPublished() {
    return tutorialService.findByPublished(true);
  }

  // TODO true ve false durumu esnek yapılacak.
  /*
  //GET    http://localhost:8090/api/tutorials/published/:flag
  @GetMapping("/tutorials/published/{flag}")
  public ResponseEntity<List<Tutorial>> findByPublished(@PathVariable("flag") boolean flag) {
    return tutorialService.findByPublished(flag);
  }
*/


  //POST    http://localhost:8090/api/tutorials
  @PostMapping("/tutorials")
  public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
   return tutorialService.createTutorial(tutorial);
  }


  //PUT    http://localhost:8090/api/tutorials/:id
  @PutMapping("/tutorials/{id}")
  public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
    return tutorialService.updateTutorial(id, tutorial);
  }


  //DELETE    http://localhost:8090/api/tutorials/:id
  @DeleteMapping("/tutorials/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
   return tutorialService.deleteTutorial(id);
  }

  //DELETE    http://localhost:8090/api/tutorials
  @DeleteMapping("/tutorials")
  public ResponseEntity<HttpStatus> deleteAllTutorials() {
   return tutorialService.deleteAllTutorials();
  }


}
