package com.example.BaytAlAmana.serviceimpl;

import com.example.BaytAlAmana.dto.UserDto;
import com.example.BaytAlAmana.entity.InvestmentEntity;
import com.example.BaytAlAmana.entity.UserEntity;
import com.example.BaytAlAmana.mapper.UserMapper;
import com.example.BaytAlAmana.repo.InvestmentRepository;
import com.example.BaytAlAmana.repo.UserRepository;
import com.example.BaytAlAmana.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    InvestmentRepository investmentRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return UserMapper.INSTANCE.toUserDtoList(userRepository.findAll());
    }

    @Override
    public UserDto getUserById(int id) {
        return UserMapper.INSTANCE.toUserDto(userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found")));
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = userRepository.save(UserMapper.INSTANCE.toUserEntity(userDto));
        return UserMapper.INSTANCE.toUserDto(userEntity);
    }

    @Override
    public UserDto updateUser(int id, UserDto userDto) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        UserEntity userEntityToUpdate = UserMapper.INSTANCE.toUserEntity(userDto);
        userEntityToUpdate.setId(id);
        return UserMapper.INSTANCE.toUserDto(userRepository.save(userEntityToUpdate));
    }

    @Override
    public boolean deleteUser(int id) {
        try{
            UserEntity user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
            for (InvestmentEntity investment : user.getInvestments()) {
                investment.getUsers().remove(user);
                investmentRepository.save(investment);
            }
            userRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean assignUserToInvestment(int id, int investmentId) {
        UserEntity user = userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("User not found"));
        InvestmentEntity investment = investmentRepository.findById(investmentId).orElseThrow(()-> new EntityNotFoundException("Investment not found"));
        user.getInvestments().add(investment);
        investment.getUsers().add(user);
        user.setInvestmentCount(user.getInvestments().size());
        try {
            investmentRepository.save(investment);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public boolean removeUserFromInvestment(int id, int investmentId){
        UserEntity user = userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("User not found"));
        InvestmentEntity investment = investmentRepository.findById(investmentId).orElseThrow(()-> new EntityNotFoundException("Investment not found"));
        user.getInvestments().remove(investment);
        investment.getUsers().remove(user);
        user.setInvestmentCount(user.getInvestments().size());
        try {
            investmentRepository.save(investment);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }



}




