package com.example.personal_finance_tracker.repository;

import com.example.personal_finance_tracker.model.Category;
import com.example.personal_finance_tracker.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByType(TransactionType type);
}
