package cloud.juancamp.aws.utils;

import cloud.juancamp.aws.utils.task.cache.TaskContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class Context {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final TaskContext taskContext = new TaskContext();
    private Map<String, Object> requestParams = new HashMap<>();

    public Context(HttpServletRequest request) throws IOException {
        final String body = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        if (!body.isEmpty()) {
            this.requestParams = objectMapper.readValue(body, Map.class);
        }
        request.getParameterMap().forEach((key, value) -> requestParams.put(key, value[0]));
    }
}
