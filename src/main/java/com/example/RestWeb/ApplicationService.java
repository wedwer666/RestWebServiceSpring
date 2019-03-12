package com.example.RestWeb;

import org.springframework.data.repository.CrudRepository;

public interface ApplicationService extends CrudRepository<ApplicationModel, Long> {
}
