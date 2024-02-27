package com.arindam.exception;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ErrorInfo {
private String errorMessage;
private Integer errorCode;
LocalDateTime  timestamp;
}
