package com.demo.folders;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.NONE)
enum FolderSize {
    SMALL, MEDIUM, LARGE;

    static String validateAndNormalize(String size) {
        if (size == null) {
            throw new IllegalArgumentException("Size string cannot be null");
        }

        try {
            FolderSize folderSize = FolderSize.valueOf(size.toUpperCase());
            return folderSize.name();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid folder size: " + size);
        }
    }
}
