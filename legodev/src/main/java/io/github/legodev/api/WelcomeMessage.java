package io.github.legodev.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WelcomeMessage {
    @JsonProperty
    private long visitorId;

    @JsonProperty
    private String message;
}
