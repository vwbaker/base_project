package base.post;

import base.user.User;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @OneToOne // Tell Hibernate (JPA implementation used in Spring Data) table association so it can join tables
    @NotNull // Data validators
    private User createdBy;

    @NotEmpty(message = "Message body can't be empty.")
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
