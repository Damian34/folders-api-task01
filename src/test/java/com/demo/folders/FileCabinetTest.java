package com.demo.folders;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileCabinetTest {

	@Test
	void shouldFindFolderByName() {
		// given
		FileCabinet cabinet = createSampleCabinet();

		// when
		var foundFolder = cabinet.findFolderByName("Folder3");

		// then
		assertTrue(foundFolder.isPresent());
		assertEquals("Folder3", foundFolder.get().getName());
	}

	@Test
	void shouldFindFoldersBySize() {
		// given
		FileCabinet cabinet = createSampleCabinet();

		// when
		var smallFolders = cabinet.findFoldersBySize(FolderSize.SMALL.name());

		// then
		assertEquals(2, smallFolders.size());
	}

	@Test
	void shouldReturnTotalCount() {
		// given
		FileCabinet cabinet = createSampleCabinet();

		// when
		int totalCount = cabinet.count();

		// then
		assertEquals(4, totalCount);
	}

	private FileCabinet createSampleCabinet() {
		return new FileCabinet(List.of(
				new DefaultFolder("Folder1", FolderSize.SMALL.name()),
				new DefaultFolder("Folder2", FolderSize.MEDIUM.name()),
				new DefaultMultiFolder(List.of(
						new DefaultFolder("Folder3", FolderSize.LARGE.name()),
						new DefaultFolder("Folder4", FolderSize.SMALL.name())
				))
		));
	}
}
