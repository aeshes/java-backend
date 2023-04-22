package org.example.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;
import org.example.common.Starship;

@Slf4j
public class StarshipSerializer implements Serializer<Starship>
{
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, Starship starship)
    {
        try
        {
            if (starship == null)
            {
                System.out.println("Null received at serialization");
                return null;
            }

            System.out.println("Serializing...");

            return mapper.writeValueAsBytes(starship);
        }
        catch (Exception e)
        {
            log.error("Error when serializing Starship to byte[]");
            return null;
        }
    }
}
