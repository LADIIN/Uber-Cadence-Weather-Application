package com.example.activityworker.repository;

import com.example.activityworker.model.WeatherInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherInfoRepository extends CrudRepository<WeatherInfo, Long> {
}
