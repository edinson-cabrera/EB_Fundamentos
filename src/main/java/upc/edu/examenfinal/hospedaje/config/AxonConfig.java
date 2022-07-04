package upc.edu.examenfinal.hospedaje.config;

import com.thoughtworks.xstream.XStream;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {
    public XStream xstream() {
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        return xstream;
    }
}
