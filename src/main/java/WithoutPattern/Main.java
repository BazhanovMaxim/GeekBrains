package WithoutPattern;

import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import properties.ProjectConfiguration;

@Slf4j
public class Main {
    /**
     * Проблемы обычного подхода:
     * 1. Можно забыть про Break;
     * 2. Возможно большое кол-во перечисляемых элементов
     * 3. Тяжело разбираться в коде, если придётся что-то изменить
     */
    public static void main(String[] args) {
        ProjectConfiguration prc = ConfigFactory.create(ProjectConfiguration.class);
        String requestType = prc.getRequestType();

        if (requestType == null) {
            throw new RuntimeException("Не найден тип запроса");
        }

        switch (requestType) {
            case ("POST"):
                log.info("POST REQUEST");
                break;
            case ("GET"):
                log.info("GET REQUEST");
                break;
            case ("DELETE"):
                log.info("DELETE REQUEST");
                break;
            case ("UPDATE"):
                log.info("UPDATE REQUEST");
                break;
        }
    }
}
