package ru.ifmo.shortener.linkshortener.controller.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.shortener.linkshortener.model.LongLink;
import ru.ifmo.shortener.linkshortener.model.ShortLink;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/")
public class V1ShortenerController {
    private static final String SHORT_MOCK = "rnd";
    public static final String LONG_MOCK = "https://itmo.xmitya.com/";


    @PostMapping("shorten")
    @ResponseBody
    public ShortLink getShortLink(@RequestBody LongLink longLink) {
        return new ShortLink(SHORT_MOCK);
    }

    @GetMapping("l/{rnd}")
    public ResponseEntity<Void> expand(@PathVariable String rnd) {
        final HttpHeaders headers = new HttpHeaders();
        headers.put("Location", List.of(LONG_MOCK));

        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

}
