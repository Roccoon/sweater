package com.springtest.sweater.repos;

import com.springtest.sweater.domane.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {
}
