package com.rudgjs8080.readbook.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@Entity
@Table(name = "tbl_books")
public class BookVO {

    @Id
    @Column
    private String isbn;
    @Column
    private String b_name;
    @Column
    private String b_day;
    @Column
    private String b_s_time;
    @Column
    private String b_e_time;
    @Column
    private String b_title;
    @Column
    private String b_text;
}
