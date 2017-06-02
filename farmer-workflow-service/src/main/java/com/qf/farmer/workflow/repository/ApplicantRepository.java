package com.qf.farmer.workflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qf.farmer.workflow.domain.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

}