package com.lmp.unmsm.dummy.controller;

import com.lmp.unmsm.dummy.entity.Section;
import com.lmp.unmsm.dummy.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    private SectionService service;

    @GetMapping
    public List<Section> findByCourseId
            (@RequestParam("courseId") int courseId) {
        return service.findByCourseId(courseId);
    }
}
