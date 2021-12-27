package ru.ifmo.shortener.linkshortener.controller.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.shortener.linkshortener.model.LongLink;
import ru.ifmo.shortener.linkshortener.model.ShortLink;
import ru.ifmo.shortener.linkshortener.service.LinkShortenerService;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/")
@RequiredArgsConstructor
public class V1ShortenerController {
    private final LinkShortenerService linkShortenerService;


    @PostMapping("shorten")
    @ResponseBody
    public ShortLink getShortLink(@RequestBody LongLink longLink) {
        return linkShortenerService.shorten(longLink);
    }

    @GetMapping("l/{rnd}")
    public ResponseEntity<Void> expand(@PathVariable String rnd) {
        final Optional<LongLink> expanded = linkShortenerService.expand(new ShortLink(rnd));

        if (expanded.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        final HttpHeaders headers = new HttpHeaders();
        headers.put("Location", List.of(expanded.get().getLongLink()));

        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

}
