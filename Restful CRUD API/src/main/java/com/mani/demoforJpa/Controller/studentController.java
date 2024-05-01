package com.mani.demoforJpa.Controller;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mani.demoforJpa.Entity.student;
import com.mani.demoforJpa.Repository.studentRepo;

@RestController
public class studentController {
	
	@Autowired
	studentRepo studentRepo;
	
	@PostMapping("/api/students")
	public ResponseEntity<student> saveStudent(@RequestBody student student) {
		return new ResponseEntity<>(studentRepo.save(student),HttpStatus.CREATED);
	}
		@GetMapping("/api/students")
		public ResponseEntity<List<student>> getStudents(){
			return new ResponseEntity<>(studentRepo.findAll(),HttpStatus.OK);
		}
		
		
		@GetMapping("/api/students/{id}")
		public ResponseEntity<student> getStudent(@PathVariable   long id){
			Optional<student> student=studentRepo.findById(id);
			if (student.isPresent()) {
				return new ResponseEntity<>(student.get(),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
		@PutMapping("/api/students/{id}")
		public ResponseEntity<student> updateStudent(@PathVariable long id,@RequestBody student stud){
			Optional<student> student= studentRepo.findById(id);
			if(student.isPresent()) {
				student.get().setStudentName(stud.getStudentName());
				student.get().setStudentMailId(stud.getStudentMailId());
				student.get().setStudnetAddres(stud.getStudnetAddres());
				
				return new ResponseEntity<>(studentRepo.save(student.get()),HttpStatus.OK);
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
		}


	@DeleteMapping("/api/students/{id}")
		public ResponseEntity<Void> deleteStudent(@PathVariable   long id){
			Optional<student> student=studentRepo.findById(id);
			if (student.isPresent()) {
				studentRepo.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
				
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}


}

