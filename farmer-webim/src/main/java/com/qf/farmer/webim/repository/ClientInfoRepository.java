package com.qf.farmer.webim.repository;  
  
import org.springframework.data.repository.CrudRepository;

import com.qf.farmer.webim.domain.ClientInfo;  
  
public interface ClientInfoRepository extends CrudRepository<ClientInfo, String>{  
    ClientInfo findClientByclientid(String clientId);  
}  