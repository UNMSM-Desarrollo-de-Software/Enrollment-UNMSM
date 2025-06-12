package com.lmp.unmsm.dummy.repository;

import com.lmp.unmsm.dummy.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {

    List<Section> findByCourseId(int courseId);
}
