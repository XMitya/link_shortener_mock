package ru.ifmo.shortener.linkshortener.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("links")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkEntity {
    @Id
    @Column("short_string")
    private String shortString;

    @Column("long_link")
    private String longLink;
}
