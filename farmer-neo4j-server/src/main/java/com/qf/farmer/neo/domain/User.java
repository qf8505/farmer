package com.qf.farmer.neo.domain;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@Data
@NodeEntity(label="USERS")
public class User {
    public User(){}
    
    public User(String name){
        this.name = name;
    }
    @GraphId
    private Long nodeId;
    @Property(name="name")
    private String name;
    //关系直接定义在节点中
    @Relationship(type = "IS_FRIEND_OF", direction=Relationship.OUTGOING)
    private List<User> friends;
    //使用外部定义的关系
    @Relationship(type = "HAS_SEEN")
    private List<Seen> hasSeenMovies;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<Seen> getHasSeenMovies() {
		return hasSeenMovies;
	}

	public void setHasSeenMovies(List<Seen> hasSeenMovies) {
		this.hasSeenMovies = hasSeenMovies;
	}
    
    
}
