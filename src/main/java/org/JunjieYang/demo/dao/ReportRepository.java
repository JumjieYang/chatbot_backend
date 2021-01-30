package org.JunjieYang.demo.dao;

import org.JunjieYang.demo.model.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReportRepository extends CrudRepository<Report, String> {
    List<Report> findByDate(Date date);
    Report findByWorker(String user);

}
