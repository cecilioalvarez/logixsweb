package es.logixs.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import es.logixs.web.domain.Company;
import es.logixs.web.domain.User;
import es.logixs.web.repositories.mysql.CompanyRepositoryMySQL;
import es.logixs.web.repositories.mysql.UserRepositoryMySQL;
import es.logixs.web.services.UserCompanyService;

@ExtendWith(MockitoExtension.class)
public class UsersCompaniesServiceTest {
    @Mock
    public UserRepositoryMySQL userRepositoryMock;
    @Mock
    public CompanyRepositoryMySQL companiesRepositoryMock;
    @InjectMocks
    public UserCompanyService userCompaniesService;

    @Test
    public void findOneUserTest() {

        User user1 = new User("1A","Juan","Hernandez","juan@juan.com");

        when(userRepositoryMock.findOne("1A")).thenReturn(user1);

        User foundUser = userRepositoryMock.findOne("1A");

        assertEquals(user1, foundUser);
    }

    @Test
    public void findAllUsersTest() {

        User user1 = new User("1A","Juan","Hernandez","juan@juan.com");
        User user2 = new User("2A","Alexis","Fernandez","alexis@alexis.com");

        List<User> usersListMock = Arrays.asList(user1, user2);
        when(userRepositoryMock.findAll()).thenReturn(usersListMock);
        List<User> userListFinal = userCompaniesService.findAllUsers();

        verify(userRepositoryMock, times(1)).findAll();
        assertEquals(usersListMock, userListFinal);
    }

    @Test
    public void deleteUserTest() {

        User user = new User("1A");

        userCompaniesService.deleteUser(user);

        verify(userRepositoryMock, times(1)).delete(user);
    }

    @Test
    public void insertUserTest() {

        User user1 = new User("1A","Juan","Hernandez","juan@juan.com");

        when(userRepositoryMock.insert(user1)).thenReturn(user1);

        User insertedUser = userRepositoryMock.insert(user1);

        assertEquals(user1, insertedUser);
    }

    @Test
    public void insertCompaniesTest() {

        Company company1 = new Company("1A","ds12fsdf","asdafs23","PWC","324234d");

        when(companiesRepositoryMock.insert(company1)).thenReturn(company1);

        Company insertedCompany = companiesRepositoryMock.insert(company1);

        assertEquals(company1, insertedCompany);
    }

    @Test
    public void findOneCompanyTest() {

        Company company1 = new Company("1A","ds12fsdf","asdafs23","PWC","324234d");


        when(companiesRepositoryMock.findOne("1A")).thenReturn(company1);

        Company foundCompany = companiesRepositoryMock.findOne("1A");

        assertEquals(company1, foundCompany);
    }

    @Test
    public void findAllCompaniesTest() {

        Company company1 = new Company("1A","HFGAD2","ASDFAF2","PWC","asdfasdf2");
        Company company2 = new Company("2A","HFGDAD2","ASDFAAF2","PWC 2","asd2fasdf2");

        List<Company> companiesListMock = Arrays.asList(company1, company2);
        when(companiesRepositoryMock.findAll()).thenReturn(companiesListMock);
        List<Company> companiesListFinal = userCompaniesService.findAllCompanies();

        verify(companiesRepositoryMock, times(1)).findAll();
        assertEquals(companiesListMock, companiesListFinal);
    }

    @Test
    public void deleteCompaniesTest() {

        Company company = new Company("1A");

        userCompaniesService.deleteCompanies(company);

        verify(companiesRepositoryMock, times(1)).delete(company);
    }



}
