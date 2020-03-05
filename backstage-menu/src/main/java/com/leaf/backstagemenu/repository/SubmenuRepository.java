package com.leaf.backstagemenu.repository;

import com.leaf.backstagemenu.entity.Submenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubmenuRepository extends JpaRepository<Submenu, Integer> {
}
