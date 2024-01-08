package com.soni.spring.boot3.audit;

import com.soni.spring.boot3.audit.entity.Company;
import com.soni.spring.boot3.audit.entity.User;
import com.soni.spring.boot3.audit.repository.CompanyRepository;
import com.soni.spring.boot3.audit.repository.UserAuditRepository;
import com.soni.spring.boot3.audit.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.data.history.Revision;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableEnversRepositories
public class SpringBoot3AuditApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private UserAuditRepository userAuditRepository;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3AuditApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user = User.builder().email("ravi@gmail.com").firstName("Hari").lastName("Soni").contactNumber("908888111").build();
        userRepository.saveAndFlush(user);

        userRepository.findByEmail(user.getEmail()).ifPresent(updateUser -> {
            updateUser.setEmail("update@gmail.com");
            updateUser.setContactNumber("2222222");
            userRepository.saveAndFlush(updateUser);
        });
        userRepository.findByEmail("update@gmail.com").ifPresent(deleteUser -> {
            userRepository.delete(deleteUser);
        });
        List userHistory = getAuditHistory(user.getId());
        userHistory.stream().forEach(System.out::println);
        List usersHistory = getAllRevisionsForEntity();
        usersHistory.stream().forEach(System.out::println);
        companyRepository.save(Company.builder().name("Code2Build").address("Mumbai").pinCode(486331).location("India").build());
    }

    //Fetch history using entity id for an entity
    public List<Revision<Integer, User>> getAuditHistory(String entityId) {
        return userAuditRepository.findRevisions(entityId)
                .stream()
                .collect(Collectors.toList());
    }
    //Fetch all history for entity
    public List<User> getAllRevisionsForEntity() {
        AuditReader auditReader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        return auditReader.createQuery()
                .forRevisionsOfEntity(User.class, false, true)
                .getResultList();
    }
}
