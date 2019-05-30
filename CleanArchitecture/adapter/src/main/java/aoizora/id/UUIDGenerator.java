package aoizora.id;

import aoizora.usecase.port.IDGenerator;

import java.util.UUID;

public class UUIDGenerator implements IDGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
