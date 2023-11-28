package com.example.hotelier.service.impl;

import com.example.hotelier.model.entity.UserEntity;
import com.example.hotelier.model.entity.UserRoleEntity;
import com.example.hotelier.model.enums.UserRoleEnum;
import com.example.hotelier.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class HotelierUserDetailsServiceTest {

    @ExtendWith(MockitoExtension.class)
    private HotelierUserDetailsService serviceToTest;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new HotelierUserDetailsService(
                mockUserRepository
        );
    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("my@softuni.bg"));


    }
    @Test
    void testUserFoundException() {
        //Arrange
        UserEntity testUserEntity = createTestUser();
        when(mockUserRepository.findByEmail(testUserEntity.getEmail()))
                .thenReturn(Optional.of(testUserEntity));

        //Act
        UserDetails userDetails =
                serviceToTest.loadUserByUsername(testUserEntity.getEmail());

        //Assert
        Assertions.assertNotNull(userDetails);
        Assertions.assertEquals(
                testUserEntity.getEmail(),
                userDetails.getUsername(),
                "Username is not mapped to email.");

        Assertions.assertEquals(testUserEntity.getPassword(),
                userDetails.getPassword());
        Assertions.assertEquals(2, userDetails.getAuthorities().size());

        Assertions.assertTrue(containsAuthority(userDetails, "ROLE_" +
                UserRoleEnum.ADMIN), "The user is not admin");

        Assertions.assertTrue(containsAuthority(userDetails,
                "ROLE_" +
                UserRoleEnum.USER), "The user is not user");


    }

    private boolean containsAuthority(UserDetails userDetails, String expectedAuthority){
       return userDetails.getAuthorities().stream().anyMatch(a->
                expectedAuthority.equals(a.getAuthority()));

    }


    private static UserEntity createTestUser() {
        return  new UserEntity().setFirstName("firstName")
                .setLastName("lastName")
                .setEmail("student@softuni.bg")
                .setActive(false)
                .setPassword("test")
                .setRoles(List.of(
                        new UserRoleEntity().setRole(UserRoleEnum.USER),
                        new UserRoleEntity().setRole(UserRoleEnum.ADMIN)
                ));

    }
}
