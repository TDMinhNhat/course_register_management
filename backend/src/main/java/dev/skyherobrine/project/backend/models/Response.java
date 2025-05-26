package dev.skyherobrine.project.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    private int code;
    private String message;
    private Object data;
}
