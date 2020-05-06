package com.ronak.VotingApp;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ronak.VotingApp.Entity.Candidates;
import com.ronak.VotingApp.Entity.User;
import com.ronak.VotingApp.Exception.ServiceLayerException;
import com.ronak.VotingApp.Service.VotingAppService;

@SpringBootApplication
public class VotingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotingAppApplication.class, args);
		Scanner input = new Scanner(System.in);
		VotingAppService service = new VotingAppService();

		int flag = 0, first = 0, last = 0, no = 0;
		while (flag == 0) {
			System.out.println("Enter ur choice");
			System.out.println("1.Display Candidate");
			System.out.println("2. Cast Vote");
			System.out.println("3.Exit");

			int choice = input.nextInt();

			switch (choice) {
			case 1:
				ArrayList<Candidates> candidates = new ArrayList<>();
				System.out.println("Display Candidates");
				System.out.println("------------------------------------------------");
				try {
					candidates = service.getCandidatesfromservicelayer();

				} catch (ServiceLayerException e) {

					e.printStackTrace();
				}

				for (int i = 0; i < candidates.size(); i++) {
					System.out.println(candidates.get(i));
				}
				break;

			case 2:

				System.out.println("Cast Vote");

				System.out.println("Enter First name");
				String fName = input.next();

				System.out.println("Enter Last name");
				String lName = input.next();

				System.out.println("Enter Phone no");
				String phoneNo = input.next();

				System.out.println("Enter the candidate id to cast vote");
				int vote = input.nextInt();

				ArrayList<User> userList = new ArrayList<>();
				try {
					userList = service.getUserfromservicelayer();
				} catch (ServiceLayerException e) {
					e.printStackTrace();
				}

				for (int i = 0; i < userList.size(); i++) {
					if (userList.get(i).getUserFirstName().equals(fName)) {
						first = 1;

					}
					if (userList.get(i).getUserLastName().equals(lName)) {
						last = 1;

					}
					if (userList.get(i).getUserPhoneNo().equals(phoneNo)) {
						no =1;
					}
				}
				if (first == 1 && last == 1 && no == 1) {
					first = 0;
					last = 0;
					no = 0;
					System.out.println("existing voter");
				} else {
					User user = new User(fName,lName,phoneNo,vote);
					try {
						service.addVotertoService(user);
						System.out.println("Successfully voted");
					} catch (ServiceLayerException e) {
						e.printStackTrace();
					}
				}
				break;
			case 3:
				System.out.println("Adios, thanks for visiting");
				System.exit(0);
			}
		}

	}

}
