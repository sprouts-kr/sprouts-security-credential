package kr.sprouts.framework.library.security.credential;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public class Principal<S extends Subject> {
    @NotNull
    private UUID providerId;
    @NotEmpty
    private List<UUID> targetConsumers;
    @NotNull
    private S subject;

    private Principal() { }

    private Principal(UUID providerId, List<UUID> targetConsumers, S subject) {
        this.providerId = providerId;
        this.targetConsumers = targetConsumers;
        this.subject = subject;
    }

    public static <S extends Subject> Principal<S> of(UUID providerId, List<UUID> targetConsumers, S subject) {
        return new Principal<>(providerId, targetConsumers, subject);
    }

    public UUID getProviderId() {
        return providerId;
    }

    public List<UUID> getTargetConsumers() {
        return targetConsumers;
    }

    public S getSubject() {
        return subject;
    }
}
