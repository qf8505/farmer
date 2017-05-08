package com.qf.farmer.neo.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import lombok.Data;

@Data
@RelationshipEntity(type="HAS_SEEN")
public class Seen {
    public Seen(Integer stars, User startNode, Movie endNode){
        this.stars = stars;
        this.startNode = startNode;
        this.endNode = endNode;
    }
    @GraphId
    private Long id;
    @Property
    private Integer stars;
    @StartNode
    private User startNode;
    @EndNode
    private Movie endNode;
}