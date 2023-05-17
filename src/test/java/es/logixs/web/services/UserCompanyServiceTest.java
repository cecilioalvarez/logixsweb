package es.logixs.web.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import es.logixs.web.domain.Company;
import es.logixs.web.domain.User;
import es.logixs.web.repositories.mysql.CompanyRepositoryMySQL;
import es.logixs.web.repositories.mysql.UserRepositoryMySQL;

@SpringBootTest
@Tag("usercompany")
public class UserCompanyServiceTest {
    @MockBean
    public UserRepositoryMySQL userRepositoryMock;
    @MockBean
    public CompanyRepositoryMySQL companyRepositoryMock;
    @Autowired
    public UserCompanyService userCompanyService;

    @Test
    public void findOneUserTest() throws ParseException {
        User user1 = new User(
                "1A", "pedro", "perez", "pedro@gmail.com", "state", "avatar",
                "password", "prevPassword", "companyId", "invitedBy", "role", 10.0,
                "address", "phone", "city", "zipCode", "countryIso",
                null, null
        );

        when(userRepositoryMock.findOne("1A")).thenReturn(user1);
        User foundUser = userRepositoryMock.findOne("1A");

        assertEquals(user1, foundUser);
    }

    @Test
    public void findAllUsersTest() throws ParseException {
        User user1 = new User(
                "1A", "pedro", "perez", "pedro@gmail.com", "state", "avatar",
                "password", "prevPassword", "companyId", "invitedBy", "role", 10.0,
                "address", "phone", "city", "zipCode", "countryIso",
                null, null
        );
        User user2 = new User("2A", "Alexis", "Fernandez", "alexis@alexis.com", "state", "avatar",
                "password", "prevPassword", "companyId", "invitedBy", "role", 10.0,
                "address", "phone", "city", "zipCode", "countryIso",
                null, null
        );

        List<User> usersListMock = Arrays.asList(user1, user2);
        when(userRepositoryMock.findAll()).thenReturn(usersListMock);
        List<User> userListFinal = userCompanyService.findAllUsers();

        verify(userRepositoryMock, times(1)).findAll();
        assertEquals(usersListMock, userListFinal);
    }

    @Test
    public void deleteUserTest() {
        User user = new User("1A");

        userCompanyService.deleteUser(user);

        verify(userRepositoryMock, times(1)).delete(user);
    }

    @Test
    public void insertUserTest() throws ParseException {
        User user1 = new User("1A", "Juan", "Hernandez", "juan@juan.com", "state", "avatar",
                "password", "prevPassword", "companyId", "invitedBy", "role", 10.0,
                "address", "phone", "city", "zipCode", "countryIso",
                null, null
        );

        when(userRepositoryMock.insert(user1)).thenReturn(user1);
        User insertedUser = userRepositoryMock.insert(user1);

        assertEquals(user1, insertedUser);
    }

    @Test
    public void insertCompanyTest() {
        Company company1 = new Company("1A", "ds12fsdf", "asdafs23", "PWC", "324234d");

        when(companyRepositoryMock.insert(company1)).thenReturn(company1);
        Company insertedCompany = companyRepositoryMock.insert(company1);

        assertEquals(company1, insertedCompany);
    }

    @Test
    public void findOneCompanyTest() {
        Company company1 = new Company("1A", "ds12fsdf", "asdafs23", "PWC", "324234d");

        when(companyRepositoryMock.findOne("1A")).thenReturn(company1);
        Company foundCompany = companyRepositoryMock.findOne("1A");

        assertEquals(company1, foundCompany);
    }

    @Test
    public void findAllCompaniesTest() {
        Company company1 = new Company("1A", "HFGAD2", "ASDFAF2", "PWC", "asdfasdf2");
        Company company2 = new Company("2A", "HFGDAD2", "ASDFAAF2", "PWC 2", "asd2fasdf2");

        List<Company> companyListMock = Arrays.asList(company1, company2);
        when(companyRepositoryMock.findAll()).thenReturn(companyListMock);
        List<Company> companyListFinal = userCompanyService.findAllCompanies();

        verify(companyRepositoryMock, times(1)).findAll();
        assertEquals(companyListMock, companyListFinal);
    }

    @Test
    public void deleteCompanyTest() {
        Company company = new Company("1A");

        userCompanyService.deleteCompany(company);

        verify(companyRepositoryMock, times(1)).delete(company);
    }
}
