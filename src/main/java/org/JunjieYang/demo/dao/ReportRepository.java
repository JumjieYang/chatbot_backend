package org.JunjieYang.demo.dao;

import org.JunjieYang.demo.model.Report;
import org.springframework.data.repository.CrudRepository;
public interface ReportRepository extends CrudRepository<Report, String> {
    
}
