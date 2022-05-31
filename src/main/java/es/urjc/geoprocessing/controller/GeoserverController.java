package es.urjc.geoprocessing.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("geoserver")
public class GeoserverController extends ParentController<GeoserverController> {

    private static final String GEOSERVER_URL = "localhost";

    @RequestMapping(value = "/**", method = RequestMethod.GET)
    @ResponseBody
    public String mirrorRest(HttpMethod method, HttpServletRequest request) throws Exception {
        URI uri = new URI("http", null, GEOSERVER_URL, 8088, request.getServletPath(), URLDecoder.decode(request.getQueryString(), StandardCharsets.UTF_8.name()), null);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(uri, method, new HttpEntity<>(""), String.class);

        return response.getBody();
    }
}
