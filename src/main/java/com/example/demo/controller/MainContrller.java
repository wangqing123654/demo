package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class MainContrller {
	
    @Autowired
    private IAppointmentEsEntityRepository appointmentEsEntityRepository;
    
	
	@GetMapping("/hello")
	public void hello() {
		Optional<AppointmentEsEntity> opt = appointmentEsEntityRepository.findById(1l);
		opt.ifPresent(e->{
			System.out.println(e);
		});
		
		SearchQuery query = null;
		
		AppointmentEsEntity entity = new AppointmentEsEntity();
		entity.setId(1l);
		entity.setAppointmentDate("2020-11-05");
		appointmentEsEntityRepository.save(entity);
	}

}
