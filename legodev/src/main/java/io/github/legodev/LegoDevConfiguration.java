package io.github.legodev;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.core.Configuration;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LegoDevConfiguration extends Configuration {

    @JsonProperty
    @NotEmpty
    private String template;

    @JsonProperty
    @NotEmpty
    private String defaultName;
    // TODO: implement service configuration
}
