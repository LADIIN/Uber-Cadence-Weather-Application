package com.example.activityworker.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "weather_info")
public class WeatherInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "city")
    String city;
    @Column(name = "air_temperature")
    double airTemperature;
    @Basic
    @CreationTimestamp
    @Column(name = "record_time")
    LocalTime recordTime;

}
