package pl.sii.eu.contracts;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

public class CurrentTime {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "UTC")
    private ZonedDateTime time;

    public CurrentTime() {
    }

    public CurrentTime(ZonedDateTime time) {
        this.time = time;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }
}
