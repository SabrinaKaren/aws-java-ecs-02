package br.com.sabrina.aws_project02.model;

import br.com.sabrina.aws_project02.enums.EventType;

public class ProductEventLogDto {

    private final String code;
    private final EventType eventType;
    private final long productId;
    private final String username;
    private final long timestamp;
    private final String messageId;

    public ProductEventLogDto(ProductEventLog productEventLog) {
        this.code = productEventLog.getPk();
        this.eventType = productEventLog.getEventType();
        this.productId = productEventLog.getProductId();
        this.username = productEventLog.getUsername();
        this.timestamp = productEventLog.getTimestamp();
        this.messageId = productEventLog.getMessageId();
    }

    public String getCode() {
        return this.code;
    }

    public EventType getEventType() {
        return this.eventType;
    }

    public long getProductId() {
        return this.productId;
    }

    public String getUsername() {
        return this.username;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getMessageId() {
        return this.messageId;
    }
    
}