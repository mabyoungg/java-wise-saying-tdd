package org.example.domain.wisesaing.wisesaying.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WiseSaying {
    private long id;
    private String author;
    private String content;
}
