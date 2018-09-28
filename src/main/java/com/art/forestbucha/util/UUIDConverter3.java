package com.art.forestbucha.util;

import java.nio.ByteBuffer;
import java.util.UUID;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UUIDConverter3 implements AttributeConverter<UUID, byte[]>{

    @Override
    public byte[] convertToDatabaseColumn(UUID uuid) {
       if (uuid == null)
           return null;
       byte[] buffer = new byte[16];
       ByteBuffer bb = ByteBuffer.wrap(buffer);
       bb.putLong(uuid.getMostSignificantBits());
       bb.putLong(uuid.getLeastSignificantBits());
       return buffer;
    }

    @Override
    public UUID convertToEntityAttribute(byte[] bytes) {
       if (bytes == null)
           return null;
       ByteBuffer bb = ByteBuffer.wrap(bytes);
       long high = bb.getLong();
       long low = bb.getLong();
       return new UUID(high, low);
    }
}
