package org.example.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;
import org.example.common.Starship;

import java.io.IOException;

@Slf4j
public class StarshipDeserializer implements Deserializer<Starship>
{
    private ObjectMapper mapper = new ObjectMapper();

    public Starship deserialize(String topic, byte[] data)
    {
        try
        {
            if (data == null)
            {
                System.out.println("Null received at deserializing.");
                return null;
            }
            else
            {
                System.out.println("Deserializing...");

                return mapper.readValue(data, Starship.class);
            }
        }
        catch (IOException e)
        {
            log.error("Error when deserializing byte[] to Starship.");
            return null;
        }
    }
}
