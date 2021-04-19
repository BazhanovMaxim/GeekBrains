package properties;

import org.aeonbits.owner.Config;

@Config.Sources({"file:src/main/resources/application.properties"})
public interface ProjectConfiguration extends Config {

    @Config.Key("BG.type.request")
    String getRequestType();
}
