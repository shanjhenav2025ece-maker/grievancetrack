package com.example.grievancetrack.category.repository;

import com.example.grievancetrack.category.entit.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}