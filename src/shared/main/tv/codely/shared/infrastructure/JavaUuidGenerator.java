package tv.codely.shared.infrastructure;

import tv.codely.shared.domain.Component;
import tv.codely.shared.domain.UuidGenerator;

import java.util.UUID;

@Component
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
