package kz.ruzgaliyev.internetmagazin.repository;

import kz.ruzgaliyev.internetmagazin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    //Поиск пользователя по эмайл
    Optional<User> findByEmail(String email);
    //Проверка по существованию пользователя по эмайл
    boolean existsByEmail(String email);
}
