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
        return linkShortenerService.expand(new ShortLink(rnd))
                .map(longLink -> {
                    final HttpHeaders headers = new HttpHeaders();
                    headers.put("Location", List.of(longLink.getLongLink()));

                    return new ResponseEntity<Void>(headers, HttpStatus.MOVED_PERMANENTLY);
                }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
