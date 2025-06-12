package com.lmp.unmsm.dummy.service;

import com.lmp.unmsm.dummy.entity.Section;
import com.lmp.unmsm.dummy.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

    @Autowired
    private SectionRepository repository;

    public List<Section> findByCourseId(int courseId) {
        return repository.findByCourseId(courseId);
    }
}
