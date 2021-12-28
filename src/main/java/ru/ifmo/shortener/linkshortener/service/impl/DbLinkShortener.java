package ru.ifmo.shortener.linkshortener.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import ru.ifmo.shortener.linkshortener.LinkRepository;
import ru.ifmo.shortener.linkshortener.entity.LinkEntity;
import ru.ifmo.shortener.linkshortener.model.LongLink;
import ru.ifmo.shortener.linkshortener.model.ShortLink;
import ru.ifmo.shortener.linkshortener.service.LinkShortenerService;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class DbLinkShortener implements LinkShortenerService {
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    private final LinkRepository linkRepository;

    @Override
    public ShortLink shorten(LongLink longLink) {
        String rnd;
        do {
            rnd = randomString(5);
        } while (linkRepository.insert(new LinkEntity(rnd, longLink.getLongLink())) == 0);

        return new ShortLink(rnd);
    }

    @Override
    public Optional<LongLink> expand(ShortLink shortLink) {
        return linkRepository.findById(shortLink.getShortLink())
                .map(e -> new LongLink(e.getLongLink()));
    }

    private String randomString(int len) {
        val rnd = ThreadLocalRandom.current();

        val sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(CHARS.charAt(rnd.nextInt(CHARS.length())));
        }

        return sb.toString();
    }
}
