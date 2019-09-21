package pl.project.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.project.courses.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> getByFirstName(String firstName);

    List<User> getByLastName(String lastName);

    List<User> getByMail(String mail);

    List<User> getByPhone(String phone);

    List<User> getByCourse(String course);

    List<User> getByMode(String mode);

    @Query("select u from User u where (:firstName is null or u.firstName = :firstName)" +
            "and (:lastName is null or u.lastName= :lastName)")
    List<User> search(@Param("firstName") String firstName,
                      @Param("lastName") String lastName);
}
