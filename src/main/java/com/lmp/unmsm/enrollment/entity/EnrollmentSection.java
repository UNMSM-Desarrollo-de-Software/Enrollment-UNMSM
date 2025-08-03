package com.lmp.unmsm.enrollment.entity;

import com.lmp.unmsm.dummy.entity.Section;
import jakarta.persistence.*;

@Entity
@Table(name = "enrollment_section")
public class EnrollmentSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "EnrollmentSection{" +
                "id=" + id +
                ", enrollment=" + enrollment +
                ", section=" + section +
                '}';
    }
}
