import br.com.creative.devlet.entity.Person;
import br.com.creative.devlet.enums.EnumEnterpriseType;
import br.com.creative.devlet.enums.EnumState;
import br.com.creative.devlet.exception.BussinessException;
import br.com.creative.devlet.model.EnterpriseCreateUpdateModel;
import br.com.creative.devlet.model.UserAndPersonModel;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

<<<<<<<HEAD
//package br.com.creative.devlet.service;
//
//import br.com.creative.devlet.entity.Person;
//import br.com.creative.devlet.enums.EnumEnterpriseType;
//import br.com.creative.devlet.enums.EnumState;
//import br.com.creative.devlet.exception.BussinessException;
//import br.com.creative.devlet.model.EnterpriseCreateUpdateModel;
//import br.com.creative.devlet.model.UserAndPersonModel;
//import br.com.creative.devlet.model.UserModel;
//import org.fluttercode.datafactory.impl.DataFactory;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@TestPropertySource(locations = "classpath:application-test.properties")
//public class PersonServiceImplTest {
//    private DataFactory dataFactory = new DataFactory();
//
//    @Autowired
//    private PersonService personService;
//
//    @Autowired
//    private EnterpriseService enterpriseService;
//
//    @Autowired
//    private UserService userService;
//
//
//    public void createEnterprise(String zipCode, String cnpj) throws BussinessException {
//        EnterpriseCreateUpdateModel model = new EnterpriseCreateUpdateModel();
//        model.setName(dataFactory.getBusinessName());
//        model.setPhone("("+dataFactory.getNumberText(2)+")"+dataFactory.getNumberText(4)+"-"+dataFactory.getNumberText(4));
//        model.setEmail(dataFactory.getEmailAddress());
//        model.setZipCode(zipCode);
//        model.setStreet(dataFactory.getStreetName());
//        model.setNumber(dataFactory.getNumberUpTo(20000));
//        model.setNeighborhood(dataFactory.getAddress());
//        model.setCity(dataFactory.getCity());
//        model.setState(EnumState.SP);
//        model.setCountry("brasil");
//        model.setCnpj(cnpj);
//        model.setType(EnumEnterpriseType.DEVELOPER);
//        model.setEnabled(dataFactory.chance(75));
//        enterpriseService.create(model);
//
//    }
//
//    public void createUserAndPerson(String zipCode, String cpf) throws BussinessException {
//        UserAndPersonModel personModel = new UserAndPersonModel();
//        personModel.setUsername(dataFactory.getName());
//        personModel.setEmail(dataFactory.getEmailAddress());
//        personModel.setPassword("001002003");
=======
        package br.com.creative.devlet.service;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class PersonServiceImplTest {
    private DataFactory dataFactory = new DataFactory();

    @Autowired
    private PersonService personService;

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private UserService userService;


    public void createEnterprise(String zipCode, String cnpj) throws BussinessException {
        EnterpriseCreateUpdateModel model = new EnterpriseCreateUpdateModel();
        model.setName(dataFactory.getBusinessName());
        model.setPhone("("+dataFactory.getNumberText(2)+")"+dataFactory.getNumberText(4)+"-"+dataFactory.getNumberText(4));
        model.setEmail(dataFactory.getEmailAddress());
        model.setZipCode(zipCode);
        model.setStreet(dataFactory.getStreetName());
        model.setNumber(dataFactory.getNumberUpTo(20000));
        model.setNeighborhood(dataFactory.getAddress());
        model.setCity(dataFactory.getCity());
        model.setState(EnumState.SP);
        model.setCountry("brasil");
        model.setCnpj(cnpj);
        model.setType(EnumEnterpriseType.DEVELOPER);
        model.setEnabled(dataFactory.chance(75));
        enterpriseService.create(model);

    }

    public void createUserAndPerson(String zipCode, String cpf) throws BussinessException {
        UserAndPersonModel personModel = new UserAndPersonModel();
        personModel.setUsername(dataFactory.getName());
        personModel.setEmail(dataFactory.getEmailAddress());
        personModel.setPassword("001002003");
>>>>>>> 5e4e4927889904c07cf2bfa250cd904b3922040d
//        personModel.setName(dataFactory.getName());
//        personModel.setEnterprise_id(enterpriseService.findById(1L).get().getId());
//        personModel.setPhone("("+dataFactory.getNumberText(2)+")"+dataFactory.getNumberText(4)+"-"+dataFactory.getNumberText(4));
//        personModel.setZipCode(zipCode);
//        personModel.setStreet(dataFactory.getStreetName());
//        personModel.setNumber(dataFactory.getNumberUpTo(20000));
//        personModel.setNeighborhood(dataFactory.getAddress());
//        personModel.setCity(dataFactory.getCity());
//        personModel.setState(EnumState.SP);
//        personModel.setCountry("brasil");
//        personModel.setCpf(cpf);
//        personService.create(personModel);
<<<<<<< HEAD
//    }
//
//    @Test
//    public void whenFindAllPeople_ThenReturnListOfPeople() throws BussinessException{
//        createEnterprise("13313-006","89.639.388/0001-89");
//        createUserAndPerson("13313-006","930.282.130-79");
//
//        Optional<Person> person = personService.findByCpf("930.282.130-79");
//        Assert.assertFalse(person.isPresent());
//    }
//}
=======
    }

    @Test
    public void whenFindAllPeople_ThenReturnListOfPeople() throws BussinessException{
        createEnterprise("13313-006","89.639.388/0001-89");
        createUserAndPerson("13313-006","930.282.130-79");

        Optional<Person> person = personService.findByCpf("930.282.130-79");
        Assert.assertFalse(person.isPresent());
    }
}
>>>>>>> 5e4e4927889904c07cf2bfa250cd904b3922040d
