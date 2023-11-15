package hello.hellospring.project;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class ResultDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Set<Integer> score;


    public Set<Integer> getScore() {
        return score;
    }

    public void setScore(Set<Integer> score) {
        this.score = score;
    }
}
