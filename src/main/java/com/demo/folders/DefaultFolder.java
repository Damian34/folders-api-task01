package com.demo.folders;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * yes I would prefers use record here but Folder have get metods
 * and record would have name(), size(), that is incompatible,
 * forcing record with Folder would end
 * with combination of both record and Folder methods, that is pointless.
 */
@Getter
@RequiredArgsConstructor
class DefaultFolder implements Folder {
    private final String name;
    private final String size;
}
