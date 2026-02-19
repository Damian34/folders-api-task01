package com.demo.folders;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FileCabinet implements Cabinet {
    private final List<Folder> folders;

    /**
     * Idea is very simple. If I need to check folders every method,
     * then I will unpack every MultiFolder beforehand
     */
    FileCabinet(List<Folder> folders) {
        this.folders = folders == null ? Collections.emptyList(): flatFolders(folders);
    }

    @Override
    public Optional<Folder> findFolderByName(String name) {
        return folders.stream()
                .filter(f -> Objects.equals(f.getName(), name))
                .findFirst();
    }

    @Override
    public List<Folder> findFoldersBySize(String size) {
        final String validatedSize = FolderSize.validateAndNormalize(size);
        return folders.stream()
                .filter(f -> Objects.equals(f.getSize(), validatedSize))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return folders.size();
    }

    private List<Folder> flatFolders(List<Folder> folderList) {
        return folderList.stream()
                .flatMap(folder -> {
                    if (folder instanceof MultiFolder multi) {
                        return flatFolders(multi.getFolders()).stream();
                    } else {
                        return Stream.of(folder);
                    }
                })
                .toList();
    }
}
