package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "time")
@NamedQueries({
    @NamedQuery(
            name = "getAllTime",
            query = "SELECT r FROM Time AS r ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getTimeCount",
            query = "SELECT COUNT(r) FROM Time AS r"
            ),
})
@Entity
public class Time {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


    @Column(name = "work_at", nullable = false)
    private Timestamp work_at;

    @Column(name = "workout_at", nullable = false)
    private Timestamp workout_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public Timestamp getWork_at() {
        return work_at;
    }

    public void setWork_at(Timestamp work_at) {
        this.work_at = work_at;
    }

    public Timestamp getWorkout_at() {
        return workout_at;
    }

    public void setWorkout_at(Timestamp workout_at) {
        this.workout_at = workout_at;
    }
}
