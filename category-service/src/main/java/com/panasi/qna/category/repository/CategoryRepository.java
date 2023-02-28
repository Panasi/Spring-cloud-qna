package com.panasi.qna.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panasi.qna.category.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	public Category findByName(String name);
	
	public List<Category> findAllByParentId(int parentId);

}
