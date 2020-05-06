package com.ronak.VotingApp.Controller;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ronak.VotingApp.Entity.Candidates;
import com.ronak.VotingApp.Entity.User;
import com.ronak.VotingApp.Exception.ServiceLayerException;
import com.ronak.VotingApp.Service.VotingAppService;

@CrossOrigin(origins = "*")
@RestController
@EnableAutoConfiguration
public class VotingAppController {
	VotingAppService service = new VotingAppService();

	int flag = 0, first = 0, last = 0, no = 0;

	@GetMapping(value = "/displayResults")
	public ArrayList<Candidates> getplayerdetails() throws ServiceLayerException {
		ArrayList<Candidates> candidates = new ArrayList<>();
		candidates = service.getCandidatesfromservicelayer();
		return candidates;

	}
	
	@PostMapping(value="/users")
	public String adddetails(@RequestBody User user) throws ServiceLayerException{
		ArrayList<User> userList = new ArrayList<>();
			userList = service.getUserfromservicelayer();

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserFirstName().equals(user.getUserFirstName())) {
				first = 1;

			}
			if (userList.get(i).getUserLastName().equals(user.getUserLastName())) {
				last = 1;

			}
			if (userList.get(i).getUserPhoneNo().equals(user.getUserPhoneNo())) {
				no =1;
			}
		}
		if (first == 1 && last == 1 && no == 1) {
			first = 0;
			last = 0;
			no = 0;
			return "fail";
		} else {
				service.addVotertoService(user);
				return "pass";
			
			
		}

		
	}
}
