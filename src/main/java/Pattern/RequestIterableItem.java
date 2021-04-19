package Pattern;

import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public enum RequestIterableItem {
    GET("GET", "REQUEST GET"),
    POST("POST", "REQUEST POST"),
    DELETE("DELETE", "REQUEST DELETE"),
    UPDATE("UPDATE", "REQUEST UPDATE");
    String requestType;
    String logResult;

    RequestIterableItem(String requestType, String logResult) {
        this.requestType = requestType;
        this.logResult = logResult;
    }

    public static RequestIterableItem getRequestLog(@NotNull String requestType) {
        return Stream.of(RequestIterableItem.values())
                .filter(requestIterableItem -> requestType.equals(requestIterableItem.name()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
