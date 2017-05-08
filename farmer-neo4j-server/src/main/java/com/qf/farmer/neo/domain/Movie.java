package com.qf.farmer.neo.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import lombok.Data;

/**
 * SDN建模
 * @author qinfei
 *
 */
@Data
@NodeEntity(label = "MOVIES")
public class Movie {
    public Movie(String name){
        this.name = name;
    }
    @GraphId
    private Long nodeId;
    @Property(name="name")
    private String name;
}
