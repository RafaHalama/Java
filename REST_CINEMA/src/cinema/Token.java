package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Token {

    @JsonProperty("token")
    private UUID uuid;

    public Token() {
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID token) {
        this.uuid = token;
    }

}