package hello.hellospring.project;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class MemberDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Set<String> name;

    private Set<String> userName;

    private Set<Long> id;


    public Set<String> getName() {
        return name;
    }

    public void setName(Set<String> name) {
        this.name = name;
    }

    public Set<String> getUserName() {
        return userName;
    }

    public void setUserName(Set<String> userName) {
        this.userName = userName;
    }

    public Set<Long> getId() {
        return id;
    }

    public void setId(Set<Long> id) {
        this.id = id;
    }
}


