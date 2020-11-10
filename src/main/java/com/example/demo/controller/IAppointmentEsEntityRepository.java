package com.example.demo.controller;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IAppointmentEsEntityRepository extends ElasticsearchRepository<AppointmentEsEntity, Long> {

}
