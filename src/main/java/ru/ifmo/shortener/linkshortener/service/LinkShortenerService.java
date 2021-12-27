package ru.ifmo.shortener.linkshortener.service;

import ru.ifmo.shortener.linkshortener.model.LongLink;
import ru.ifmo.shortener.linkshortener.model.ShortLink;

import java.util.Optional;

public interface LinkShortenerService {
    ShortLink shorten(LongLink longLink);

    Optional<LongLink> expand(ShortLink shortLink);
}
