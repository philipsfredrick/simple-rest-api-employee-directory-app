package com.nonso.employeedirapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private String message;
    private boolean status;
    private T data;

    public ApiResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    public String getTimeStamp() {
        return LocalDateTime.now().toString();
    }

}
