package kz.ruzgaliyev.internetmagazin.repository;

import kz.ruzgaliyev.internetmagazin.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findById(Long id);
    Optional<Category> findByName(String name);

    List<Category> findByNameContainingIgnoreCase(String categoryName);
}
