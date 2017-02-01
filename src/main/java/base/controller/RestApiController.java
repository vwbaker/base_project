package base.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by macrivel on 1/31/17.
 */
public interface RestApiController<T> {
    @GetMapping
    ArrayList<T> readAll();

    @GetMapping("{id}")
    T read(@PathVariable Long id);

    @PostMapping
    T create(@RequestBody T input);

    @DeleteMapping("{id}")
    T destroy(@PathVariable Long id);

    @PutMapping("{id}")
    T update(@PathVariable Long id, @RequestBody T input);
}
