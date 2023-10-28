package com.rogueanovi.layeredarchitectureapi.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {
    @Id
    @SequenceGenerator(name = "task_id_sequence", sequenceName = "task_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_sequence")
    private Long id;

    @NotBlank
    @Size(min = 3, max = 45)
    private String name;

    @NotBlank
    @Size(min = 10)
    private String description;


    private boolean isCompleted;


    private LocalDateTime dateOfCreation;

    @Positive
    private int timeRequiredToComplete;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "tasks")
    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Task(Long id) {
        this.id = id;
    }

    public void setInitialValues(){
        this.isCompleted = false;
        this.dateOfCreation = LocalDateTime.now();
    }
}
