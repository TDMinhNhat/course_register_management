package dev.skyherobrine.project.backend.resources.admins;

import dev.skyherobrine.project.backend.models.Response;
import org.springframework.http.ResponseEntity;

public interface IResources<S, P> {
    ResponseEntity<Response> add(S s);
    ResponseEntity<Response> update(S s, P p);
    ResponseEntity<Response> delete(P p);
    ResponseEntity<Response> getAll();
    ResponseEntity<Response> getALl(Integer page, Integer size);
    ResponseEntity<Response> getAll(String sort, String order);
    ResponseEntity<Response> getAll(Integer page, Integer size, String sort, String order);
    ResponseEntity<Response> getById(P p);
}
