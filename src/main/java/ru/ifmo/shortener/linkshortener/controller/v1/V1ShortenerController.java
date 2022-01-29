package ru.ifmo.shortener.linkshortener.controller.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.ifmo.shortener.linkshortener.model.LongLink;
import ru.ifmo.shortener.linkshortener.model.ShortLink;
import ru.ifmo.shortener.linkshortener.service.LinkShortenerService;

import java.util.Map;

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
    public ModelAndView expand(@PathVariable String rnd) {
        return linkShortenerService.expand(new ShortLink(rnd))
                .map(longLink -> new ModelAndView("redirect:" + longLink.getLongLink()))
                .orElseGet(() -> new ModelAndView("/404", Map.of("rnd", rnd), HttpStatus.NOT_FOUND));
    }

}
