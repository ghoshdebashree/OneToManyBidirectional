package com.example.OneToManyBidirectional.SERVICE;

import com.example.OneToManyBidirectional.ENTITY.Registration;
import com.example.OneToManyBidirectional.REPOSITORY.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository ;

    public List<Registration> allRegistrations(){
        return registrationRepository.findAll();
    }
    public Registration getOneRegistration(int id){
        return registrationRepository.findById(id).get();
    }
    public Registration addRegistration(Registration registration){
        registration.setId(0);
        return registrationRepository.save(registration);
    }
    public void deleteRegistration(int id){
        registrationRepository.deleteById(id);
    }

}

