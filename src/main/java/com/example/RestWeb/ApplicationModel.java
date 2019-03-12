package com.example.RestWeb;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
public class ApplicationModel implements Serializable {
    private static final long serialVersionUID = 876688928410084519L;

    @Id
    private Long id;

    private String message;
}
