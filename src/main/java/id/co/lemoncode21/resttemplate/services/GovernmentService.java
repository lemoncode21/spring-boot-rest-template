package id.co.lemoncode21.resttemplate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class GovernmentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.usa.population}")
    private String url;

    //   example get API
    public Object getAllData() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.ACCEPT, "application/json");
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
            HttpEntity entity = new HttpEntity(headers);

            ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<Object>() {});
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //   example POST DELETE UPDATE API
    public Object postAPI(Object request) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.ACCEPT, "application/json");
            headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
            // headers.add(HttpHeaders.AUTHORIZATION, token); add some token if API need Token
            HttpEntity entity = new HttpEntity(request, headers);

            // Change Object to object class according to response API
            // example
            // ResponseEntity<Person> response = restTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<Person>()});

            ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<Object>() {});

            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
