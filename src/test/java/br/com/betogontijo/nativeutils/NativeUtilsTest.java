package br.com.betogontijo.nativeutils;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import br.com.betogontijo.nativeutils.NativeUtils;

public class NativeUtilsTest {

	@Test(expected = IllegalArgumentException.class)
	public void testLoadLibraryIllegalPath() throws IOException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		NativeUtils.loadLibraryFromJar("libtest.so");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLoadLibraryIllegalPrefix() throws IOException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		NativeUtils.loadLibraryFromJar("/l");
	}

	@Test(expected = FileNotFoundException.class)
	public void testLoadLibraryNonExistentPath() throws IOException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		NativeUtils.loadLibraryFromJar("/libtest.so");
	}

	@Test(expected = NullPointerException.class)
	public void testLoadLibraryNullPath() throws IOException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {
		NativeUtils.loadLibraryFromJar(null);
	}
}
