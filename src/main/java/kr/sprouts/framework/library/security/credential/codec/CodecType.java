package kr.sprouts.framework.library.security.credential.codec;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.function.Supplier;

public enum CodecType {
    BASE64("BASE64", Base64Codec::new),
    BASE64_URL("BASE64_URL", Base64UrlCodec::new),
    ;

    @NotBlank
    private final String name;
    @NotNull
    private final Supplier<Codec> codecSupplier;

    CodecType(String name, Supplier<Codec> codecSupplier) {
        this.name = name;
        this.codecSupplier = codecSupplier;
    }

    public static CodecType fromName(String name) {
        for (CodecType codecType : values()) {
            if (codecType.getName().equalsIgnoreCase(name)) return codecType;
        }

        throw new UnsupportedCodecException();
    }

    public String getName() {
        return name;
    }

    public Supplier<Codec> getCodecSupplier() {
        return codecSupplier;
    }
}