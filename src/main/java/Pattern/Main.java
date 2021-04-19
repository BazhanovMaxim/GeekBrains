package Pattern;

import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import properties.ProjectConfiguration;

@Slf4j
public class Main {
    /**
     * Паттерн позволяет контролировать наши элементы + если есть необходимость
     * что-то изменить, тогда мы просто это делаем в enum.
     */
    public static void main(String[] args) {
        ProjectConfiguration prc = ConfigFactory.create(ProjectConfiguration.class);
        String requestType = prc.getRequestType();
        if (requestType == null) {
            throw new RuntimeException("Не найден тип запроса");
        }
        log.info(RequestIterableItem.getRequestLog(requestType).logResult);
    }
}
