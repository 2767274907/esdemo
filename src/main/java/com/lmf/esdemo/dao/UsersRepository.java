package com.lmf.esdemo.dao;

import com.lmf.esdemo.entity.Users;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UsersRepository extends ElasticsearchRepository<Users,String> {
}
